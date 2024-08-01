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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SnewIssueBook1 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Sid = (String) request.getSession().getAttribute("Sid");
        ResultSet rs = null;
        List<Book> books = new ArrayList<>();
        Connection con = DbConnector.getConnection();
        
        String sql = "Select * from Book";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt("id");
                String Bname = rs.getString("Bname");
                String Author = rs.getString("Author");
                int Edition = rs.getInt("Edition");
                int Quantity = rs.getInt("Quantity");
                
                books.add(new Book(bid, Bname, Author, Edition, Quantity, false));
            }
            ps.close();
            rs.close();
            
            String sqlIssuedCount = "SELECT COUNT(*) AS issuedCount FROM IssueBook where bid=?";
            for (Book b : books) {
                ps = con.prepareStatement(sqlIssuedCount);
                ps.setInt(1, b.getBid());
                rs = ps.executeQuery();
                if (rs.next()) {
                    int remainingB = rs.getInt("issuedCount");
                    int r = b.getQuantity() ;
                    System.out.println("remaining book "+rs.getInt("issuedCount")+" r"+r);
                    b.setQuantity(r);
                    ps.close();
                    rs.close();
                }
            }
            
            String sqlAlreadyIssued = "SELECT COUNT(*) AS yes FROM IssueBook where bid=? and sid=?";
            for (Book b : books) {
                ps = con.prepareStatement(sqlAlreadyIssued);
                ps.setInt(1, b.getBid());
                ps.setString(2, Sid);
                 rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("in snew issen true v"+rs.getInt("yes")+request.getSession().getAttribute("Sid"));
               int num=     rs.getInt("yes");
                    if(num>0)
                    {
                    b.setAlready_Issued(true);}
                    ps.close();
                    rs.close();
                }
            }

            //System.out.println("rs"+rs.getString("Bname"));
        } catch (Exception e) {
            MyLog.MyLogger.logError(" Error in AviewBook Method" + e);
        }
        
        request.setAttribute("books", books);
        System.out.println(books);
        request.getRequestDispatcher("SnewIssueBook.jsp").forward(request, response);
        
    }
}
