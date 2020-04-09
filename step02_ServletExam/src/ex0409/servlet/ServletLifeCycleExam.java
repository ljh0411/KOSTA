package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ���������� ����Ǵ� servlet���� �ۼ�
 * 1)�ݵ�� publicŬ����
 * 2)�ݵ�� HttpServlet ���
 * 3)�ʿ��� �޼ҵ�� ������ �Ѵ�.
 * 
 * 4) servlet�� ����Ѵ�
 * 		(���� + url���� ��� ��û������ ������ ������� ����)
 * 
 * 		- web.xml��� ���
 * 		- @annotation ��� ���
 */

public class ServletLifeCycleExam extends HttpServlet {
	
	public ServletLifeCycleExam(){
		System.out.println("ServletLifeCycleExam�� ������ ȣ���...");
	}
	
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("init() ȣ��� ... ");
	
	}
	
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//	
//		System.out.println("service�� ȣ��Ǿ����ϴ�...");
//	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ���� ����
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("doGet ȣ��");
		
		//�������� ����(ȭ�鱸��)
		//��½�Ʈ�� �ʿ��ϴ�.
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red'>Hello ~~ �ȳ� </h1>");
		
		out.println("<scrpit>");
		out.println("alert('�ߵǳ׿�')");
		out.println("</scrpit>");
		
		//���尴ü�� ����Ѵ�.
		HttpSession session=request.getSession();
		ServletContext application=request.getServletContext();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost ȣ��");
	}

	

	@Override
	public void destroy() {
		
		System.out.println("destory() ȣ���... ����");
	}

	
	
	

}
