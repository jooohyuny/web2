package com.yun.jun08tosoj.coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import jhyun.yun.db.manager.YunDBManager;

public class CoffeeDAO {
	private static final CoffeeDAO CDAO = new CoffeeDAO();

	private CoffeeDAO() {
	}

	public static CoffeeDAO getCdao() {
		return CDAO;
	}

	public String get(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = YunDBManager.connect("yunPool");

			String sql = "select * from jun081_coffee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			StringBuffer sb = new StringBuffer();

			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<jun081_coffee>"); // <테이블명>
			while (rs.next()) {
				sb.append("<coffee>"); // <뭐>
										// <필드명>값</필드명>
				sb.append("<c_name>" + rs.getString("c_name") + "</c_name>");
				sb.append("<c_price>" + rs.getInt("c_price") + "</c_price>");
				sb.append("</coffee>"); // </뭐>
			}
			sb.append("</jun081_coffee>"); // </테이블명>
			return sb.toString();

		} catch (Exception e) {
			return null;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}

	}

	public String get2(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");

			String sql = "select * from jun081_coffee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			StringBuilder sbd = new StringBuilder();

			sbd.append("["); // <테이블명>
			while (rs.next()) {
				sbd.append("{"); // <뭐>
				sbd.append("\"c_name\":\"" + rs.getString("c_name") + "\"");
				sbd.append("\"c_price\":\"" + rs.getInt("c_price") + "\"");
				sbd.append("}"); // <뭐>
			}
			sbd.append("]"); // </테이블명>
			return sbd.toString();

		} catch (Exception e) {
			return null;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}
	}

	public String get3(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = YunDBManager.connect("yunPool");

			String sql = "select * from jun081_coffee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			StringBuffer sb = new StringBuffer();

			sb.append("[");
			if (rs.next()) {
				sb.append("{");
				sb.append("\"c_name\":\"" + rs.getString("c_name") + "\",");
				sb.append("\"c_price\":" + rs.getInt("c_price"));
				sb.append("}");
				while (rs.next()) {
					sb.append(",");
					sb.append("{");
					sb.append("\"c_name\":\"" + rs.getString("c_name") + "\",");
					sb.append("\"c_price\":" + rs.getInt("c_price"));
					sb.append("}");
				}
			}
			sb.append("]"); // </테이블명>
			return sb.toString();

		} catch (Exception e) {
			return null;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}

	}

	public String get4(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = YunDBManager.connect("yunPool");

			String sql = "select * from jun081_coffee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			boolean first =true;
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			while (rs.next()) {
				if (first) {
					first = false;
				} else {
					sb.append(",");
				}
				sb.append("{");
				sb.append("\"c_name\":\"" + rs.getString("c_name") + "\",");
				sb.append("\"c_price\":" + rs.getInt("c_price"));
				sb.append("}");
			}
			sb.append("]"); // </테이블명>
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}

	}
}
