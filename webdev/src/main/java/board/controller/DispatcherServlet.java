package board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	
	//서비스 메소드 부르기 전에 init메소드 부터 불러야함
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String action = requestURI.substring(request.getContextPath().length());
		System.out.println(action);
		
		AbstractController controller = null;
		ModelAndView mav = null;	//ModelAndView에는 다음 이동할 이름과 그 view에 뿌려줄 데이터를 포함
		
		if(action.equals("/BoardInsert.do")) {
			controller = new BoardInsert();
			mav = controller.handleRequestInternal(request, response);
		}else if(action.equals("/BoardInsertAction.do")) {
			controller = new BoardInsertAction();
			mav = controller.handleRequestInternal(request, response);
		}else if(action.equals("/BoardList.do")) {
			controller = new BoardList();
			mav = controller.handleRequestInternal(request, response);
		}
		
		if(mav!=null) {
			String viewName = mav.getViewName();
			
			if(viewName.startsWith("redirect:")) {
				response.sendRedirect(viewName.substring("redirect:".length()));
				return;	//서비스 메서드 강제종료
			}
			
			Map<String, Object> model = mav.getModel();
			for(String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(mav.getViewName());
			dispatcher.forward(request, response);			
		} else {
			System.out.println("DispatcherServlet에서 길을 일코말아쑴당....");
		}
		
	}
}
