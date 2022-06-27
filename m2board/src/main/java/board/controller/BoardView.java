package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardDTO;
import board.model.MemberDTO;

public class BoardView extends AbstractController {

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

		Long no = Long.parseLong(request.getParameter("no"));
		BoardDAO boardDao = BoardDAO.getInstance();
		
		if(boardDao.updateReadCount(no)) {
			BoardDTO boardDto= boardDao.boardView(no);
			boardDto.setContent(boardDto.getContent().replace("\n", "<br>"));
			return new ModelAndView("/WEB-INF/board/content.jsp", "boardDto", boardDto);
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", no + "번 게시물이 존재하지 않습니다.");
			mav.addObject("url", "BoardList.do");
			return mav;
		}
	}
}
