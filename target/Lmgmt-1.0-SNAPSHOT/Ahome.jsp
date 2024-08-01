
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script >

</script>
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

if (session.getAttribute("Aid") == null) {
    response.sendRedirect("Alogin.jsp");
}
%>
<%


if (request.getAttribute("Lmessage") != null ) { %>
        <div style="background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 10px; margin-bottom: 10px; text-align :center;">
          <%= request.getAttribute("Lmessage") %>  
        </div>
        <% request.removeAttribute("Lmessage");    %>
     <%   response.setHeader("Refresh", "4; URL=Ahome.jsp"); %>
    <% } %>
    
    <% if (request.getAttribute("AeditBook") != null ) { %>
        <div style="background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 10px; margin-bottom: 10px; text-align :center;">
          <%= request.getAttribute("AeditBook") %>  
        </div>
        <% request.removeAttribute("message");  %>
     <%   response.setHeader("Refresh", "4; URL=Ahome.jsp"); %>
    <% } %>
    
<% if (request.getAttribute("message") != null ) { %>
        <div style="background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 10px; margin-bottom: 10px; text-align :center;">
          <%= request.getAttribute("message") %>  
        </div>
        <% request.removeAttribute("message");  %>
     <%   response.setHeader("Refresh", "4; URL=Ahome.jsp"); %>
    <% } %>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="margin-top : -10px;">
  <div class="container-fluid " style="background : #32a89e">
    <a class="navbar-brand" href="#">Library Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
        <form action="Alogout" method="post">
           <input type="hidden" id="Aid" name="Aid" value="<%= session.getAttribute("Aid") %>">
            <button type="submit" class="btn btn-primary">LogOut</button>
         </form>
      </ul>
    </div>
  </div>
</nav>
  
<div class="row justify-content-center gap-3" >


  <div class="col-sm-2 mb-3 mb-sm-0">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Add Book</h5>
      <form action="AaddBook1" method="post">
            <button type="submit" class="btn btn-primary">Add</button>
         </form>
      </div>
    </div>
  </div>
 
  

  <div class="col-sm-2">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">View Book</h5>
        <form action="AviewBook" method ="post">
                    <input type="hidden" id="Aid" name="Aid" value="<%= session.getAttribute("Aid") %>">
     <button type="submit" class="btn btn-primary">View</button>
       </form>
      </div>
    </div>
  </div>

  

  <div class="col-sm-2">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Issued Book</h5>
         <form action="AissuedBook" method="post">
             <input type="hidden" id="Aid" name="Aid" value="<%= session.getAttribute("Aid") %>">
           <button type="submit" class="btn btn-primary">Issued</button>
         </form>
      </div>
    </div>
  </div>

  
  
  
   <div class="col-sm-2">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Delete Book</h5>
        <form action="AviewDelete" method ="post">
            <input type="hidden" id="Aid" name="Aid" value="<%= session.getAttribute("Aid") %>">
     <button type="submit" class="btn btn-primary">Delete </button>
         </form>
      </div>
    </div>
  </div>
 
  
  
  
  <div class="col-sm-2">
    <div class="card">
      <div class="card-body">
     <h5 class="card-title">Edit Book</h5>
     
         <form action="AeditBook1" method="post">
             <input type="hidden" id="Aid" name="Aid" value="<%= session.getAttribute("Aid") %>">
     <button type="submit" class="btn btn-primary">Edit </button>
         </form>
         
       
      </div>
    </div>
  </div>
  
</div>


</body>
</html>