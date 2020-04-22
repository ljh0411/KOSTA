package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//request 정보 받기... - > DTO에 저장 -> service 호출 - dao 호출
		//결과 받기... - 이동
		System.out.println("InsertController call............");
		
		ModelAndView mv = new ModelAndView(true, "insertResult.jsp");
		return mv;
	}

}
