package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardDTO;
import board.model.MemberDTO;

public class BoardList extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		/* 세션정보 */
		HttpSession session = request.getSession();
		MemberDTO userInfo = (MemberDTO) session.getAttribute("userInfo");

		if (userInfo == null) { // 세션정보없음(로그인하지 않았거나, 이미 로그아웃한 경우)
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "먼저 로그인 하셔야 합니다.");
			mav.addObject("url", "Login.do");
			return mav;
		}
		/* 세션정보 끝 */

		Long pg = 1L; // pg값이 넘어오지 않으면 디폴트 값
		if (request.getParameter("pg") != null) {
			pg = Long.parseLong(request.getParameter("pg"));
		}

		/* 게시물의 페이징 */
		int pageSize = 10; // 한 페이지의 게시물 수
		long startnum = (pg - 1) * pageSize + 1; // 페이지의 시작번호
		long endnum = pg * pageSize; // 페이지의 끝번호

		String logInfo = userInfo.getName() + "(" + userInfo.getId() + ")님이 로그인하였습니다.";
		BoardDAO boardDao = BoardDAO.getInstance();
		long recordCount = boardDao.getRecordCount(); 	// 전체 레코드 수
		long pageCount = recordCount / pageSize; 		// 전체 페이지 수
		if (recordCount % pageSize != 0) pageCount++;	//자투리가 있는 경우
				
		/* 페이징블럭의 페이징 */
		int blockSize = 10;												//한 블럭의 페이지 수
		long startPage = (pg-1) / blockSize * blockSize +1;				//현재 블럭의 첫 페이지
		long endPage = (pg-1) / blockSize * blockSize + blockSize;		//현재 블럭의 마지막 페이지
		if(endPage > pageCount) endPage = pageCount;
		
		List<BoardDTO> list = boardDao.getBoardList(startnum, endnum);

//		for(BoardDTO dto : list) {
//			System.out.println(dto);
//		}
		ModelAndView mav = new ModelAndView("/WEB-INF/board/list.jsp");
		mav.addObject("logInfo", logInfo);
		mav.addObject("list", list);
		mav.addObject("pageCount", pageCount);
		mav.addObject("pg", pg);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		return mav;
	}

}
