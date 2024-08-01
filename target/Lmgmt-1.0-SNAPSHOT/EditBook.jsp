<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">history.forward();</script>
<meta charset="UTF-8">
<title>Edit Book</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script type="text/javascript">
    function editBookValidation() {
        var titlePattern = /^[A-Za-z0-9]+(?: [A-Za-z0-9]+)*$/;
        var authorPattern = /^[A-Za-z]+(?: [A-Za-z]+)*$/;
        var numberPattern = /^[1-9]\d*$/;

        var title = document.forms["editBook"]["Bname"].value.trim();
        var author = document.forms["editBook"]["Bauthor"].value.trim();
        var edition = document.forms["editBook"]["Bedition"].value.trim();
        var quantity = document.forms["editBook"]["Bquantity"].value.trim();

        document.getElementById("titleError").innerText = "";
        document.getElementById("authorError").innerText = "";
        document.getElementById("editionError").innerText = "";
        document.getElementById("quantityError").innerText = "";

        if (!titlePattern.test(title)) {
            document.getElementById("titleError").innerText = "Book title must be alphanumeric, can contain spaces, and must not start or end with spaces.";
            return false;
        }
        if (!authorPattern.test(author)) {
            document.getElementById("authorError").innerText = "Author name must contain only alphabetic characters, can contain spaces, and must not start or end with spaces.";
            return false;
        }
        if (!numberPattern.test(edition)) {
            document.getElementById("editionError").innerText = "Edition must be a positive number.";
            return false;
        }
        if (!numberPattern.test(quantity)) {
            document.getElementById("quantityError").innerText = "Quantity must be a positive number.";
            return false;
        }
        return true;
    }
</script>
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
        <h1 class="text-center">Edit Book</h1>
        <form name="editBook" action="AeditBook" method="post" onsubmit="return editBookValidation()" style="margin: 50px 350px 20px 350px; padding: 50px; border: 2px solid #000; background: white;">
            <div class="mb-3">
                <label for="bookTitle" class="form-label">Book Title</label>
                <input type="text" class="form-control" name="Bname" value="<%= request.getAttribute("bookTitle") %>" required>
                <span id="titleError" style="color: red;"></span>
            </div>
            <div class="mb-3">
                <label for="bookAuthor" class="form-label">Book Author</label>
                <input type="text" class="form-control" id="bookAuthor" name="Bauthor" value="<%= request.getAttribute("bookAuthor") %>" required>
                <span id="authorError" style="color: red;"></span>
            </div>
            <div class="mb-3">
                <label for="bookEdition" class="form-label">Book Edition</label>
                <input type="number" class="form-control" id="bookEdition" name="Bedition" value="<%= request.getAttribute("bookEdition") %>" required>
                <span id="editionError" style="color: red;"></span>
            </div>
            <div class="mb-3">
                <label for="bookQuantity" class="form-label">Book Quantity</label>
                <input type="number" class="form-control" id="bookQuantity" name="Bquantity" value="<%= request.getAttribute("bookQuantity") %>" required>
                <span id="quantityError" style="color: red;"></span>
            </div>
            <button type="submit" class="btn btn-primary">Edit</button>
            <input type="hidden" name="bookId" value="<%= request.getAttribute("bookId") %>">
        </form>
          <div class="text-center mt-4">
        <a href="Ahome.jsp" class="btn btn-primary">Go Back</a>
    </div>
    </div>
</body>
</html>
