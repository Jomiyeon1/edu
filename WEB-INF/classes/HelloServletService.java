import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletService extends HttpServlet{
	///Field
	///Method
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		System.out.println("::servlet service()시작");
		System.out.println("Request Client IP : " + req.getRemoteAddr());
		res.setContentType("text/html;charset=EUC-KR");
		
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
	}//end of service
}//end of class

/* 
	1.   [TOMCAT_HONE]\webapps\examples\WEB-INF\classes  폴더에 copy
	2. compile
		- J2EE API  classpath 설정
		 - [TOMCAT_HONE]\lib\servlet-api.jar    ==> classpath설정

	3. browser 에서
	    - 표준화된 폴더구조의 환경설정 화일 web.xml 에  아래와 같이 등록(?)후..
		-  http://127.0.0.1:8080/examples/FirstServlet     로 호출
*/