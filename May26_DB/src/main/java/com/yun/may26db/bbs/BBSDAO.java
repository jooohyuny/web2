package com.yun.may26db.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import jhyun.yun.db.manager.YunDBManager;

// 지금은 static으로 해도되지만 나중에 뭐 생길거여서 static기반 포기
public class BBSDAO {
	private int allMsgCount;
	private int msgPerPage;

	private static final BBSDAO BDAO = new BBSDAO();

	private BBSDAO() {
		msgPerPage = 5;
	}

	public static BBSDAO getBdao() {
		return BDAO;
	}

	public void setAllMsgCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = YunDBManager.connect("yunPool");
			String sql = "select count(*) from may261_bbs";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allMsgCount = rs.getInt("count(*)");
			System.out.println("전체 : " + allMsgCount);
		} catch (Exception e) {
		}
		YunDBManager.close(con, pstmt, rs);
	}

	public void get(int page, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");

			int pageCount = (int) Math.ceil(allMsgCount / (double) msgPerPage);
			req.setAttribute("pageCount", pageCount);

			int start = (page - 1) * msgPerPage + 1;
			int end = page * msgPerPage;

			String sql = "select * " + "from(  " + "	select rownum as rn, b_no, b_title, b_date " + "	from (  "
					+ "		select *  " + "		from may261_bbs " + "		order by b_date desc " + "		) " + "	) "
					+ "where rn >=? and rn<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			ArrayList<BBSMsg1> msgs = new ArrayList<>();
			BBSMsg1 bm = null;
			while (rs.next()) {
				bm = new BBSMsg1();
				bm.setNo(rs.getInt("b_no"));
				bm.setTitle(rs.getString("b_title"));
				// bm.setTxt(rs.getString("b_txt"));
				bm.setDate(rs.getDate("b_date"));
				msgs.add(bm);
			}
			req.setAttribute("msgs", msgs); // EL + JSTL

		} catch (Exception e) {
			e.printStackTrace();
		}
		YunDBManager.close(con, pstmt, rs);
	}

	public boolean getDetail(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");

			int no = Integer.parseInt(req.getParameter("no"));
			String sql = "select * from may261_bbs where b_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				BBSMsg bm = new BBSMsg();
				bm.setNo(rs.getInt("b_no"));
				bm.setTitle(rs.getString("b_title"));
				bm.setTxt(rs.getString("b_txt"));
				bm.setDate(rs.getDate("b_date"));
				req.setAttribute("bm", bm);
				return true;
			} else {

				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}
	}

	public void write(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			con = YunDBManager.connect("yunPool");

			// 데이터 확보
			req.setCharacterEncoding("euc-kr");
			String title = req.getParameter("title");
			String txt = req.getParameter("txt");

			// sql(미완성 : 값 들어갈 자리에 ?,;빼고)
			String sql = "insert into may261_bbs values(may261_bbs_seq.nextval,?,?, sysdate)";

			// 총괄매니저객체
			pstmt = con.prepareStatement(sql);

			// ? 채우기
			pstmt.setString(1, title);
			pstmt.setString(2, txt);

			// 실행
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글쓰기 성공");
				allMsgCount++;
			}
		} catch (Exception e) {
			req.setAttribute("result", "글쓰기 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}

	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YunDBManager.connect("yunPool");
			int no = Integer.parseInt(req.getParameter("no"));
			String sql = "delete from may261_bbs where b_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글삭제 성공");
				allMsgCount--;
			} else {
				req.setAttribute("result", "글삭제 실패");
			}
		} catch (Exception e) {
			req.setAttribute("result", "글삭제 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}

	public boolean update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YunDBManager.connect("yunPool");
			req.setCharacterEncoding("euc-kr");
			int no = Integer.parseInt(req.getParameter("no"));
			String title = req.getParameter("title");
			String txt = req.getParameter("txt");

			String sql = "update may261_bbs set b_title=?, b_txt=? where b_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setInt(3, no);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글수정 성공");
				return true;
			} else {
				req.setAttribute("result", "글수정 실패");
				return false;
			}
		} catch (Exception e) {
			req.setAttribute("result", "글수정 실패");
			return false;
		} finally {
			YunDBManager.close(con, pstmt, null);
		}
	}
}
