package checker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Databasejdbc.CheckDB;
import Databasejdbc.DistributorInvoice;

public class CheckUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			String[] names=request.getParameterValues("checkid");
			PrintWriter out = response.getWriter();
			int[] a=new int[names.length];
			int j=0;
			
			for(int i=0; i < names.length-1; i++) {
				if(names[i+1].equals("1"))
				{
					a[j]=1;
					j++;
					i++;
				}
				else{
					a[j]=0;
					j++;
				}
				
				
		    }
			CheckDB c=new CheckDB();
			String res=c.dbcheck(a,names.length);
			out.println(res);
			DistributorInvoice di=new DistributorInvoice();
			String r=di.generateDistInvoice();
			out.println(r);
   		}
   		}
			
			

			
			
			
	


