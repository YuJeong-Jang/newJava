package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int you = Integer.parseInt(request.getParameter("you"));
	    int com = (int)(Math.random()*3)+1;
	    String winner = ""; 
	    
//	    System.out.println(you + ", " + com);
	    request.setAttribute("you", choose(you));	//request.setAttribute(오브젝트이름명명, 실제오브젝트)
	    request.setAttribute("com", choose(com));
	    
	    if(you == 1 && com == 3 || you == 2 && com == 1 || you == 3 && com == 2) {
	    	winner = "당신의 승리입니다.";
	    } else if (you == com) {
	    	winner = "무승부입니다.";
	    } else {
	    	winner = "당신의 패배입니다.";
	    }
	    
	    request.setAttribute("winner", winner);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/game/game_action.jsp");
	    dispatcher.forward(request, response);
	}
	
	public String choose(int key) {
    	switch(key) {
    	case 1: return "가위";
    	case 2: return "바위";
    	case 3: return "보";
		default : return "에러";
    	}
    }
}
