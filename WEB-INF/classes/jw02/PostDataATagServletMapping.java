package jw02;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PostDataATagServletMapping extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		//client form data 한글디코딩
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
		out.println("<head><title>GetData.java</title></head>");
		out.println("<body>");
		
		out.println("<h2>GetTset</h2>");
		out.println("<li>이름 : " + clientName);
		out.println("<li>주소 : " + clientAddr);
		
		//==> </a> 태그를 이용하여 Query문자열 전달
		out.println("<p><p><a href='/edu/PostDataATagServletMapping?name=홍길동&addr=서울'>자기자신</a>");
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
