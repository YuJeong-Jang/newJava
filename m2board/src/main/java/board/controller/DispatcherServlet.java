package board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
	private Map<String, AbstractController> actionMap = new HashMap<String, AbstractController>();
	
	
	//서비스 메소드 부르기 전에 init메소드 부터 불러야함
	@Override
	public void init() throws ServletException {
		String props = this.getClass().getResource("dispatcher.properties").getPath();
		Properties pr = new Properties();
		FileInputStream f = null;
		
		try {
			f = new FileInputStream(props);
			pr.load(f);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(f!=null) try {f.close();} catch(Exception e) {}
		}
		
		for(Object obj : pr.keySet()) {
			String key = ((String) obj).trim();					// 예)/BoardInsert.do
			String className = pr.getProperty(key).trim();		// board.controller.BoardInsert
			
			try {
				Class actionClass = Class.forName(className);
				AbstractController controller =  (AbstractController) actionClass.getConstructor().newInstance();
				actionMap.put(key, controller);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String action = requestURI.substring(request.getContextPath().length());
		System.out.println(action);
		
		AbstractController controller = null;
		ModelAndView mav = null;	//ModelAndView에는 다음 이동할 이름과 그 view에 뿌려줄 데이터를 포함
		
		controller = actionMap.get(action);
		mav = controller.handleRequestInternal(request, response);
		
		
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
