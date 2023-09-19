package com.yun.ywp.sns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.yun.ywp.member.Member;

import jhyun.yun.db.manager.YunDBManager;

public class SNSDAO {
	private int allMsgCount;
	private int msgPerPage;

	private static final SNSDAO SDAO = new SNSDAO();

	private SNSDAO() {
		msgPerPage = 5;
	}

	public static SNSDAO getSdao() {
		return SDAO;
	}

	// 글쓰기 : SNSWriteController?txt=어쩌고
	// 새로고침 : 직전에 했던 요청 그대로 다시하기

	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	public void setAllMsgCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = YunDBManager.connect("yunPool");
			String sql = "select count(*) from yunwebproject_sns";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allMsgCount = rs.getInt("count(*)");
			System.out.println("전체 : " + allMsgCount);
		} catch (Exception e) {
		}
		YunDBManager.close(con, pstmt, rs);
	}

	public void setAllMsgCount(int msgCount) {
		allMsgCount -= msgCount;
	}
	
	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = YunDBManager.connect("yunPool");

			int no = Integer.parseInt(req.getParameter("no"));

			String sql = "delete from yunwebproject_sns where ys_no=?";
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
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = YunDBManager.connect("yunPool");

			int no = Integer.parseInt(req.getParameter("no"));

			String sql = "delete from yunwebproject_sns_reply where ysr_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "댓글 삭제 성공");
			} else {
				req.setAttribute("result", "댓글 삭제 실패");
			}
		} catch (Exception e) {
			req.setAttribute("result", "댓글 삭제 실패");
		}
		YunDBManager.close(con, pstmt, null);
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

			String sql = "insert into yunwebproject_sns " + "values(yunwebproject_sns_seq.nextval, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, txt);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글쓰기 성공");
				req.getSession().setAttribute("lastToken", token);
				allMsgCount++;
			}
		} catch (Exception e) {
			req.setAttribute("result", "글쓰기 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}

	public void writeReply(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("lastToken");
			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "댓글쓰기 실패");
				return;
			}

			con = YunDBManager.connect("yunPool");

			Member m = (Member) req.getSession().getAttribute("loginMember");
			String id = m.getId();
			int ysNo = Integer.parseInt(req.getParameter("ys_no"));
			String txt = req.getParameter("txt");

			String sql = "insert into yunwebproject_sns_reply " + "values(yunwebproject_sns_reply_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ysNo);
			pstmt.setString(2, id);
			pstmt.setString(3, txt);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "댓글쓰기 성공");
				req.getSession().setAttribute("lastToken", token);
			}
		} catch (Exception e) {
			req.setAttribute("result", "댓글쓰기 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}
	
	public void get(int page, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");

			String search = (String) req.getSession().getAttribute("search");
			int msgCount = allMsgCount;
			if (search == null) {
				search = "";
			} else {
				msgCount = getSearchMsgCount(search);
			}

			int pageCount = (int) Math.ceil(msgCount / (double) msgPerPage);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);

			int start = (page - 1) * msgPerPage + 1;
			int end = msgPerPage * page;

			String sql = "select ys_no, ym_id, ym_photo, ys_txt, ys_date " + "from ( " + "	select * " + "	from ( "
					+ "		select rownum as rn, ys_no, ys_writer, ys_txt, ys_date " + "		from ( "
					+ "			select * " + "			from yunwebproject_sns "
					+ "			where ys_txt like '%'||?||'%' " + "			order by ys_date desc " + "		) " + "	) "
					+ "	where rn >= ? and rn <= ? " + "), ( " + "	select ym_id, ym_photo "
					+ "	from yunwebproject_member " + "	where ym_id in ( " + "		select ys_writer " + "		from ( "
					+ "			select rownum as rn, ys_no, ys_writer, ys_txt, ys_date " + "			from ( "
					+ "				select * " + "				from yunwebproject_sns "
					+ "				where ys_txt like '%'||?||'%' " + "				order by ys_date desc "
					+ "			) " + "		) " + "		where rn >= ? and rn <= ? " + "	) " + ") "
					+ "where ys_writer = ym_id " + "order by ys_date desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			pstmt.setString(4, search);
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rs = pstmt.executeQuery();

			ArrayList<SNSMsg> msgs = new ArrayList<>();
			while (rs.next()) {
				msgs.add(new SNSMsg(rs.getInt("ys_no"), rs.getString("ys_txt"), rs.getDate("ys_date"),
						rs.getString("ym_id"), rs.getString("ym_photo")));
			}
			for (SNSMsg snsMsg : msgs) {
				snsMsg.setReplys(
						getReply(snsMsg.getNo())
				);
			}
			req.setAttribute("msgs", msgs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		YunDBManager.close(con, pstmt, rs);
	}

	public ArrayList<SNSReply> getReply(int ysNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");

			String sql = "select * " + "from yunwebproject_sns_reply " + "where ysr_ys_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ysNo);
			rs = pstmt.executeQuery();
			ArrayList<SNSReply> replys = new ArrayList<>();
			while (rs.next()) {
				replys.add(new SNSReply(rs.getInt("ysr_no"), rs.getInt("ysr_ys_no"), rs.getString("ysr_writer"),
						rs.getString("ysr_txt"), rs.getDate("ysr_date")));
			}
			return replys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}
	}
	
	public int getSearchMsgCount(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = YunDBManager.connect("yunPool");
			String sql = "select count(*) from yunwebproject_sns where ys_txt like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}
	}
	
	public void search(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}
	public void update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = YunDBManager.connect("yunPool");
			int no = Integer.parseInt(req.getParameter("no"));
			String txt = req.getParameter("txt");

			String sql = " update yunwebproject_sns set ys_txt=? where ys_no=?";
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

	public int getMemberMsgCount(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = YunDBManager.connect("yunPool");
			String sql = "select count(*) from yunwebproject_member";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}
	}


	

}
