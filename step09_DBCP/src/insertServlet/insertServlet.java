package insertServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class insertServlet
 */
@WebServlet("/insert")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");   
		String url = "error.jsp";
		String message = null;
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");

		if(id==null ||id.equals("")|| pwd==null || pwd.equals("")|| name==null ||
				name.equals("")|| age==null || age.equals("")|| phone==null || phone.equals("")|| 
				addr==null ||addr.equals("")) {
			req.setAttribute("errMsg", "입력값이 충분하지 않습니다....");
			req.getRequestDispatcher(url).forward(req, resp);
			return;
		}

		try {
			Member member = new Member(id,pwd,name,Integer.parseInt(age),phone,addr);

			MemberDAO dao = new MemberDAOImpl();
			//아이디 중복체크 하자
			if(dao.idCheck(id)) {
				message =id+"가 중복입니다!!!";
			}else {
				if(dao.insert(member) > 0) {
					//성공했으니까 select로 이동시켜준다.
					resp.sendRedirect("selectAll");  // 서블릿이 서블릿을 호출해준다. redirect는 데이터를 들고가지않기때문에.
					return;
				}else {
					message= "등록되지 않았습니다.";
				}
			}


		}catch(NumberFormatException e) {
			message="나이는 숫자만 입력하세요...";
		}catch(SQLException e) {
			message = e.getMessage();
		}
		
		req.setAttribute("errMsg", message);
		req.getRequestDispatcher(url).forward(req, resp);

	}
}
