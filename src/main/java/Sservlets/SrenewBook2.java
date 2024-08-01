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
import java.sql.Date;

import dbConnection.DbConnector;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SrenewBook2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SrenewBook2() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        String Sid = request.getParameter("Sid");
        LocalDate newReturnDate = LocalDate.now().plusDays(14);
        Date newReturnDateSQL = Date.valueOf(newReturnDate);

        try {
            Connection con = DbConnector.getConnection();
            String sql = "UPDATE Issuebook SET return_date = ? WHERE sid = ? AND bid = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, newReturnDateSQL);
            stmt.setString(2, Sid);
            stmt.setInt(3, Integer.parseInt(bookId));
            System.out.println("Sid SrenewBook2: " + Sid + ", BookId: " + bookId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                request.setAttribute("message", "Book renewed successfully.");
            } else {
                request.setAttribute("message", "Book not found.");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while renewing the book.");
        }

        request.getRequestDispatcher("SrenewBook1").forward(request, response);
    }
}
