//package server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * Get방식 전송된 Client Form Data처리
 * */
public class GetDataKr extends HttpServlet {
	// 1. Client Get방식으로 Request :: doGet() method O/R
	// 2. service() O/R가능
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		/*=====================================================================
		 * ==> Tomcat 8.X이상 Get 방식 한글해결방법
		 * ==> server.xml 설정변경
		 * <Connector port = "8080" protocol = "HTTP/1.1"
		 * 		connection Timeout="200000"
		 * 		redirectPort = "8443"
		 * 		useBodyEncodingForURI="true"/> 	<== 추가
		 ======================================================================*/
		req.setCharacterEncoding("EUC-KR");
		
		// 아래 두 실행문은 servlet에서 client로 Html을 전송시 필수 코딩
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();	
		
		// client form data(QueryString :: name = value)처리 (API확인!)
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");
		
		//client form 출력
		System.out.println(clientName + " : " + clientAddr);
		
		/*=====================================================================
		 * ==> Tomcat 7.X 이하의 Get방식 한글해결방법
		 * 16진수 코딩된 client form data 한글 디코딩
		 * String clientNameKo = this.convertKo(clientName);
		 * String clientAddrKo = convertKo(clinentAddr);
		 * //client form 출력
		 * System.our.println(clientNameKo + " : " + clientAddrKo);
		 ======================================================================*/
		
		out.println("<html>");
		out.println("<head><title>GetDataKr.java</title></head>");
		out.println("<body>");
		
		out.println("<h2>GetTset</h2>");
		out.println("<li>이름 : " + clientName);
		out.println("<li>주소 : " + clientAddr);
		
		out.println("<p><p><a href='/edu/getDataKr.html'>뒤로</a>");
		
		out.println("</body>");
		out.println("</html>");
	
	}
	
	/*=====================================================================
	 * ==> Tomcat 7.X 이하의 Get방식 한글해결방법
	//method
	 * private String convertKo(String paramValue){
	 * 	String convertParamValue = null;
	 * 	try{
	 * 		//==> API 확인
	 * 		byte[] b = paramValue.getBytes("8859_1");
	 * 		convertParamValue = new String(b, "EUC-KR");
	 * 	}catch(UnsupportedEncodingException uee){
	 * 		System.out.println("한글변환 중 Exception발생");
	 * 		uee.printStackTeace();
	 * 	}
	 * 	return convertParamValue;
	 * }
	 ======================================================================*/
}
