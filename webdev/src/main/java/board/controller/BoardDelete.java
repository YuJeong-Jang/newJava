package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDelete extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		Long no = Long.parseLong(request.getParameter("no"));
		
		return new ModelAndView("/WEB-INF/board/delete.jsp", "no", no);
	}

}
