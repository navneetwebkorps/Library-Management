package Aservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class Alogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Alogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Slid=req.getParameter("Aid");
		String Slpass=req.getParameter("password");
		             System.out.println("in Sloginjava");
		     
                        req.getSession().setAttribute("Aid", null);
                        System.out.println(req.getSession().getAttribute("Aid"));
                       
			
		        req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}


