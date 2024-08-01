<%-- 
    Document   : SrenewBook.jsp
    Created on : 22 Jul 2024, 6:38:54 am
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
     <%@ page import="java.util.List" %>
     <%@ page import="Users.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             <table class= "table table-striped">
                    <tr><th>ID</th><th>Name</th><th>Email</th></tr>
                    <% List<Book> books=(List<Book>)request.getAttribute("books");
                       for (Book b : books) {
                    %>    
                        <tr>
                         <form action="SreturnBook2" method="post">    
                        <td><%= b.getBname() %></td>
                        <td><%= b.getAuthor() %></td>
                        <td><%= b.getEdition() %></td>
                        <td><%= b.getEdition() %></td>
                     
                        
                        <input type="hidden" name="bookId" value="<%= b.getBid() %>">
                    <button type="submit" class="btn btn-danger">Return</button></td>
                         </form>
                    </tr>
                    <%
                        }
                    %>
                </table>
    </body>
</html>
