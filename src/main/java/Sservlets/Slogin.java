package Sservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class Slogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Slogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Slid=req.getParameter("Sid");
		String Slpass=req.getParameter("password");
		boolean ans=SdbMethods.Slogin(Slid, Slpass);
                System.out.println("in Sloginjava"+Slid+Slpass);
		if(ans==true)
		{ 
		                  System.out.println("in Sloginjava");
		        req.setAttribute("Sid", Slid);
		        req.setAttribute("Spass",Slpass);
                        req.getSession().setAttribute("Sid", Slid);
                        req.setAttribute("message", "Login Success");
			
		        req.getRequestDispatcher("Shome.jsp").forward(req, resp);
		}
                else
                {
                    req.setAttribute("message", "Wrong Credentials");
                    req.getRequestDispatcher("Slogin.jsp").forward(req, resp);
                }
		
	}

}
