<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="ISO-8859-1">
        <title>ABC Jobs Community Portal</title>
        <link rel="shortcut icon" type="images/png" href="./images/UIF logo header.png">
        <link rel="stylesheet" type="text/css" href="./Bootstrap/bootstrap.css">
        <script type="text/javascript" src="./Bootstrap/bootstrap.js"></script>
        <link rel="stylesheet" href="./CSS/style.css">
    </head>

    <body>
			<jsp:include page="/Components/header.jsp"></jsp:include>
            <main class="index-main" style="min-height:1000px">
                <div class="color-fade" style="background:rgb(102,255,102); opacity:0.3;">

                </div>
                <div class="img-overlay">
                    <img src="images/community.jpg">
                </div>
                <div class="text-overlay">
                    <div class="text-content">
                        <h1 class="text-title">Welcome to ABC Jobs Community Portal</h1>
                        <div class="text-description">
                            <h3 class="description-message" style="max-width:40rem">Inspire, Create, Collaborate, Maintain. Your Story Begins Here</h3>
                            <div class="pos-center">
                                <a href="Registration" class="button-green">Get Started</a>
                            </div>

                        </div>
                    </div>
                </div>
            </main>

            <%@include file ="/Components/footer.html" %>
    </body>

    </html>