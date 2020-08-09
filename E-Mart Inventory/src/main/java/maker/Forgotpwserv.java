package maker;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forgotpwserv
 */
import Databasejdbc.ForgotpwDB;
public class Forgotpwserv extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ForgotpwDB ob=new ForgotpwDB();
        String message=ob.checkdbemail(request.getParameter("e-mail"));
        String to= request.getParameter("e-mail"); ;
        String subject = "Your Password";
        String user = "user mail";
        String pass = "user password";
        String s=SendMail.send(to,subject, message, user, pass);
        out.println("Mail sent success");
	}

}
