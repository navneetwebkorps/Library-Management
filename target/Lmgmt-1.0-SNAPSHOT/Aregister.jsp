
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script type="text/javascript">
      function registerValidation() {
    var namePattern = /^[A-Za-z]+(?: [A-Za-z]+)*[A-Za-z]$/;
    var libraryPattern = /^[A-Za-z]+(?: [A-Za-z]+)*$/;
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    var passwordPattern = /^(?=.*[@#$!%*?&])[A-Za-z\d@#$!%*?&]{8,15}$/;

    var name = document.getElementsByName("name")[0].value;
    var libraryName = document.getElementsByName("Lname")[0].value;
    var email = document.getElementsByName("email")[0].value;
    var password = document.getElementsByName("password")[0].value;

    document.getElementById("nameError").innerText = "";
    document.getElementById("LnameError").innerText = "";
    document.getElementById("emailError").innerText = "";
    document.getElementById("passwordError").innerText = "";

    if (!namePattern.test(name)) {
        document.getElementById("nameError").innerText = "Name must not start or end with spaces and can contain only alphabetic characters and single spaces between words.";
        return false;
    }

    if (!libraryPattern.test(libraryName)) {
        document.getElementById("LnameError").innerText = "Library Name must not start or end with spaces and can contain only alphabetic characters and single spaces between words.";
        return false;
    }

    if (!emailPattern.test(email)) {
        document.getElementById("emailError").innerText = "Please enter a valid email address.";
        return false;
    }

    if (!passwordPattern.test(password)) {
        document.getElementById("passwordError").innerText = "Password must be at least 8 characters long and include at least one special symbol.";
        return false;
    }

    return true;
}
    </script>

</head>
<body style="background : #32a89e"> 
<%   
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies
%>


<form name ="Aregister" action="Aregister"  method="post" onsubmit="return registerValidation()" style="margin :100px 500px 100px 500px ; padding : 50px; border: 2px solid #000; background : white ">
<h1 style="text-align : center">Admin Registration</h1>
  <div class="mb-3">
  	  <label for="name" class="form-label">Name</label>
          <input type="text" class="form-control" id="name" name="name" required>
            <span id="nameError" style="color: red;"></span>
  	<label for="Lname" class="form-label">Library Name</label>
        <input type="text" class="form-control" id="Lname" name="Lname" required >
         <span id="LnameError" style="color: red;"></span>
        <label for="address" class="form-label">Address</label>
  	<input type="text" class="form-control" id="address" name="address" required >
   
        <label for="email1" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email1" name="email" required>
            <span id="emailError" style="color: red;"></span>
    </div>
  <div class="mb-3">
   <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
            <span id="passwordError" style="color: red;"></span>  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>