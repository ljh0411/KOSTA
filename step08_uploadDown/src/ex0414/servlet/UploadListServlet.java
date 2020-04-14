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
			
			//save ���� �ȿ� �ִ� �����̸��� ������ ������ ��� �̵���Ų��.
			String saveDir= request.getServletContext().getRealPath("/save"); //save���丮�� �ִ� ��ι޾ƿ���
			File file = new File(saveDir);   // saveDir�� �޾� �ѷ��� file ���� 
			
			
			
			if(file.exists()) {
				 String fileName [] = file.list();   //file.list�� ��� �� �ѷ��ذ� �迭�� ����
				 request.setAttribute("fileName", fileName);
			}
			request.getRequestDispatcher("downList.jsp").forward(request, response);
			
		}

}
