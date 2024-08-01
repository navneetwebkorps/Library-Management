/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Aservlets;

import Users.Book;
import dbConnection.DbConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DELL
 */
public class AviewDelete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public AviewDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

  public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    
            ResultSet rs=null;
				   List<Book> books = new ArrayList<>();
					Connection con=	DbConnector.getConnection();

					String sql="Select * from Book where AdminId=?";
					try {
					PreparedStatement ps=con.prepareStatement(sql);
                                        ps.setString(1, (String) req.getSession().getAttribute("Aid"));
                                        
					 rs=ps.executeQuery();
					  while (rs.next()) {
                                              int bid=rs.getInt("id");
						     String Bname = rs.getString("Bname");
						     String Author = rs.getString("Author");
			                int Edition = rs.getInt("Edition");
			                int Quantity = rs.getInt("Quantity");
			                
			                books.add(new Book(bid,Bname,Author,Edition,Quantity));
			            }
					
			        
					 //System.out.println("rs"+rs.getString("Bname"));
					}catch (Exception e) {
						MyLog.MyLogger.logError(" Error in AviewBook Method"+e);
					}
					
					
				req.setAttribute("books", books);
				System.out.println(books);
				  req.getRequestDispatcher("AdeleteBook.jsp").forward(req, resp);
  
}
}