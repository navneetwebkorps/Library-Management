<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="Users.Book" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0"); // Proxies

        if (session.getAttribute("Aid") == null) {
            response.sendRedirect("Alogin.jsp");
        }
    %>
    <div class="container mt-5">
        <h1 class="text-center">Book List</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Edition</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Book> books = (List<Book>) request.getAttribute("books");
                    for (Book b : books) {
                %>
                    <tr>
                        <td><%= b.getBname() %></td>
                        <td><%= b.getAuthor() %></td>
                        <td><%= b.getEdition() %></td>
                        <td><%= b.getQuantity() %></td>
                    </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
        <div class="text-center mt-4">
            <a href="Ahome.jsp" class="btn btn-secondary">Return</a>
        </div>
    </div>
</body>
</html>
