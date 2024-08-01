package Sservlets;

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
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SnewIssueBook2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SnewIssueBook2() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate IssueDate = LocalDate.now();
        String issue_date = IssueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate ReturnDate = LocalDate.now().plusDays(14);
        String return_date = ReturnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String bname = request.getParameter("bookName");
        int bid = Integer.parseInt(request.getParameter("bookId"));
        String sid = (String) request.getParameter("Sid");
        System.out.println(sid);
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            con = DbConnector.getConnection();
            
            // Get Admin ID
            String AidSql = "SELECT Adminid FROM book WHERE id = ?";
            statement = con.prepareStatement(AidSql);
            statement.setInt(1, bid);
            rs = statement.executeQuery();
            String aid = null;
            if (rs.next()) {
                aid = rs.getString("Adminid");
            }
            rs.close();
            statement.close();

            if (aid == null) {
                throw new SQLException("Admin ID not found for book ID: " + bid);
            }

            // Get Student Name
            String SnameSql = "SELECT name FROM Student WHERE SmemberId = ?";
            statement = con.prepareStatement(SnameSql);
            statement.setString(1, sid);
            rs = statement.executeQuery();
            String sname = null;
            if (rs.next()) {
                sname = rs.getString("name");
            }
            rs.close();
            statement.close();

            if (sname == null) {
                throw new SQLException("Student name not found for student ID: " + sid);
            }

            
                  String selectQuantitySql = "SELECT quantity FROM Book WHERE id = ?";
                statement = con.prepareStatement(selectQuantitySql);
                statement.setInt(1, bid);
                 rs = statement.executeQuery();
                    if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    // Increment the book quantity by 1
                    int newQuantity = currentQuantity -1;
                    String updateQuantitySql = "UPDATE Book SET quantity = ? WHERE id = ?";
                    statement = con.prepareStatement(updateQuantitySql);
                    statement.setInt(1, newQuantity);
                    statement.setInt(2, bid);
                    statement.executeUpdate();
                }
            statement.close();
            rs.close();
            
            // Insert into IssueBook table
            String sql = "INSERT INTO IssueBook (bname, bid, sname, sid, aid, issue_date, return_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, bname);
            statement.setInt(2, bid);
            statement.setString(3, sname);
            statement.setString(4, sid);
            statement.setString(5, aid);
            statement.setDate(6, java.sql.Date.valueOf(issue_date));
            statement.setDate(7, java.sql.Date.valueOf(return_date));
            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                request.setAttribute("message", "Book Issued successfully!");
            } else {
                request.setAttribute("message", "Failed to Issue the book. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        String newToken = UUID.randomUUID().toString();
        request.getSession().setAttribute("token", newToken);
        request.getRequestDispatcher("SnewIssueBook1").forward(request, response);
    }
}
