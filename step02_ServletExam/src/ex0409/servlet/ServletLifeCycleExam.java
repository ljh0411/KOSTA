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
 * 브라우저에서 실행되는 servlet문서 작성
 * 1)반드시 public클래스
 * 2)반드시 HttpServlet 상속
 * 3)필요한 메소드는 재정의 한다.
 * 
 * 4) servlet을 등록한다
 * 		(생성 + url에서 어떻게 요청했을때 서블릿이 실행될지 결정)
 * 
 * 		- web.xml등록 방법
 * 		- @annotation 등록 방법
 */

public class ServletLifeCycleExam extends HttpServlet {
	
	public ServletLifeCycleExam(){
		System.out.println("ServletLifeCycleExam의 생성자 호출됨...");
	}
	
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("init() 호출됨 ... ");
	
	}
	
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//	
//		System.out.println("service가 호출되었습니다...");
//	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 깨짐 방지
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("doGet 호출");
		
		//브라우저에 응답(화면구성)
		//출력스트림 필요하다.
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red'>Hello ~~ 안녕 </h1>");
		
		out.println("<scrpit>");
		out.println("alert('잘되네요')");
		out.println("</scrpit>");
		
		//내장객체를 사용한다.
		HttpSession session=request.getSession();
		ServletContext application=request.getServletContext();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 호출");
	}

	

	@Override
	public void destroy() {
		
		System.out.println("destory() 호출됨... 종료");
	}

	
	
	

}
