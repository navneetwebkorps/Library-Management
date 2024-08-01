package Aservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnection.DbConnector;

/**
 * Servlet implementation class DeleteBook
 */

public class DeleteBook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteBook() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DbConnector.getConnection(); 
            
            // Check if book is issued
            String sqlCheckIssued = "SELECT COUNT(*) AS count FROM IssueBook WHERE bid = ?";
            stmt = con.prepareStatement(sqlCheckIssued);
            stmt.setInt(1, Integer.parseInt(bookId));
            rs = stmt.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            stmt.close();
            System.out.println("Issue book count="+count);
            // Fetch current quantity of the book
            String sqlGetQuantity = "SELECT quantity FROM book WHERE id = ?";
            stmt = con.prepareStatement(sqlGetQuantity);
            stmt.setInt(1, Integer.parseInt(bookId));
            rs = stmt.executeQuery();
            int bQuantity = 0;
            if (rs.next()) {
                bQuantity = rs.getInt("Quantity");
            }
            rs.close();
            stmt.close();
            System.out.println("book quantity="+bQuantity);

            if (count < bQuantity && count > 0) {
                // Update book quantity
                String updateQuantitySql = "UPDATE book SET quantity = ? WHERE id = ?";
                stmt = con.prepareStatement(updateQuantitySql);
                stmt.setInt(1, bQuantity - count);
                stmt.setInt(2, Integer.parseInt(bookId));
                int rowsUpdated = stmt.executeUpdate();
                stmt.close();

                if (rowsUpdated > 0) {
                    request.setAttribute("message", " All Book can't be deleted,  assigned to student. remain deleted.");
                } else {
                    request.setAttribute("message", "Failed to update book quantity.");
                }
            } else if (count == bQuantity) {
                request.setAttribute("message", "Can't delete book, all books are assigned.");
            } else if (count == 0) {
                // Delete the book if not issued
                String sqlDelete = "DELETE FROM book WHERE id = ?";
                stmt = con.prepareStatement(sqlDelete);
                stmt.setInt(1, Integer.parseInt(bookId));
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    request.setAttribute("message", "Book deleted successfully.");
                } else {
                    request.setAttribute("message", "Book not found.");
                }
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while deleting the book.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Forward to a JSP page to display the message
        request.getRequestDispatcher("AviewDelete").forward(request, response);
    }
}
