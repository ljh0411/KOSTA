package kosta.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.resources.ModelerMessages;

/**
 * View의 모든 요청을 중앙집중적으로 관리하기 위한
 * FrontController의 역할이다.
 * :요청을 받아 Model(Service-BusinessLogic, DAO) 쪽으로 전달하고
 * 그 결과를 받아서 결과 뷰로 이동하는 역할.
 */
@WebServlet(urlPatterns ="/front" , loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//System.out.println("front.........");
		String key = request.getParameter("key");
		System.out.println("key = "+key);
		
		Controller controller = null;
		
		if(key.equals("insert")) {
			//등록하기
			controller = new InsertController();
		}else if(key.equals("select")) {
			//검색하기 기능
			controller = new SelectController();
		}else if(key.equals("update")) {
			//수정하기 기능
			controller = new UpdateController();
		}else if(key.equals("delete")) {
			//삭제하기 기능
			controller = new DeleteController();
		}
		
		ModelAndView mv = controller.handleRequest(request, response);
		if(mv.isRedirect()) {//redirect 방식으로 이동해
			response.sendRedirect(mv.getViewName());
			
		}else { // forward방식
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			
		}
	}

}
