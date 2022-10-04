package Registration_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Login_Method.LoginDB_Method;


@WebServlet("/regForm")
public class Registration_Controller_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration_Controller_1() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		LoginDB_Method obj=new LoginDB_Method();
		int i = obj.updateDataDB(name, city, mobile, email);
		if(i!=0) {
			request.setAttribute("msge", "Record Update/Record Save");
			 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View_Registration.jsp");
			 rd.include(request, response);
		}else {
			
		}
		obj.closeDB();
		
		
	}

}
