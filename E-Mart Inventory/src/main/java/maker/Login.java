package maker;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Databasejdbc.Loginjdbc;
	

	public class Login extends HttpServlet
	{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	    {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String user = request.getParameter("uname");
	        String pass = request.getParameter("pass");
	        Loginjdbc ob=new Loginjdbc();
	        String result=ob.loginValidation(user, pass);
	        out.println(result);
	        if(result.equals("successMaker")){
	            RequestDispatcher rd = request.getRequestDispatcher("Makerwelcome.html");
                rd.forward(request, response);
	        }
	        else if(result.equals("successChecker"))
	        {
	        	RequestDispatcher rd = request.getRequestDispatcher("Checkerwelcome.html");
                rd.forward(request, response);
	        }
	       
	        else
			{
				request.setAttribute("output","Username or Password is incorrect");
				 request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	        
	        
	        
	      
	    }
	}
	

