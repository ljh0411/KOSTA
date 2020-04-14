package ex0414.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UpLoad")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		//enctype="multipart/form-data" 요청되는 경우에는 cos.jar 라이브러리 이용
		String saveDir= request.getServletContext().getRealPath("/save");
		int maxSize = 1024*1024*100;//100M
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir,maxSize,encoding, new DefaultFileRenamePolicy());
		
		//전송되는 데이터 받기
		 String name = m.getParameter("name");
		 String subject = m.getParameter("subject");
		 String file = m.getParameter("file");
		 
		 //첨부된 파일이름
		 String originalName = m.getOriginalFileName("file");
		 String systemName = m.getFilesystemName("file");
		
		 System.out.println("name : "+name);
		 System.out.println("subject : "+subject);
		 System.out.println("file : "+file);
		 
		 System.out.println("originalName : "+originalName);
		 System.out.println("systemName : "+systemName);
		 
		 //업로드 완료후 결과 페이지로 이동!
		 //뷰쪽으로 전달될 정보를 저장 - request
		 request.setAttribute("name", name);  //jsp에서 ${requestScope.name}
		 request.setAttribute("subject", subject);
		 request.setAttribute("originalName", originalName);
		 request.setAttribute("systemName", systemName);
		 request.setAttribute("fileSize", m.getFile("file").length());
		 request.setAttribute("saveDir", saveDir);
		 
		 //이동방식
		 request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
	}

}
