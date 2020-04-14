package ex0410.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamTestServlet extends HttpServlet {
	//필요한 메소드 재정의
	
	String id, addr;
	String message, age;
	@Override
	public void init() throws ServletException { // init메소드는 서블릿생성될때 한번 실행되기때문에 불필요한 중복id 여러번 생성안해도됨.
		id = super.getInitParameter("id");
		addr = super.getInitParameter("addr");
		
		//context-param 가져오기
		ServletContext application = super.getServletContext();
		message = application.getInitParameter("message");
		age = application.getInitParameter("age");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//기능
		PrintWriter out = response.getWriter();
		out.println("<h2>");
		out.println("아이디 : "+id+"<br>");
		out.println("주소 : "+addr+"<br>");
		out.println("메시지 : "+message+"<br>");
		out.println("나이 : "+age+"<br>");
		out.println("</h2>");
	}
}
