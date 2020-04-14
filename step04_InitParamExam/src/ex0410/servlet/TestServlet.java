package ex0410.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/test" }, 
		initParams = { 
				@WebInitParam(name = "hobby", value = "≥Ó±‚")
		},
		loadOnStartup = 1)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		System.out.println("TestServlet¿« init() »£√‚µ ...");
		String hobby = super.getInitParameter("hobby");
		String id = super.getInitParameter("id");
		
		//context-param ∞°¡Æø¿±‚
		ServletContext application = super.getServletContext();
		String message = application.getInitParameter("message");
		String age = application.getInitParameter("age");
		
		System.out.println("hobby : "+hobby);
		System.out.println("id : "+id);
		System.out.println("message : "+message);
		System.out.println("age : "+age);
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServlet¿« service() »£√‚µ ...");
	}

	

}
