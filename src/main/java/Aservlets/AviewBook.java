package Aservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import Users.Book;
import dbConnection.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Servlet implementation class AviewBook
 */
public class AviewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AviewBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
				
			
                                  
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
				  req.getRequestDispatcher("AviewBook.jsp").forward(req, resp);
	}

}
