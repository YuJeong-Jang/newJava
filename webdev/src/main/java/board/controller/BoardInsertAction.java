package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDto;

public class BoardInsertAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardDto boardDto = new BoardDto();
		
		boardDto.setTitle(title);
		boardDto.setName(name);
		boardDto.setPassword(password);
		boardDto.setContent(content);

		System.out.println(boardDto.toString());
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boolean result = boardDAO.insertBoard(boardDto);
		
		if(result) {
			return new ModelAndView("redirect:BoardList.do");
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "글이 등록을 실패했습니다.");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}

}
