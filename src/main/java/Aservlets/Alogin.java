package Aservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Sservlets.SdbMethods;

/**
 * Servlet implementation class Alogin
 */
public class Alogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Alid=req.getParameter("Aid");
		String Alpass=req.getParameter("password");
	
		
		{ 
		      
		        boolean ans=AdbMethods.Alogin(Alid, Alpass);
		        System.out.println("Alogin "+ans+Alid+Alpass);
				if(ans==true)
				{ 
				       req.setAttribute("Lmessage", "Admin Login Successfully");
					 
			        req.setAttribute("Aid", Alid);
			        req.setAttribute("Apass",Alpass);
			        HttpSession session=req.getSession();
			        session.setAttribute("Aid", Alid);
			        session.setAttribute("Apass", Alpass);
			        req.getRequestDispatcher("Alogin.jsp").forward(req, resp);
				}
                                else
                                {
                                    req.setAttribute("message", "Wrong Credential");
                                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                                    
                                }
		     
		}
	}

}
