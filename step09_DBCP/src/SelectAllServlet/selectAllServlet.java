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
		//parameter���� �ޱ� -> service ȣ�� -> dao
		String url = "error.jsp";
		MemberDAO memberDao = new MemberDAOImpl(); //������ ��ü�� �������̽� ������� �޴°��� ����.
		try {
			List<Member> list = memberDao.selectAll();
			request.setAttribute("list",list); //jsp���� ${requestScope.list}
			url="memberSelect.jsp";
			
		} catch (SQLException e) {
			//���������� �̵�
			request.setAttribute("errMsg", e.getMessage());
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
