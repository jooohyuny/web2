package com.yun.jun08tosoj.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import jhyun.yun.db.manager.YunDBManager;

public class SnackDAO {
	private static final SnackDAO SDAO = new SnackDAO();

	private SnackDAO() {
	}

	public static SnackDAO getSdao() {
		return SDAO;
	}

	public void get(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");

			String sql = "select * from jun081_snack";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Snack> snacks = new ArrayList<>();
			while (rs.next()) {
				snacks.add(new Snack(rs.getString("s_name"), rs.getInt("s_price")));
			}
			
			req.setAttribute("ssnack", snacks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		YunDBManager.close(con, pstmt, rs);
	}
	
	// 제3자(웹브라우저 아님)에게 데이터 주려면
	// => 글자 한덩어리로 만들어서 응답
	// => 데이터 주는쪽과 받는쪽과 약속된 형식이 필요할것
	// => 국제표준형식
	//		데이터를 html모양 빌려서 표현 : XML
	//		데이터를 javascript모양 빌려서 표현 : JSON
	public String get2(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");
			
			String sql = "select * from jun081_snack";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<jun081_snack>");	// <테이블명>
			while (rs.next()) {
				sb.append("<snack>");		// <뭐>
													// <필드명>값</필드명>
				sb.append("<s_name>" + rs.getString("s_name") + "</s_name>");
				sb.append("<s_price>" + rs.getInt("s_price") + "</s_price>");
				sb.append("</snack>");		// </뭐>
			}
			sb.append("</jun081_snack>");	// </테이블명>
			return sb.toString();
		} catch (Exception e) {
			return null;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}
	}
}















