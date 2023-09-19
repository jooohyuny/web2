package com.yun.may26db.dr;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jhyun.yun.db.manager.YunDBManager;

public class DRDAO {
	private int allFileCount;
	private int filePerPage;

	private static final DRDAO DRDAO = new DRDAO();

	private DRDAO() {
		filePerPage = 8;
	}

	public static DRDAO getDrdao() {
		return DRDAO;
	}

	public void setAllFileCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = YunDBManager.connect("yunPool");
			String sql = "select count(*) from may30_dataroom";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allFileCount = rs.getInt("count(*)");
			System.out.println("전체 : " + allFileCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		YunDBManager.close(con, pstmt, rs);
	}

	public void get(int page, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");

			int pageCount = (int) Math.ceil(allFileCount / (double) filePerPage);
			req.setAttribute("pageCount", pageCount);

			int start = (page - 1) * filePerPage + 1;
			int end = page * filePerPage;

			String sql = "select * " + "from(  " + "	select rownum as rn, d_no, d_title, d_date " + "	from (  "
					+ "		select d_no, d_title, d_date " + "		from may30_dataroom "
					+ "		order by d_date desc " + "		) " + "	) " + "where rn >=? and rn<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			ArrayList<DRFiles> files = new ArrayList<>();
			DRFiles df = null;
			while (rs.next()) {
				df = new DRFiles();
				df.setNo(rs.getInt("d_no"));
				df.setTitle(rs.getString("d_title"));
//				df.setFile(rs.getString("d_file"));
				df.setDate(rs.getDate("d_date"));
				files.add(df);
			}
			req.setAttribute("files", files);

		} catch (Exception e) {
			e.printStackTrace();
		}
		YunDBManager.close(con, pstmt, rs);
	}

	public boolean getDetail(int no,HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");

			String sql = "select * from may30_dataroom where d_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				DRFiles df = new DRFiles();
				df.setNo(rs.getInt("d_no"));
				df.setTitle(rs.getString("d_title"));
				df.setFile(rs.getString("d_file"));
				df.setDate(rs.getDate("d_date"));
				req.setAttribute("df", df);
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

	public void upload(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("drFile");
		System.out.println(path);
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "업로드 실패(파일)");
			return;
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YunDBManager.connect("yunPool");
			String title = mr.getParameter("title");
			String file = URLEncoder.encode(mr.getFilesystemName("file"), "euc-kr").replace("+", " ");

			String sql = "insert into may30_dataroom " + "values(may30_dataroom_seq.nextval, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, file);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "업로드 성공");
			}
		} catch (Exception e) {
			// 이미 파일이 업로드 되어있는 상태 -> 파일 지우기
			File f = new File(path + "/" + mr.getFilesystemName("file"));
			f.delete();
			req.setAttribute("result", "업로드 실패(DB)");
		}
		YunDBManager.close(con, pstmt, null);
	}

	public String getFileName(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("yunPool");
			String sql = "select d_file from may30_dataroom where d_no=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			return URLDecoder.decode(rs.getString("d_file"), "euc-kr");
		} catch (Exception e) {
			return null;
		} finally {
			YunDBManager.close(con, pstmt, rs);
		}
	}

	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YunDBManager.connect("yunPool");
			int no = Integer.parseInt(req.getParameter("no"));
			String fileName = getFileName(no);

			String sql = "delete from may30_dataroom where d_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "파일삭제 성공");
				allFileCount--;
				// 파일 삭제
				String folder = req.getSession().getServletContext().getRealPath("drFile");
				File f = new File(folder + "/" + fileName);
				f.delete();
			} else {
				req.setAttribute("result", "파일삭제 실패");
			}
		} catch (Exception e) {
			req.setAttribute("result", "파일삭제 실패");
		}
		YunDBManager.close(con, pstmt, null);
	}

	public boolean update(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("drFile");
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "업로드 실패(파일)");
			return false;
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		String oldFile = null;
		String newFile = null;
		try {
			con = YunDBManager.connect("yunPool");

			int no = Integer.parseInt(mr.getParameter("no"));
			String title = mr.getParameter("title");
			oldFile = URLEncoder.encode(getFileName(no), "euc-kr").replace("+", " ");
			newFile = mr.getFilesystemName("file");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "euc-kr").replace("+", " ");
			}
			System.out.println(no);
			System.out.println(title);
			System.out.println(oldFile);
			System.out.println(newFile);
			String sql = "update may30_dataroom set d_title=?, d_file=? where d_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, newFile);
			pstmt.setInt(3, no);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "자료수정 성공");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "euc-kr");
					new File(path + "/" + oldFile).delete();
					// 파일 바꾸는 사람 : 옛날 파일 지워야
				}
				return true;
			} else {
				req.setAttribute("result", "자료수정 실패에에");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "euc-kr");
					new File(path + "/" + newFile).delete();
					// 파일 바꾸는 사람 : 새 파일 지워야
				}
				return false;
			}
		} catch (Exception e) {
			req.setAttribute("result", "자료수정 실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "euc-kr");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
				// 파일 바꾸는 사람 : 새 파일 지워야
			}
			return true;
		} finally {
			YunDBManager.close(con, pstmt, null);
		}
	}

	public boolean getDetailFile(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("drFile");
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "업로드 실패(파일)");
			return false;
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		String oldFile = null;
		String newFile = null;
		try {
			con = YunDBManager.connect("yunPool");

			int no = Integer.parseInt(mr.getParameter("no"));
			String title = mr.getParameter("title");
			oldFile = URLEncoder.encode(getFileName(no), "euc-kr").replace("+", " ");
			newFile = mr.getFilesystemName("file");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "euc-kr").replace("+", " ");
			}
	
			String sql = "select * from may30_dataroom where d_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "자료수정 성공");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "euc-kr");
					new File(path + "/" + oldFile).delete();
					// 파일 바꾸는 사람 : 옛날 파일 지워야
				}
				return true;
			} else {
				req.setAttribute("result", "자료수정 실패에에");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "euc-kr");
					new File(path + "/" + newFile).delete();
					// 파일 바꾸는 사람 : 새 파일 지워야
				}
				return false;
			}
		} catch (Exception e) {
			req.setAttribute("result", "자료수정 실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "euc-kr");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
				// 파일 바꾸는 사람 : 새 파일 지워야
			}
			return true;
		} finally {
			YunDBManager.close(con, pstmt, null);
		}
	}
}
