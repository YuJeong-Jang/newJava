package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Youare extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("name : " + name + ", age : " + age);
		
		String youare = say(name, age);
		
		request.setAttribute("who", youare);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ajax01/whoYouAre.jsp");
		dispatcher.forward(request, response);
	}

	private String say(String name, int age) {
		String msg = null;

		if(name.equals("김연아")) {
			msg = "그래 난 " + age + "세, " + name + ". 피겨요정이지!";
		} else if(name.equals("김연경")) {
			msg = "그래 난 " + age + "세, " + name + ". 배구황제지!";
		} else if(name.equals("윤두준")) {
			msg = "그래 난 " + age + "세, " + name + ". 먹보지!";
		} else {
			msg = "그래 난 " + age + "세, " + name + ". 똥멍충이지...ㅠ";
		}
		return msg;
	}
}
