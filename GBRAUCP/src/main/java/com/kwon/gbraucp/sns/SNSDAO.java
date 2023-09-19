package com.kwon.gbraucp.sns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kwon.gbraucp.member.Member;

import kiung.kwon.db.manager.KwonDBManager;

public class SNSDAO {
	private int allMsgCount;
	private int msgPerPage;

	private static final SNSDAO SDAO = new SNSDAO();

	private SNSDAO() {
		msgPerPage = 10;
	}

	public static SNSDAO getSdao() {
		return SDAO;
	}

	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KwonDBManager.connect("kwonPool");

			int no = Integer.parseInt(req.getParameter("no"));

			String sql = "delete from gbraucp_sns where gs_no=?";
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
		KwonDBManager.close(con, pstmt, null);
	}
	
	public void deleteReply(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KwonDBManager.connect("kwonPool");

			int no = Integer.parseInt(req.getParameter("no"));

			String sql = "delete from gbraucp_sns_reply where gsr_no=?";
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
		KwonDBManager.close(con, pstmt, null);
	}

	public void get(int page, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("kwonPool");

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

			String sql = "select gs_no, gm_id, gm_photo, gs_txt, gs_date " + "from ( " + "	select * " + "	from ( "
					+ "		select rownum as rn, gs_no, gs_writer, gs_txt, gs_date " + "		from ( "
					+ "			select * " + "			from gbraucp_sns " + "			where gs_txt like '%'||?||'%' "
					+ "			order by gs_date desc " + "		) " + "	) " + "	where rn >= ? and rn <= ? " + "), ( "
					+ "	select gm_id, gm_photo " + "	from gbraucp_member " + "	where gm_id in ( "
					+ "		select gs_writer " + "		from ( "
					+ "			select rownum as rn, gs_no, gs_writer, gs_txt, gs_date " + "			from ( "
					+ "				select * " + "				from gbraucp_sns "
					+ "				where gs_txt like '%'||?||'%' " + "				order by gs_date desc "
					+ "			) " + "		) " + "		where rn >= ? and rn <= ? " + "	) " + ") "
					+ "where gs_writer = gm_id " + "order by gs_date desc";
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
				msgs.add(new SNSMsg(rs.getInt("gs_no"), rs.getString("gs_txt"), rs.getDate("gs_date"),
						rs.getString("gm_id"), rs.getString("gm_photo")));
			}
			for (SNSMsg snsMsg : msgs) {
				snsMsg.setReplys(
					getReply(snsMsg.getNo())
				);
			}
			req.setAttribute("msgs", msgs);
		} catch (Exception e) {
		}
		KwonDBManager.close(con, pstmt, rs);
	}

	// 글 번호 넣으면
	// 그 글에 달려있는 댓글들
	// ArrayList<댓글>로 리턴하는 메소드
	public ArrayList<SNSReply> getReply(int gsNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("kwonPool");

			String sql = "select * " 
					+ "from gbraucp_sns_reply " 
					+ "where gsr_gs_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gsNo);
			rs = pstmt.executeQuery();
			ArrayList<SNSReply> replys = new ArrayList<>();
			while (rs.next()) {
				replys.add(
					new SNSReply(
						rs.getInt("gsr_no"),			rs.getInt("gsr_gs_no"), 
						rs.getString("gsr_writer"),		rs.getString("gsr_txt"), 
						rs.getDate("gsr_date")
					)
				);
			}
			return replys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KwonDBManager.close(con, pstmt, rs);
		}
	}

	public int getMemberMsgCount(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("kwonPool");
			String sql = "select count(*) from gbraucp_sns where gs_writer=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		} catch (Exception e) {
			return 0;
		} finally {
			KwonDBManager.close(con, pstmt, rs);
		}
	}

	public int getSearchMsgCount(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("kwonPool");
			String sql = "select count(*) from gbraucp_sns where gs_txt like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		} catch (Exception e) {
			return 0;
		} finally {
			KwonDBManager.close(con, pstmt, rs);
		}
	}

	public void search(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}

	public void setAllMsgCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("kwonPool");
			String sql = "select count(*) from gbraucp_sns";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allMsgCount = rs.getInt("count(*)");
		} catch (Exception e) {
		}
		KwonDBManager.close(con, pstmt, rs);
	}

	public void setAllMsgCount(int msgCount) {
		allMsgCount -= msgCount;
	}

	public void update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KwonDBManager.connect("kwonPool");

			int no = Integer.parseInt(req.getParameter("no"));
			String txt = req.getParameter("txt");

			String sql = "update gbraucp_sns " + "set gs_txt=? " + "where gs_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, txt);
			pstmt.setInt(2, no);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글 수정 성공");
			} else {
				req.setAttribute("result", "글 수정 실패");
			}
		} catch (Exception e) {
			req.setAttribute("result", "글 수정 실패");
		}
		KwonDBManager.close(con, pstmt, null);
	}

	public void write(HttpServletRequest req) {
		// 글쓰기 : SNSWriteController?txt=어쩌고
		// 새로고침 : 직전에 했던 요청 그대로 다시하기
		// 글쓸때마다 뭔가 달라질 수 있는거

		// 15:56:00에 글 씀 : 155600
		// 15:57:30에 글 씀 : 155730
		// 15:58:03에 새로고침 : 155730
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("lastToken");

			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "글쓰기 실패(새로고침)");
				return;
			}

			con = KwonDBManager.connect("kwonPool");

			Member m = (Member) req.getSession().getAttribute("loginMember");
			String writer = m.getId();
			String txt = req.getParameter("txt");
			txt = txt.replace("\r\n", "<br>");

			String sql = "insert into gbraucp_sns " + "values(gbraucp_sns_seq.nextval, ?, ?, sysdate)";

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
		KwonDBManager.close(con, pstmt, null);
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

			con = KwonDBManager.connect("kwonPool");

			Member m = (Member) req.getSession().getAttribute("loginMember");
			String id = m.getId();
			int gsNo = Integer.parseInt(req.getParameter("gs_no"));
			String txt = req.getParameter("txt");

			String sql = "insert into gbraucp_sns_reply " + "values(gbraucp_sns_reply_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gsNo);
			pstmt.setString(2, id);
			pstmt.setString(3, txt);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "댓글쓰기 성공");
				req.getSession().setAttribute("lastToken", token);
			}
		} catch (Exception e) {
			req.setAttribute("result", "댓글쓰기 실패");
		}
		KwonDBManager.close(con, pstmt, null);
	}
}
