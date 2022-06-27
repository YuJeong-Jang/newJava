package board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO { // DAO(Data Access Object)
	private static MemberDAO memberDAO = null;

	private MemberDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
	}

	public static MemberDAO getInstance() {
		if (memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}

	private void dbClose(Connection cn, PreparedStatement ps, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (cn != null)
			try {
				cn.close();
			} catch (Exception e) {
			}
	}

	private void dbClose(Connection cn, PreparedStatement ps) {
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (cn != null)
			try {
				cn.close();
			} catch (Exception e) {
			}
	}

	public int checkID(String id) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int result = -1;

		String sql = "select count(*) as cnt from TBL_MEMBER where id=?";

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps, rs);
		}
		return result;
	}

	public boolean registerMember(MemberDTO memberDto) {
		Connection cn = null;
		PreparedStatement ps = null;
		
		boolean result = false;
		
		String sql = "insert into tbl_member(id, password, name, birth, phone, zipcode, address1, address2) values(?,?,?,?,?,?,?,?)";
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, memberDto.getId());
			ps.setString(2, memberDto.getPassword());
			ps.setString(3, memberDto.getName());
			ps.setString(4, memberDto.getBirth());
			ps.setString(5, memberDto.getPhone());
			ps.setString(6, memberDto.getZipcode());
			ps.setString(7, memberDto.getAddress1());
			ps.setString(8, memberDto.getAddress2());
			
			ps.executeUpdate();
			
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}
		return result;
	}

	public MemberDTO getUser(MemberDTO memberDto) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		MemberDTO userInfo = null;
		
		String sql = "select id, name from tbl_member where id=? and password=?";
		
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, memberDto.getId());
			ps.setString(2, memberDto.getPassword());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				userInfo = new MemberDTO();
				userInfo.setId(rs.getString("id"));
				userInfo.setName(rs.getString("name"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps, rs);
		}
		
		return userInfo;
	}
}
