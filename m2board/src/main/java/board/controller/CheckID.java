package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.MemberDAO;

public class CheckID extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("user_id");
//		System.out.println("id : " + id);
		MemberDAO memberDAO = MemberDAO.getInstance();
		int count = memberDAO.checkID(id);
		System.out.println("count : " + count);
		return new ModelAndView("/WEB-INF/board/checkid.jsp", "count", count);
	}

}
