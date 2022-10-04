package Login_Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDB_Method  implements Login_Method_Interface{
    Connection con;
    Statement stmnt;
	 
	@Override
	public void createConnectionDB(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginDB_1","root","Saqeeb09@");
			stmnt=con.createStatement();    
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyLoginId(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				ResultSet result = stmnt.executeQuery("select * from login_1 where email='"+email+"' and password='"+password+"'");
				return result.next();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
           e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updateDataDB(String name, String city, String mobile, String email) {
		int executeUpdate=0;
		try {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentReg","root","Saqeeb09@");
    	   stmnt = con.createStatement();
    	    executeUpdate = stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+mobile+"','"+email+"')");
    	   System.out.println("Check="+executeUpdate);
    	   
    	  
	} catch (Exception e) {
      e.printStackTrace();
	
	}
      return executeUpdate;
		
	}

}
