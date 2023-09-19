package com.kwon.gbraucp.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.kwon.gbraucp.sns.SNSDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kiung.kwon.db.manager.KwonDBManager;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getMdao() {
		return MDAO;
	}

	public void bye(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KwonDBManager.connect("kwonPool");
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String id = m.getId();
			int msgCount = SNSDAO.getSdao().getMemberMsgCount(id);
			
			String sql = "delete from gbraucp_member where gm_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "탈퇴 성공");
				String path = req.getSession().getServletContext().getRealPath("img");
				String photo = URLDecoder.decode(m.getPhoto(), "euc-kr");
				new File(path + "/" + photo).delete();
				
				SNSDAO.getSdao().setAllMsgCount(msgCount);
			} else {
				req.setAttribute("result", "탈퇴 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴 실패");
		}
		KwonDBManager.close(con, pstmt, null);
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
		String path = req.getSession().getServletContext().getRealPath("img");
		try {
			mr = new MultipartRequest(req, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "가입 실패(파일)");
			return;
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KwonDBManager.connect("kwonPool");

			// req.getParameter("요청파라메터변수명")
			// mr.getParameter("input의 name")
			// mr.getParameter("...?요청파라메터변수명=값")
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");

			String y = mr.getParameter("y");
			int mm = Integer.parseInt(mr.getParameter("m"));
			int dd = Integer.parseInt(mr.getParameter("d"));
			String birthday = String.format("%s%02d%02d", y, mm, dd);

			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr2 + "!" + addr3 + "!" + addr1;

			String photo = URLEncoder.encode(mr.getFilesystemName("photo"), "euc-kr").replace("+", " ");

			String sql = "insert into gbraucp_member values(?, ?, ?, to_date(?, 'YYYYMMDD'), ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, birthday);
			pstmt.setString(5, addr);
			pstmt.setString(6, photo);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "가입 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패(DB)");
			new File(path + "/" + mr.getFilesystemName("photo")).delete();
		}
		KwonDBManager.close(con, pstmt, null);
	}

	public void login(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("kwonPool");

			req.setCharacterEncoding("euc-kr");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");

			String sql = "select * from gbraucp_member where gm_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// rs.getXXX("DB필드명")
				String dbPw = rs.getString("gm_pw");
				if (pw.equals(dbPw)) {
					Member m = new Member(id, pw, rs.getString("gm_name"), rs.getDate("gm_birthday"),
							rs.getString("gm_addr"), rs.getString("gm_photo"));
					req.getSession().setAttribute("loginMember", m);
					req.getSession().setMaxInactiveInterval(15 * 60);
				} else {
					req.setAttribute("result", "로그인 실패(PW)");
				}
			} else {
				req.setAttribute("result", "로그인 실패(미가입ID)");
			}
		} catch (Exception e) {
			req.setAttribute("result", "로그인 실패(DB)");
		}
		KwonDBManager.close(con, pstmt, rs);
	}

	public void logout(HttpServletRequest req) {
		// 세션 끊기
		// 로그인 정보말고 세션에 넣어놓은 다른 것들도 다 날아갈테니
		// req.getSession().setMaxInactiveInterval(-1);
		req.getSession().setAttribute("loginMember", null);
	}

	public void splitAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getAddress();
		String[] addrArr = addr.split("!");
		req.setAttribute("addr1", addrArr[2]);
		req.setAttribute("addr2", addrArr[0]);
		req.setAttribute("addr3", addrArr[1]);
	}
	
	public void update(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("img");
		try {
			mr = new MultipartRequest(req, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "수정 실패(파일)");
			return;
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String oldFile = null;
		String newFile = null;
		try {
			con = KwonDBManager.connect("kwonPool");
			
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
			
			String sql = "update gbraucp_member "
					+ "set gm_pw=?, gm_name=?, gm_addr=?, gm_photo=? "
					+ "where gm_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);		pstmt.setString(2, name);	
			pstmt.setString(3, addr);	pstmt.setString(4, newFile);
			pstmt.setString(5, id);
			System.out.println(path);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "수정 성공");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "euc-kr");
					new File(path + "/" + oldFile).delete();
				}
				m.setPw(pw);		m.setName(name);
				m.setAddress(addr);	m.setPhoto(newFile);
				req.getSession().setAttribute("loginMember", m);
			} else {
				req.setAttribute("result", "수정 실패");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "euc-kr");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			req.setAttribute("result", "수정 실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "euc-kr");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		}
		KwonDBManager.close(con, pstmt, null);
	}
}















