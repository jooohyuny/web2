package com.yun.ywp.cyworld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.yun.ywp.member.Member;

import jhyun.yun.db.manager.YunDBManager;

public class CWDAO {
	private int allMsgCount;
	private int msgPerPage;
	
	private static final CWDAO CWDAO = new CWDAO();
	
	private CWDAO() {
		msgPerPage = 4;
	}

	public static CWDAO getCwdao() {
		return CWDAO;
	}
	
	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	
	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = YunDBManager.connect("yunPool");
			
			int no = Integer.parseInt(req.getParameter("no"));
			
			String sql = "delete from yunwebproject_cw where ycw_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글 삭제 성공");
				allMsgCount--;
			} else {
				req.setAttribute("result", "글 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글 삭제 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}
	
	public void deleteReply(HttpServletRequest req) {
		
	}
	
	public void write(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("lastToken");
			
			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "글쓰기 실패(새로고침)");
				return;
			}
			
			con = YunDBManager.connect("yunPool");
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String writer = m.getId();
			String txt = req.getParameter("txt");
			txt = txt.replace("\r\n", "<br>");
			
			String sql = "insert into yunwebproject_cw values(yunwebproject_cw_seq.nextval,?,?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, txt);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글쓰기 성공");
				req.getSession().setAttribute("lastToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글쓰기 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}
	
	public void writeReply(HttpServletRequest req) {
		
	}
	
	public void get(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = YunDBManager.connect("yunPool");
			
			String sql = "select * from yunwebproject_cw";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<CWMsg> msgs = new ArrayList<>();
			while(rs.next()) {
				msgs.add(new CWMsg(rs.getInt("ycw_no"),rs.getString("ycw_txt"),rs.getDate("ycw_date"),
						rs.getString("ym_id"), rs.getString("ym_photo")));
			}
			for (CWMsg cwMsg : msgs) {
			
			}
			req.setAttribute("msgs", msgs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		YunDBManager.close(con, pstmt, rs);
	}
	
	public void search(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}
	
	public void setAllCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");
			String sql = "select count(*) from yunwebproject_cw";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allMsgCount = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		YunDBManager.close(con, pstmt, rs);
	}
	
	
	public void update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = YunDBManager.connect("yunPool");
			int no = Integer.parseInt(req.getParameter("no"));
			String txt = req.getParameter("txt");

			String sql = " update yunwebproject_cw set ycw_txt=? where ycw_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, txt);
			pstmt.setInt(2, no);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글 수정 성공");
			} else {
				req.setAttribute("result", "글 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글 수정 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}
	
}
