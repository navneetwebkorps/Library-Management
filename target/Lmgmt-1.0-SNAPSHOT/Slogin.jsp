<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script type="text/javascript">
    function loginValidation() {
        var memberIdPattern = /^[A-Z][0-9]{6}$/; // Assuming Member ID is alphanumeric
            var passwordPattern = /^[a-z]+@[0-9]+$/;

        var memberId = document.forms["Slogin"]["Sid"].value;
        var password = document.forms["Slogin"]["password"].value;

        document.getElementById("memberIdError").innerText = "";
        document.getElementById("passwordError").innerText = "";

        if (!memberIdPattern.test(memberId)) {
            document.getElementById("memberIdError").innerText = "Member ID must be alphanumeric.";
            return false;
        }
        if (!passwordPattern.test(password)) {
            document.getElementById("passwordError").innerText = "Password pattern not matched.";
            return false;
        }
        return true;
    }
</script>
</head>

<body style="background : #32a89e">
    <% if (request.getAttribute("message") != null ) { %>
        <div style="background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 10px; margin-bottom: 10px; text-align :center;">
          <%= request.getAttribute("message") %>  
        </div>
        <% request.removeAttribute("message");  %>
     <%   response.setHeader("Refresh", "2; URL=Shome.jsp"); %>
    <% } %>
    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("Expires", "0"); // Proxies
    if (session.getAttribute("Sid") != null) {
        response.sendRedirect("Shome.jsp");
    }
    %>
    <form name="Slogin" action="Slogin" method="post" onsubmit="return loginValidation()" style="margin: 100px 500px 100px 500px; padding: 50px; border: 2px solid #000; background: white;">
        <h1 style="text-align: center">Student Login</h1>
        <div class="mb-3">
            <label for="Sid" class="form-label">Member ID</label>
            <input type="text" class="form-control" id="Sid" name="Sid" required>
            <span id="memberIdError" style="color: red;"></span>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
            <span id="passwordError" style="color: red;"></span>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
     <div class="text-center mt-4">
        <a href="Sregister.jsp" class="btn btn-primary">Register</a>
    </div>
</body>
</html>
