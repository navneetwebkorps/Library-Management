package Aservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dbConnection.DbConnector;

/**
 * Servlet implementation class AeditBook
 */
public class AeditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AeditBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String bookTitle = request.getParameter("Bname");
	        String bookAuthor = request.getParameter("Bauthor");
	        int bookEdition = Integer.parseInt(request.getParameter("Bedition"));
	        int bookQuantity = Integer.parseInt(request.getParameter("Bquantity"));
                String adminId= (String) request.getParameter("Aid");
                int bookId=Integer.parseInt(request.getParameter("bookId"));
                    System.out.println(adminId+bookAuthor+bookTitle+bookEdition+bookQuantity+bookId);
	        try {
	         
	            Connection con = DbConnector.getConnection();

	            // Update the book in the database
	            String query = "UPDATE book SET Bname=?, author=?, edition=?, quantity=? WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, bookTitle);
	            ps.setString(2, bookAuthor);
	            ps.setInt(3, bookEdition);
	            ps.setInt(4, bookQuantity);
	            ps.setInt(5, bookId);
	         //   ps.setString(6, adminId);
                 
	            int result = ps.executeUpdate();
                    ps.close();
                    String query1 = "UPDATE IssueBook SET bname=?  WHERE id=?";
                    ps=con.prepareStatement(query1);
                    ps.setString(1, bookTitle);
                    ps.setInt(2, bookId);

                    ps.execute();

	            if (result > 0) {
                        
	            	request.setAttribute("AeditBook", "Book edited successfully");
	                // Redirect to a confirmation page or back to the book list
	            	 request.getRequestDispatcher("AeditBook1").forward(request, response);
	                
	            } else {
	                // Handle the case where the update failed
	                response.getWriter().println("Failed to update the book.");
	            }

	       
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Error: " + e.getMessage());
	        }
	    }
	}
	


