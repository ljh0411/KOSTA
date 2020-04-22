package kosta.mvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
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
     
	Map<String, Controller> map;
	
    @Override
    	public void init() throws ServletException {
    		ServletContext application = super.getServletContext();
    		map = (Map<String,Controller>)application.getAttribute("map");
    }
    
    
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//System.out.println("front.........");
		String key = request.getParameter("key");
		System.out.println("key = "+key);

		
		Controller controller = map.get(key);
		
		
		
		ModelAndView mv = controller.handleRequest(request, response);
		if(mv.isRedirect()) {//redirect 방식으로 이동해
			response.sendRedirect(mv.getViewName());
			
		}else { // forward방식
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			
		}
	}

}
