
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
 crossorigin="anonymous">
<style>.carousel {
  overflow: hidden; /* Hide any overflow beyond the carousel */
}

.carousel-inner {
  max-height: 92vh; /* Ensure the carousel items do not exceed viewport height */
}</style>
 
</head>
<body>
   <% if (session.getAttribute("AregistrationSuccess") != null && (boolean) session.getAttribute("AregistrationSuccess")) { %>
        <div style="background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 10px; margin-bottom: 10px; text-align :center;">
            Admin registered successfully!
        </div>
        <% session.removeAttribute("AregistrationSuccess");  %>
     <%   response.setHeader("Refresh", "4; URL=index.jsp"); %>
    <% } %>
      <% if (session.getAttribute("SregistrationSuccess") != null && (boolean) session.getAttribute("SregistrationSuccess")) { %>
        <div style="background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 10px; margin-bottom: 10px; text-align :center;">
            User registered successfully!
        </div>
        <% session.removeAttribute("SregistrationSuccess");  %>
     <%   response.setHeader("Refresh", "4; URL=index.jsp"); %>
    <% } %>
 <%@ include file="header.jsp" %>
 
<div id="carouselExample" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item active" >
      <img src="Resources/img1.jpg" class="d-block w-100 "alt="...">
    </div>
    <div class="carousel-item">
      <img src="Resources/img2.jpg" class="d-block w-100 " alt="...">
    </div>
    <div class="carousel-item">
      <img src="Resources/img4.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</body>
</html>