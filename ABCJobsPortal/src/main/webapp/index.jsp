<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="ISO-8859-1">
        <title>ABC Jobs Community Portal</title>
        <link rel="stylesheet" type="text/css" href="./Bootstrap/bootstrap.css">
        <script type="text/javascript" src="./Bootstrap/bootstrap.js"></script>
        <link rel="stylesheet" href="./CSS/style.css">
    </head>

    <body>
        <%@include file ="/Components/header.jsp" %>
            <main class="w-100 position-relative" style="min-height:1000px">
            	<div class ="position-absolute w-100 h-100" style = "background:rgb(102,255,102); opacity:0.3;">
            		
            	</div>
            	<div class ="position-absolute w-100 h-100">
            		<img src="images/community.jpg" class="w-100 h-100" style ="opacity:0.35;">
            	</div>
            	<div class ="h-100 w-100 position-absolute">
            		<div class ="m-5 p-3 h-100">
            			<h1 class ="display-2 mb-5 fw-bold text-uppercase text-center text-success">Welcome to ABC Jobs Community Portal</h1>
            			<div class ="mt-5 pt-5 position-absolute start-50 start-50 translate-middle-x">
            				<h3 class ="display-6 text-center text-success" style ="max-width:40rem">Inspire, Create, Collaborate, Maintain. Your Story Begins Here</h3>
            				<div class ="position-relative mt-5 pt-5">
            					<div class ="d-flex justify-content-center align-items-end">
            						<a href="Registration" class ="btn btn-success text-uppercase display-6 p-3">Get Started</a>
            					</div>
            				</div>
            			</div>		
            		</div>
            	</div>
            </main>
  		<%@include file ="/Components/footer.html" %>
    </body>

    </html>