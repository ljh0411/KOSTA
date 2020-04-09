package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	String userid="jang", userpwd="1234";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doget...");
		
		this.doPost(req, resp);  //������ ���� �ϱ� ������ �޼ҵ� ȣ��
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost...");
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//�Ѿ���� ������ ������ �޾Ƽ� ȭ�鿡 ���
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		String name = req.getParameter("userName");
		
		PrintWriter out = resp.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println(id+"<br>");
//		out.println(pwd+"<br>");
//		out.println(name+"<br>");
//		out.println("</body>");
//		out.println("</html>");
		
		if(userid.equals(id)&& userpwd.equals(pwd)) {
			
			// service --> dao ���� DB�� �����͸� �����ͼ� �������� ����.
			List<String> list = new ArrayList<String>();
			list.add("���"); list.add("��ȭ");
			list.add("����"); list.add("�౸");
			
			//request�� list�� ���� ���� �����ؾߵǱ� ������ forward��� ���
			req.setAttribute("list", list);
			
			//�̵�
			//1) forward ���
			req.getRequestDispatcher("loginOk.jsp").forward(req,resp);
			
			
			//2) redirect ���
			//resp.sendRedirect("loginOk.jsp?userName="+URLEncoder.encode(name,"UTF-8"));
		}else {
			//�޽��� ���
			//�ڷΰ���
			out.println("<script>");
			out.println("alert('"+name+"�� ������ Ȯ�����ּ���...')");
			out.println("history.back();");
			out.println("</script>");
			
		}
		
	}
}
