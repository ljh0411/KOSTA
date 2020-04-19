package DeleteServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0416.dao.MemberDAO;
import ex0416.dao.MemberDAOImpl;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		try {
			if(id==null || id.equals("")) {
				request.setAttribute("errMsg", "입력값이 부족합니다...");

			}else {
				MemberDAO dao = new MemberDAOImpl();
				if(dao.delete(id)>0) {
					response.sendRedirect("selectAll");
					return;
				}else {
					request.setAttribute("errMsg", "삭제되지 않았습니다.");
				}
				
			}
		}catch(SQLException e) {
			request.setAttribute("errMsg", e.getMessage());
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

}
