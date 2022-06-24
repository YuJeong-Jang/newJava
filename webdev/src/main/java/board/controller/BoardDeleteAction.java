package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDto;

public class BoardDeleteAction extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		Long no = Long.parseLong(request.getParameter("no"));
		String password = request.getParameter("password");
		BoardDto boardDto = new BoardDto();
		
		boardDto.setNo(no);
		boardDto.setPassword(password);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boolean result = boardDAO.deleteBoard(boardDto);
		System.out.println(boardDto);
		if(result) {
			return new ModelAndView("redirect:BoardList.do");
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "글 삭제가 실패했습니다. 비밀번호를 확인하세요.");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}

}
