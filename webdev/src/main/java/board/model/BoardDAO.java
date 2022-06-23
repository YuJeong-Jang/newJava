package board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public boolean insertBoard(BoardDto boardDto) {	//글쓰기
		String sql = "insert into m1board(no, title, name, password, content) values(m1board_seq.nextval, ?, ?, ?, ?)";
		boolean result = false;
		
		Connection cn = null;
		PreparedStatement ps = null; //sql 쿼리를 실행하는 객체 참조
		try {
		cn = getConnection();
		ps = cn.prepareStatement(sql);
		ps.setString(1, boardDto.getTitle());
		ps.setString(2, boardDto.getName());
		ps.setString(3, boardDto.getPassword());
		ps.setString(4, boardDto.getContent());
		ps.executeUpdate();	//sql 쿼리 실행(글쓰기, 수정, 삭제는 update, 읽기는 executeQuery)
		
		result = true;
		} catch (Exception e) {
		e.printStackTrace();
		} finally {	//얻어온 자원 역순으로 해제
			dbClose(cn, ps);
		}
		return result;
	}
	
	public List<BoardDto> getBoardList() {	//리스트
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	//결과데이터를 담고있는 객체를 참조
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		String sql = "select no, title, name, TO_CHAR(writeday, 'yyyy-mm-dd') as writeday, readcount from m1board order by 1 desc";	//글번호 역순으로 정렬(최신글이 위로)
		try{
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setName(rs.getString("name"));
				boardDto.setWriteDay(rs.getDate("writeday"));
				boardDto.setReadCount(rs.getInt("readcount"));
				
				list.add(boardDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			dbClose(cn, ps, rs);
		}
		return list;
	}

	public BoardDto getBoardView(Long no) {	//상세보기
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		BoardDto boardDto = null;
		String sql = "select no, title, name, content, writeday, readcount from m1board where no = ?";
		
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				boardDto = new BoardDto();
				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setName(rs.getString("name"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setWriteDay(rs.getDate("writeday"));
				boardDto.setReadCount(rs.getInt("readcount"));
			}
		} catch(Exception e) {
			
		} finally {
			dbClose(cn, ps, rs);
		}
		return boardDto;
	}
	
	public boolean updateReadCount(Long no) {	//조회수 증가
		Connection cn = null;
		PreparedStatement ps = null;
		
		String sql = "update m1board set readcount = readcount + 1 where no = ?";
		
		boolean result = false;
		
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, no);
			if(ps.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}
		return result;
	}

	public boolean updateBoard(BoardDto boardDto) {	//수정
		Connection cn = null;
		PreparedStatement ps = null;
		
		String sql = "update m1board set title=?, name=?, content=? where no=? and password=?";
		boolean result = false;
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getName());
			ps.setString(3, boardDto.getContent());
			ps.setLong(4, boardDto.getNo());
			ps.setString(5, boardDto.getPassword());
			
			if(ps.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}
		return result;
	}
	
	public boolean deleteBoard(BoardDto boardDto) {	//삭제
		Connection cn = null;
		PreparedStatement ps = null;
		
		String sql = "delete from m1board where no=? and password=?";
		
		boolean result = false;
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, boardDto.getNo());
			ps.setString(2, boardDto.getPassword());
			
			if(ps.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}
		return result;
	}
}
