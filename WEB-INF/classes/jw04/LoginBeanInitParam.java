package jw04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginBeanInitParam extends HttpServlet {
	
	//Field
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUser;
	private String jdbcPasswd;
	
	//init() Method OverRiding
	//==>web.xml(Mata-data) 등록된 정보추출
	//==> init() Method는 Client 의 최초 request에 1회만 호출 :: Servlet Life Cycle
	public void init(ServletConfig sc) throws ServletException{
		super.init(sc);
		jdbcDriver = sc.getInitParameter("jdbcDriver");
		jdbcURL = sc.getInitParameter("jdbcURL");
		jdbcUser = sc.getInitParameter("jdbcUser");
		jdbcPasswd = sc.getInitParameter("jdbcPasswd");
		
		// ==> 아래는 디버깅용 :: console 확인
		System.out.println("web.xml에 등록된 InitParam값을 추출유무 확인");
		System.out.println("jdbcDriver" + jdbcDriver );
		System.out.println("jdbcURL" + jdbcURL );
		System.out.println("jdbcUser" + jdbcUser );
		System.out.println("jdbcPasswd" + jdbcPasswd );
			
	}
	
	//doPost() method OverRiding
	public void dopost (HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
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
		UserInitParamDao dao = new UserInitParamDao();
		//DB접속정보 driver, url, password 설정
		dao.setJdbcDriver(jdbcDriver);
		dao.setJdbcURL(jdbcURL);
		dao.setJdbcUser(jdbcUser);
		dao.setJdbcPasswd(jdbcPasswd);
		
		dao.getUser(userVO);
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		out.println("<h2>Login 화면</h2>");

		if (userVO.isActive()) {
			out.println(id + "님 환영합니다.");
		} else {
			out.println("Login 실패! id, pwd를 확인하세요.");
		}

		out.println("<p><p><a href='/edu/jw04/LoginBeanInitParam.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");

		
		
	}

}
