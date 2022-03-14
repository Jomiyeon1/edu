//package server;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class PostData extends HttpServlet {
	// 1. Client Post방식으로 Request :: doPost() method O/R
	// 2. service() O/R 가능
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		// res.setCharacterEncoding("~~") API 확인
		// 16진수 인코딩된 client form data 한글 디코딩
		req.setCharacterEncoding("EUC-KR");
		
		// 아래 두 실행문은 servlet에서 client로 Html을 전송시 필수 코딩
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		// client form data(QueryString :: name = value)처리 (API확인!)
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");
		
		//client form 출력
		System.out.println(clientName + " : " + clientAddr);
		
		out.println("<html>");
		out.println("<head><title>PostData.java</title></head>");
		out.println("<body>");
		out.println("<h2>PostTset</h2>");
		out.println("<li>이름 : " + clientName);
		out.println("<li>주소 : " + clientAddr);
		
		out.println("<p><p><a href='/edu/postData.html'>뒤로</a>");
		
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
}
