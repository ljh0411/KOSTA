package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//request ���� �ޱ�... - > DTO�� ���� -> service ȣ�� - dao ȣ��
		//��� �ޱ�... - �̵�
		System.out.println("InsertController call............");
		
		ModelAndView mv = new ModelAndView(true, "insertResult.jsp");
		return mv;
	}

}
