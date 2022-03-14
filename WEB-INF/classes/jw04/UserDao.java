package jw04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DAO ( Data Access Object Pattern) :: data 처리 객체
public class UserDao {

	// Field
	String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String dbuser = "scott";
	String dbpwd = "tiger";

	// Constructor
	public UserDao() {

	}

	// Method
	public void getUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			// 1단계 Connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);

			// 2단계 Statement
			pStmt = con.prepareStatement("SELECT id, pwd FROM user WHERE id = ? AND pwd = ?");
			pStmt.setString(1, userVO.getId());
			pStmt.setString(2, userVO.getPwd());

			// 3단계 ResultSet
			rs = pStmt.executeQuery();

			if (rs.next()) {
				System.out.println("db에서 확인한 id, pwd ==> " + userVO.getId() + " : " + userVO.getPwd());
				// ==> Data가 존재한다면..
				userVO.setActive(true);
			} else {
				System.out.println("db에 < " + userVO.getId() + " > 에 해당하는 자료가 없습니다. ");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e1) {
				}
			}
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e3) {
				}

			}
		}
	}
}
