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
public class SreturnBook2 extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String Sid=    request.getParameter("Sid");
             String bookId = request.getParameter("bookId");
             ResultSet rs=null;
				   
					Connection con=	DbConnector.getConnection();

			
					try {
				 String sql = "DELETE FROM IssueBook WHERE sid = ? AND bid = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Sid);
            stmt.setString(2, bookId);
            
                                          // Execute the delete statement
	                int rowsAffected = stmt.executeUpdate();
                        stmt.close();
                      String selectQuantitySql = "SELECT quantity FROM Book WHERE id = ?";
                stmt = con.prepareStatement(selectQuantitySql);
                stmt.setInt(1, Integer.parseInt(bookId));
                 rs = stmt.executeQuery();
                    if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    
                    // Increment the book quantity by 1
                    int newQuantity = currentQuantity + 1;
                    String updateQuantitySql = "UPDATE Book SET quantity = ? WHERE id = ?";
                    stmt = con.prepareStatement(updateQuantitySql);
                    stmt.setInt(1, newQuantity);
                    stmt.setInt(2, Integer.parseInt(bookId));
                    stmt.executeUpdate();
                }
                
                rs.close();
	                if (rowsAffected > 0) {
	                    request.setAttribute("message", "Book returned successfully.");
	                } else {
	                    request.setAttribute("message", "Book not found.");
	                }

					
			        
					 //System.out.println("rs"+rs.getString("Bname"));
					}catch (Exception e) {
						MyLog.MyLogger.logError(" Error in AviewBook Method"+e);
					}
					
					
				
				  request.getRequestDispatcher("SreturnBook1").forward(request, response);
  
}
}
    



