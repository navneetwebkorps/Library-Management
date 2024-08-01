package Sservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class Slogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Slogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Slid=req.getParameter("Sid");
		String Slpass=req.getParameter("password");
		             System.out.println("in Sloginjava");
		     
                        req.getSession().setAttribute("Sid", null);
                        System.out.println(req.getSession().getAttribute("Sid"));
                       
			
		        req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}


