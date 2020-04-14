package ex0410.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamTestServlet extends HttpServlet {
	//�ʿ��� �޼ҵ� ������
	
	String id, addr;
	String message, age;
	@Override
	public void init() throws ServletException { // init�޼ҵ�� ���������ɶ� �ѹ� ����Ǳ⶧���� ���ʿ��� �ߺ�id ������ �������ص���.
		id = super.getInitParameter("id");
		addr = super.getInitParameter("addr");
		
		//context-param ��������
		ServletContext application = super.getServletContext();
		message = application.getInitParameter("message");
		age = application.getInitParameter("age");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//���
		PrintWriter out = response.getWriter();
		out.println("<h2>");
		out.println("���̵� : "+id+"<br>");
		out.println("�ּ� : "+addr+"<br>");
		out.println("�޽��� : "+message+"<br>");
		out.println("���� : "+age+"<br>");
		out.println("</h2>");
	}
}
