package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//검색기능...........
		System.out.println("SelectController call............");
		
		//전달할 데이터 저장.
		
		request.setAttribute("message", "검색이 완료되었습니다.....");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult.jsp");
		
		
		return mv;
	}

}
