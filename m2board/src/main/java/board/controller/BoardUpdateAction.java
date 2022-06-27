package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardDTO;
import board.model.MemberDTO;

public class BoardUpdateAction extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		/* 세션정보 */
		HttpSession session = request.getSession();
		MemberDTO userInfo = (MemberDTO) session.getAttribute("userInfo");
		
		if(userInfo == null) {	//세션정보없음(로그인하지 않았거나, 이미 로그아웃한 경우)
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "먼저 로그인 하셔야 합니다.");
			mav.addObject("url", "Login.do");
			return mav;
		}
		/* 세션정보 끝 */
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Long no = Long.parseLong(request.getParameter("no"));
		String id = userInfo.getId();
		
		BoardDTO boardDto = new BoardDTO();
		MemberDTO memberDto = new MemberDTO();
		memberDto.setId(id);
		
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setMemberDto(memberDto);
		boardDto.setNo(no);
		
		BoardDAO boardDao = BoardDAO.getInstance();
		boolean result = boardDao.UpdateBoard(boardDto);
		
		if(result) {
			return new ModelAndView("redirect:BoardView.do?no=" + boardDto.getNo());
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "글 수정 실패");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}

}
