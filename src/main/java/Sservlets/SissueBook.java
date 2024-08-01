/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Sservlets;

import Users.Book;
import dbConnection.DbConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SissueBook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Sid = request.getParameter("Sid");
        ResultSet rs = null;
        List<Book> books = new ArrayList<>();
        Connection con = DbConnector.getConnection();

        String sql = "Select * from IssueBook where sid=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, request.getParameter("Sid"));

            rs = ps.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt("id");
                String Bname = rs.getString("Bname");
               

                Date IssueDate = rs.getDate("issue_date");
                Date ReturnDate = rs.getDate("return_date");

                books.add(new Book(bid, Bname, IssueDate, ReturnDate));
            }
               System.out.println("Sissuebook java"+books);
            //System.out.println("rs"+rs.getString("Bname"));
        } catch (Exception e) {
            MyLog.MyLogger.logError(" Error in SissueBook servlet Method" + e);
        }

        request.setAttribute("books", books);
        System.out.println(books);
        request.getRequestDispatcher("SissueBook.jsp").forward(request, response);

    }
}
