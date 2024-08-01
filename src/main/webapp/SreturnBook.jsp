<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="Users.Book" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    <script>
        history.go(1);
        </script>
</head>
<body class="bg-light">



<div class="container mt-5">
    <h1 class="text-center">RETURN Book</h1>
    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Issue Date</th>
                    <th>Return Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% List<Book> books = (List<Book>)request.getAttribute("books");
                   for (Book b : books) {
                %>    
                    <tr>
                        <form action="SreturnBook2" method="post">
                            <td><%= b.getBid() %></td>
                            <td><%= b.getBname() %></td>
                            <td><%= b.getIssueDate() %></td>
                            <td><%= b.getReturnDate() %></td>
                            <td>
                                <input type="hidden" name="Sid" value="<%= session.getAttribute("Sid") %>">
                                <input type="hidden" name="bookId" value="<%= b.getBid() %>">
                                <button type="submit" class="btn btn-danger">Return</button>
                            </td>
                        </form>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <div class="text-center mt-4">
        <a href="Shome.jsp" class="btn btn-primary">Go Back</a>
    </div>
</div>

</body>
</html>
