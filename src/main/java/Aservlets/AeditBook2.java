package Aservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AeditBook
 */
public class AeditBook2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AeditBook2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String bookTitle = request.getParameter("Bname");
	        String bookAuthor = request.getParameter("author");
	        int bookEdition = Integer.parseInt(request.getParameter("edition"));
	        int bookQuantity = Integer.parseInt(request.getParameter("quantity"));
                String adminId= (String) request.getParameter("Aid");
                int bookId=Integer.parseInt(request.getParameter("bookId"));

	        try {
	         
  
	           request.setAttribute("bookTitle", bookTitle);
                    request.setAttribute("bookAuthor", bookAuthor);
                     request.setAttribute("bookEdition", bookEdition);
                      request.setAttribute("bookQuantity", bookQuantity);
                       request.setAttribute("bookId", bookId);
	            	request.setAttribute("AeditBook", "Book edited successfully");
	                // Redirect to a confirmation page or back to the book list
	            	 request.getRequestDispatcher("EditBook.jsp").forward(request, response);
	                
	          

	       
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Error: " + e.getMessage());
	        }
	    }
	}
	


