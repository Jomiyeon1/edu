package jw04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbBean {
	
	//Field
	private String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuser = "scott";
	private String dbpwd = "tiger";
	private String id;
	private String pwd;
	
	//Constructor
	public DbBean() {

	}
	
	//Method
	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//DB ���� Data �˻� �� true / false return
	public boolean getUser() {
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			//1�ܰ� Connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, dbuser,dbpwd);
			
			//2�ܰ� Statement
			pStmt = con.prepareStatement("SELECT id, pwd FROM user WHERE id = ?");
			pStmt.setString(1, id);
			
			//3�ܰ� ResultSet
			rs = pStmt.executeQuery();
			String str = null;
			
			if(rs.next()) {
				str = rs.getString(pwd);
				//==>debug :: consoleȮ��
				System.out.println("db���� Ȯ���� id, pwd ==> " + id + " : " + str);
			}else {
				//==>debug :: consoleȮ��
				System.out.println("db�� < " + id + " > �� �ش��ϴ� �ڷᰡ �����ϴ�.");
			}
			
			// ȸ�� ������ Ȯ���ϰ� ȸ���̸� true, �ƴϸ� false return
			if(str != null && str.equals(pwd)) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//�� catch�� ���ο� return�� �����ؾ��ϴ°�?
			return false;
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e1) { }
			}
			if(pStmt != null) {
				try {
					pStmt.close();
				} catch (Exception e2) { }
			}
				if(con != null) {
					try {
						con.close();
					} catch (Exception e3) { }
				
			}
		}
	}
}