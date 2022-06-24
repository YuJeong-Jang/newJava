package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDto;

public class BoardView extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		Long no = Long.parseLong(request.getParameter("no"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		if(boardDAO.updateReadCount(no)) {
			BoardDto boardDto = boardDAO.getBoardView(no);
			return new ModelAndView("/WEB-INF/board/content.jsp", "boardDto", boardDto);	//(이동경로, 키(변수), 벨류(실제 넘기는 데이터))
		} else {
			ModelAndView mav =  new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", no + "번 게시물이 존재하지 않습니다.");
			mav.addObject("url", "BoardList.do");
			return mav;
		}
	}

}
