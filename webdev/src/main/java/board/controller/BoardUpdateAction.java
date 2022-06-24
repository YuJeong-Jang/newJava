package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDto;

public class BoardUpdateAction extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		Long no = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardDto boardDto = new BoardDto();
		
		boardDto.setNo(no);
		boardDto.setTitle(title);
		boardDto.setName(name);
		boardDto.setPassword(password);
		boardDto.setContent(content);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boolean result = boardDAO.updateBoard(boardDto);
		
		if(result) {
			return new ModelAndView("redirect:BoardView.do?no=" + boardDto.getNo());
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "글 수정이 실패했습니다.");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}
}
