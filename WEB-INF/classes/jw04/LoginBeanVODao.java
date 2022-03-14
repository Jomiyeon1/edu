package jw04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginBeanVODao extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		// client form data처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		// UserVO instance 생성 및 Client Form Data 전달 (Binding)
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);

		// DB접근 Data 검색 비교 UserVO.active true / false 변경
		UserDao useDao = new UserDao();
		useDao.getUser(userVO);

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		out.println("<h2>Login 화면</h2>");

		if (userVO.isActive()) {
			out.println(id + "님 환영합니다.");
		} else {
			out.println("Login 실패! id, pwd를 확인하세요.");
		}

		out.println("<p><p><a href='/edu/jw04/LoginBeanVODao.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");

	}

}
