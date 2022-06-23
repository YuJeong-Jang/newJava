package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDto;

public class BoardList extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDto> list = boardDAO.getBoardList();
		return new ModelAndView("/WEB-INF/board/list.jsp", "list", list);
	}

}
