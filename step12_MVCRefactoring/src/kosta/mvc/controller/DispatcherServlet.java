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
 * View�� ��� ��û�� �߾����������� �����ϱ� ����
 * FrontController�� �����̴�.
 * :��û�� �޾� Model(Service-BusinessLogic, DAO) ������ �����ϰ�
 * �� ����� �޾Ƽ� ��� ��� �̵��ϴ� ����.
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
		if(mv.isRedirect()) {//redirect ������� �̵���
			response.sendRedirect(mv.getViewName());
			
		}else { // forward���
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			
		}
	}

}
