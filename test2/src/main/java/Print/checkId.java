package Print;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkId")
public class checkId extends HttpServlet {
	UserDAO udao = new UserDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameter("userId");
		
		req.setAttribute(req.getParameter("test"), "12345");
		resp.sendRedirect("../test2/html/idCheck.html");
		
		
	}

	protected boolean checkUserId(String id) {
		List<User> list = udao.selectAll();
		for (User temp : list) {
			if (id.equals(temp)) {
				return true;
			}
		}
		return false;
	}
}
