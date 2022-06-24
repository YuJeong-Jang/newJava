package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.MemberDAO;
import board.model.MemberDTO;

public class MemberRegisterAction extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("user_id");
		String password = request.getParameter("user_pw");
		String name = request.getParameter("user_name");
		String birth = request.getParameter("user_birth");
		String phone = request.getParameter("user_phone");
		String zipcode = request.getParameter("zipcode");
		String adr1 = request.getParameter("address1");
		String adr2 = request.getParameter("address2");
		
		MemberDTO memberDto = new MemberDTO();
		memberDto.setId(id);
		memberDto.setPassword(password);
		memberDto.setName(name);
		memberDto.setBirth(birth);
		memberDto.setPhone(phone);
		memberDto.setZipcode(zipcode);
		memberDto.setAddress1(adr1);
		memberDto.setAddress2(adr2);
		
		System.out.println(memberDto);
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		boolean result = memberDAO.registerMember(memberDto);
		
		if(result) {	//회원 등록 성공
			return new ModelAndView("/WEB-INF/board/success.jsp", "memberDto", memberDto);
		} else {		//회원 등록 실패
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", id + "회원 등록에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}
}
