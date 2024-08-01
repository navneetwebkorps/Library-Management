package Sservlets;

import java.io.IOException;

import Users.Susers;
import ValidatorPkg.MailSend;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class Sregister extends HttpServlet {

    public Sregister() {
        super();

    }



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Sname =req.getParameter("name");

		String Smail=req.getParameter("mail");
		

		System.out.println("servlet is calling");
		System.out.println("anme"+Smail);MailSend mObj= new MailSend();
		SdbMethods sId=new SdbMethods();
		String  SID = sId.SmemberId();
                String Spass="pass"+'@'+SID.substring(1, 6);
                MailSend.SendEmail(SID,Spass);
		System.out.println("servlet is calling"+Sname);
                System.out.println("servlet is calling"+Smail);
                System.out.println("servlet is calling"+Spass);
		Susers Sobj=new Susers(SID,Sname ,Smail,Spass);
		Sobj.toString();
		SdbMethods.Sinsert(Sobj);
		Sobj.toString();
		  HttpSession session = req.getSession();
	        session.setAttribute("SregistrationSuccess", true);
	        resp.sendRedirect("index.jsp");
	}

}
