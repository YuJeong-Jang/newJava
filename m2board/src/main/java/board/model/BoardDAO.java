package board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO { // DAO(Data Access Object)
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
		if (boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
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

	public boolean insertBoard(BoardDTO boardDto) {
		Connection cn = null;
		PreparedStatement ps = null;

		String sql = "insert into tbl_board(no, title, content, id) values(seq_board.nextval,?,?,?)";

		boolean result = false;

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getContent());
			ps.setString(3, boardDto.getMemberDto().getId());
			ps.executeUpdate();

			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}

		return result;
	}

	public List<BoardDTO> getBoardList(Long startnum, Long endnum) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BoardDTO> list = new ArrayList<BoardDTO>();

		String sql = "SELECT B.* " + "	FROM (SELECT rownum AS rnum, A.* " + "		FROM (SELECT b.no, b.title, m.id, "
				+ "			case when to_char(b.regdate, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD') "
				+ "			then to_char(b.regdate, 'HH24:MI:SS')  "
				+ "			else to_char(b.regdate, 'YYYY-MM-DD') end AS regdate, b.readcount, m.name "
				+ "				FROM tbl_board b join tbl_member m " + "		ON b.id = m.id "
				+ "	ORDER BY no DESC) A) B " + "WHERE ?<=rnum AND rnum<=? ";
//		String sql = "select b.no, b.title, b.id, b.regdate, b.readcount, m.name from TBL_BOARD b join tbl_member m on b.id=m.id order by 1 desc";

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, startnum);
			ps.setLong(2, endnum);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDTO boardDto = new BoardDTO();
				MemberDTO memberDto = new MemberDTO();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));

				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setReadcount(rs.getInt("readcount"));

				boardDto.setMemberDto(memberDto);
				list.add(boardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps, rs);
		}

		return list;
	}

	public BoardDTO boardView(Long no) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select b.no, b.title, b.content, b.id, m.name, b.regdate, b.readcount from tbl_board b join tbl_member m on b.id=m.id where b.no=?";

		BoardDTO boardDto = null;

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, no);
			rs = ps.executeQuery();

			if (rs.next()) {
				MemberDTO memberDto = new MemberDTO();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));

				boardDto = new BoardDTO();
				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setReadcount(rs.getInt("readcount"));
				boardDto.setMemberDto(memberDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps, rs);
		}
		return boardDto;
	}

	public boolean updateReadCount(Long no) {
		Connection cn = null;
		PreparedStatement ps = null;

		String sql = "update tbl_board set readcount = readcount + 1 where no = ?";

		boolean result = false;
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, no);

			if (ps.executeUpdate() > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}
		return result;
	}

	public boolean UpdateBoard(BoardDTO boardDto) {
		Connection cn = null;
		PreparedStatement ps = null;

		String sql = "update tbl_board set title=?, content=? where no=? and id=?";

		boolean result = false;
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getContent());
			ps.setLong(3, boardDto.getNo());
			ps.setString(4, boardDto.getMemberDto().getId());

			if (ps.executeUpdate() > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}
		return result;
	}

	public boolean deleteBoard(BoardDTO boardDto) {
		Connection cn = null;
		PreparedStatement ps = null;

		String sql = "delete from tbl_board where no=? and id=?";

		boolean result = false;
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, boardDto.getNo());
			ps.setString(2, boardDto.getMemberDto().getId());

			if (ps.executeUpdate() > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}
		return result;
	}

	public long getRecordCount() {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		long result = 0L;
		String sql = "select count(*) as cnt from tbl_board";
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getLong("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps, rs);
		}
		return result;
	}

}
