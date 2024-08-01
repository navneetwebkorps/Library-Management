package Aservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import dbConnection.DbConnector;


public class AaddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AaddBook() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String bookTitle = request.getParameter("Bname");
        String bookAuthor = request.getParameter("Bauthor");
        int bookEdition = Integer.parseInt(request.getParameter("Bedition"));
        int bookQuantity = Integer.parseInt(request.getParameter("Bquantity"));
    String adminId= (String) request.getSession().getAttribute("Aid");
		
		
      
        try {
        	Connection con =DbConnector.getConnection();
          // Prepare the SQL statement
            String sql = "INSERT INTO Book (Bname, Author, Edition, Quantity,AdminId) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement    stmt = con.prepareStatement(sql);
            stmt.setString(1, bookTitle);
            stmt.setString(2, bookAuthor);
            stmt.setInt(3, bookEdition);
            stmt.setInt(4, bookQuantity);
            stmt.setString(5, adminId);

            // Execute the statement
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                request.setAttribute("message", "Book added successfully!");
            } else {
                request.setAttribute("message", "Failed to add the book. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred: " + e.getMessage());
        } 
        
        String newToken = UUID.randomUUID().toString();
        request.getSession().setAttribute("token", newToken);
        // Forward the request back to the form page (or another page as needed)
        request.getRequestDispatcher("AaddBook1").forward(request, response);
    }
}

		

	


