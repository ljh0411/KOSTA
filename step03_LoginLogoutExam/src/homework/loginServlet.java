package homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {
	
	String userid = "lee", userpwd="1234";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget ȣ��....");
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost ȣ��...");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		//�Ѿ���� ���� �޾ƿ���
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String name = request.getParameter("userName");
		
		
		
	
		if(userid.equals(id)&& userpwd.equals(pwd)) {
			HttpSession session = request.getSession(); // session �� id pwd name�� ����			
			session.setAttribute("sessionName",name);
			session.setAttribute("sessionTime", new Date().toLocaleString());
			request.getRequestDispatcher("./session/LoginOk.jsp").forward(request, response);
			
			
		}else {
			out.println("<script>");
			out.println("alert('"+name+"�� ������ Ȯ�����ּ���...');");
			out.println("history.back();");
			out.println("</script>");
		}
	
	}
	

}
