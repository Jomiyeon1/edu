//package server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * - Servlet Life Cycle 이해 및 적용 구현
 * - Servlet Hierarchy / Servlet API 이해
 * */

public class HelloServletdoPost extends HttpServlet {
	//init() => 금번 예제 method overriding no need
	//service() method Overrading 안함
	// doPost만 O/R시 에러나므로(API) doGet O/R하여 doPost 실행
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		this.doPost(req,res);
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		System.out.println(":: servlet doPost() 시작");
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
		
		System.out.println(":: servlet doPost() 종료\n");
		
	}
	//destory() ==> 금번예제 method overriding no need
}
