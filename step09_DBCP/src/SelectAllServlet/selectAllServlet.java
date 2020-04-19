package SelectAllServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import ex0416.dao.MemberDAO;
import ex0416.dao.MemberDAOImpl;
import ex0416.domain.Member;

/**
 * Servlet implementation class selectAllServlet
 */
@WebServlet("/selectAll")
public class selectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter정보 받기 -> service 호출 -> dao
		String url = "error.jsp";
		MemberDAO memberDao = new MemberDAOImpl(); //생성될 객체는 인터페이스 기반으로 받는것이 좋다.
		try {
			List<Member> list = memberDao.selectAll();
			request.setAttribute("list",list); //jsp에서 ${requestScope.list}
			url="memberSelect.jsp";
			
		} catch (SQLException e) {
			//예외페이지 이동
			request.setAttribute("errMsg", e.getMessage());
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
