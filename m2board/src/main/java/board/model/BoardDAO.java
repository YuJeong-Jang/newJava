package board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {	//DAO(Data Access Object)
	private static BoardDAO boardDAO = null;
	
	private BoardDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
	}

	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	private void dbClose(Connection cn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) try{rs.close();} catch(Exception e) {}
		if(ps != null) try{ps.close();} catch(Exception e) {}
		if(cn != null) try{cn.close();} catch(Exception e) {}		
	}

	private void dbClose(Connection cn, PreparedStatement ps) {
		if(ps != null) try{ps.close();} catch(Exception e) {}
		if(cn != null) try{cn.close();} catch(Exception e) {}		
	}
}
