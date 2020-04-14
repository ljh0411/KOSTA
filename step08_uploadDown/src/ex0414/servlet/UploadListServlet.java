package ex0414.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class DownloadList
 */
@WebServlet("/UpLoadList")
public class UploadListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//save 폴더 안에 있는 파일이름의 정보를 가지고 뷰로 이동시킨다.
			String saveDir= request.getServletContext().getRealPath("/save"); //save디렉토리에 있는 경로받아오기
			File file = new File(saveDir);   // saveDir을 받아 뿌려줄 file 생성 
			
			
			
			if(file.exists()) {
				 String fileName [] = file.list();   //file.list가 목록 다 뿌려준걸 배열에 저장
				 request.setAttribute("fileName", fileName);
			}
			request.getRequestDispatcher("downList.jsp").forward(request, response);
			
		}

}
