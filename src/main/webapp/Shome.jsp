<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies
if(session.getAttribute("Sid")==null)
{
	response.sendRedirect("Slogin.jsp");
}
%>
    <% if (request.getAttribute("message") != null ) { %>
        <div style="background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 10px; margin-bottom: 10px; text-align :center;">
          <%= request.getAttribute("message") %>  
        </div>
        <% request.removeAttribute("message");  %>
     <%   response.setHeader("Refresh", "4; URL=Shome.jsp"); %>
    <% } %>
<input type="hidden" id="Sid" value="<%= session.getAttribute("Sid") %>">
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="margin-top : -10px;">
  <div class="container-fluid " style="background : #32a89e">
    <a class="navbar-brand" href="#">Library Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
        <form action="Slogout" method="post">
           <input type="hidden" id="Sid" name="Sid" value="<%= session.getAttribute("Sid") %>">
            <button type="submit" class="btn btn-primary">LogOut</button>
         </form>
      </ul>
    </div>
  </div>
</nav>
 <form action="Ssearch" method="post" class="d-flex" role="search" style="padding : 50px 150px 50px 150px">
     <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name ="search" required>
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
<div class="row justify-content-center gap-3" >
  <div class="col-sm-2 mb-3 mb-sm-0">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Issued Books</h5>
       <form action="SissueBook" method="post">
           <input type="hidden" id="Sid" name="Sid" value="<%= session.getAttribute("Sid") %>">
            <button type="submit" class="btn btn-primary">Issued</button>
         </form>
      </div>
    </div>
  </div>
  <div class="col-sm-2">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Renew Book</h5>
       <form action="SrenewBook1" method="post">
           <input type="hidden" id="Sid" name="Sid" value="<%= session.getAttribute("Sid") %>">
            <button type="submit" class="btn btn-primary">Renew</button>
         </form>
      </div>
    </div>
  </div>
  <div class="col-sm-2">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Return Book</h5>
        <form action="SreturnBook1" method="post">
            <input type="hidden" id="Sid" name="Sid" value="<%= session.getAttribute("Sid") %>">
            <button type="submit" class="btn btn-primary">Return</button>
         </form>
      </div>
    </div>
  </div>
  <div class="col-sm-2">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">New Issue Book</h5>
        <form action="SnewIssueBook1" method="post">
            <button type="submit" class="btn btn-primary">Issue</button>
         </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>