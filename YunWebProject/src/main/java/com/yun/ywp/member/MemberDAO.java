package com.yun.ywp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jhyun.yun.db.manager.YunDBManager;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();

	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getMdao() {
		return MDAO;
	}

	public boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/logined.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}

	public void join(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("imgg");
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "가입 실패(파일)");
			return;
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YunDBManager.connect("yunPool");
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String y = mr.getParameter("y");
			int m = Integer.parseInt(mr.getParameter("m"));
			int d = Integer.parseInt(mr.getParameter("d"));
			String birth = String.format("%s%02d%02d", y, m, d);

			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr2 + "!" + addr3 + "!" + addr1;

			String photo = URLEncoder.encode(mr.getFilesystemName("photo"), "euc-kr").replace("+", " ");

			String sql = "insert into YUNWEBPROJECT_MEMBER values(?,?,?,to_date(?,'YYYYMMDD'),?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, birth);
			pstmt.setString(5, addr);
			pstmt.setString(6, photo);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "가입 성공");
			}
		} catch (Exception e) {
			new File(path + "/" + mr.getFilesystemName("photo")).delete();
			req.setAttribute("result", "가입 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}

	public void login(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = YunDBManager.connect("yunPool");
			req.setCharacterEncoding("euc-kr");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");

			String sql = "select * from yunwebproject_member where ym_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbpw = rs.getString("ym_pw");
				if (pw.equals(dbpw)) {
					Member m = new Member(id, pw, rs.getString("ym_name"), rs.getDate("ym_birthday"),
							rs.getString("ym_addr"), rs.getString("ym_photo"));
					req.getSession().setAttribute("loginMember", m);
					req.getSession().setMaxInactiveInterval(15*60);
				} else {
					req.setAttribute("result", "로그인 실패(pw 오류)");
				}
			} else {
				req.setAttribute("result", "로그인 실패(미가입 ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "로그인 실패(DB)");
		}
		YunDBManager.close(con, pstmt, rs);
	}

	public void logout(HttpServletRequest req) {
		// 세션 끊기
		// 로그인 정보말고 세션에 넣어놓은 다른 것들도 다 날아갈테니
		// req.getSession().setMaxInactiveInterval(-1);
		req.getSession().setAttribute("loginMember", null);
	}

	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YunDBManager.connect("yunPool");

			Member m = (Member) req.getSession().getAttribute("loginMember");
			String id = m.getId();

			String sql = "delete from yunwebproject_member where ym_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "회원탈퇴 성공");
				String path = req.getSession().getServletContext().getRealPath("imgg");
				String photo = URLDecoder.decode(m.getPhoto(), "euc-kr");
				new File(path + "/" + photo).delete();
			} else {
				req.setAttribute("result", "회원탈퇴 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "회원탈퇴 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}

	public void splitAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getAddr();
		String[] addrArr = addr.split("!");
		req.setAttribute("addr1", addrArr[2]);
		req.setAttribute("addr2", addrArr[0]);
		req.setAttribute("addr3", addrArr[1]);
	}

	public void update(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("imgg");
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "정보수정실패");
			return;
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		String oldFile = null;
		String newFile = null;
		try {
			con = YunDBManager.connect("yunPool");

			Member m = (Member) req.getSession().getAttribute("loginMember");
			String id = m.getId();
			oldFile = m.getPhoto();
			newFile = mr.getFilesystemName("photo");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "euc-kr").replace("+", " ");
			}

			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr2 + "!" + addr3 + "!" + addr1;

			String sql = "update yunwebproject_member set ym_pw=?, ym_name=?, " + "ym_addr=?, ym_photo=? "
					+ "where ym_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, newFile);
			pstmt.setString(5, id);
			System.out.println(path);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "정보수정 성공");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "euc-kr");
					new File(path + "/" + oldFile).delete();
				}
				m.setPw(pw);		m.setAddr(name);
				m.setAddr(addr);	m.setPhoto(newFile);
				req.getSession().setAttribute("loginMember", m);
			} else {
				req.setAttribute("result", "정보수정 실패");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(newFile, "euc-kr");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "정보수정 실패");
			if(!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "euc-kr");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		} 
		YunDBManager.close(con, pstmt, null);
	}

}
