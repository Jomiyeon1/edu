package jw04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.MBeanServerDelegateMBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginBean")
public class LoginBean extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		// client form data처리 
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// DB접근 data검색은 DbBean 이용 회원 유무 확인
		DbBean dbBean = new DbBean();
		dbBean.setId(id);
		dbBean.setPwd(pwd);
		
		//DbBean.getUser() method :: DB접근 Data 검색비교, true, false  return
		boolean isLogin = dbBean.getUser();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>Login 화면</h2>");
		
		//DBMS Data와 Client Form Data 비교 회원 유무 판단
		if(isLogin) {
			out.println(id + "님 환영합니다.");
			
		}else {
			out.println("Login 실패! id, pwd를 확인하세요.");
		}
		
		out.println("<p><p><a href='/edu/jw04/loginBean.html'>뒤로</a>");		
		out.println("</body>");
		out.println("</html>");
		
	}
}
