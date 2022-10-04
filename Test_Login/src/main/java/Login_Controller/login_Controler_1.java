package Login_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Login_Method.LoginDB_Method;


@WebServlet("/logintest")
public class login_Controler_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login_Controler_1() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 LoginDB_Method obj=new LoginDB_Method();
		 obj.createConnectionDB(email, password);
		 boolean verifyLoginId = obj.verifyLoginId(email, password);
		 if(verifyLoginId==true) {
			 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View_Registration.jsp");
			 rd.include(request, response);
		 }else {
			 request.setAttribute("error", "Invalid/user Name");
			 RequestDispatcher rd = request.getRequestDispatcher("View_Login.jsp");
			 rd.include(request, response);
		 }
		 obj.closeDB();
		
	}

}
