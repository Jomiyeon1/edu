//package server;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletdoGet extends HttpServlet{
	
		
		//init() => 금번 예제 method overriding no need
		//server() method Overrading 안함
		//doGet() Overraing
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
			System.out.println(":: servlet doGet() 시작");
			System.out.println("Requset Client IP : " + req.getRemoteAddr());
			
			//한글처리
			res.setContentType("text/html;charset=EUC_KR");
			
			//1. PrintWriter 인스턴스 생성을 Encapsulation한 API 사용 Stream생성
			PrintWriter out = res.getWriter();
			
			out.println("<html>");
			out.println("<head><title>hello Servlet</title></head>");
			out.println("<body>");
			out.println("English : HelloServlet");
			out.println("<p>");
			out.println("Korea : 안녕 서블릿!");
			out.println("</body>");
			out.println("</html>");
			out.flush();
			out.close();
			
			System.out.println(":: servlet doGet() 종료\n");
			
	
		
		}
		//destory() ==> 금번예제 method overriding no need
}