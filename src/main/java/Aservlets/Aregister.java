package Aservlets;

import java.io.IOException;

import Users.Ausers;
import ValidatorPkg.MailSend;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Aregister extends HttpServlet {
	public Aregister() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String Aname = req.getParameter("name");
			String ALname = req.getParameter("Lname");
			String Amail = req.getParameter("email");
			
                        String Aaddress=req.getParameter("address");
			Aname.trim();
			ALname.trim();
			Amail.trim();
			
			System.out.println("servlet is calling");
			System.out.println("anme" + Amail);
			AdbMethods mId = new AdbMethods();
			String AID = mId.AmemberId();
                        
                        
		String Apass = "pass"+'@'+AID.substring(1,6 );
			System.out.println("aId" +AID);
                        MailSend.SendEmail(AID,Apass);
			Ausers Aobj = new Ausers(AID, Aname, Amail, ALname, Apass,Aaddress);

			boolean ans = AdbMethods.Ainsert(Aobj);
			
				 HttpSession session = req.getSession();
				  
			        session.setAttribute("AregistrationSuccess", true);
			     
			        req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		} catch (Exception e) {
			MyLog.MyLogger.logError("Error in Aregister servlet " + e);
		}
	}
}
