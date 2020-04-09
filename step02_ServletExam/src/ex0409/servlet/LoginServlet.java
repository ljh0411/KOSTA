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
		
		this.doPost(req, resp);  //동일한 일을 하기 떄문에 메소드 호출
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost...");
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//넘어오는 세개의 정보를 받아서 화면에 출력
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
			
			// service --> dao 에서 DB에 데이터를 가져와서 뷰쪽으로 전달.
			List<String> list = new ArrayList<String>();
			list.add("등산"); list.add("영화");
			list.add("수영"); list.add("축구");
			
			//request에 list값 저장 값을 유지해야되기 떄문에 forward방식 사용
			req.setAttribute("list", list);
			
			//이동
			//1) forward 방식
			req.getRequestDispatcher("loginOk.jsp").forward(req,resp);
			
			
			//2) redirect 방식
			//resp.sendRedirect("loginOk.jsp?userName="+URLEncoder.encode(name,"UTF-8"));
		}else {
			//메시지 출력
			//뒤로가기
			out.println("<script>");
			out.println("alert('"+name+"님 정보를 확인해주세요...')");
			out.println("history.back();");
			out.println("</script>");
			
		}
		
	}
}
