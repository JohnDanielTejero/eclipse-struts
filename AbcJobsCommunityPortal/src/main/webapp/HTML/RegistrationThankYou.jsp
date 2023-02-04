<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="images/png" href="<%=request.getContextPath()%>/images/UIF logo header.png">
        <title>ABC Jobs Pte Ltd</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style.css">
    </head>

    <body>
        <jsp:include page="/Components/header.jsp"></jsp:include>
            <main style="min-height: 800px;">
                <div class="container">
                    <div class="thankyou-card">
                        <div class="card-header">
                            <h1 class="card-title">Congratulations!</h1>
                        </div>
                        <div class="card-message">
                            <p>
                                You are now officially registered in the community portal. Thank you for registering, 
                                should you have any issue within the platform, do not hesitate to contact our support staff. 
                                Have fun exploring the community portal. We wish you the best, we hope you
                                find the features helpful not only for you, but also for your career.
                            </p>
                        </div>
                        <div class="card-author">
                            <p>Best regards!</p>
                            <p>ABC Jobs Support Staff</p>
                        </div>
                        <div class="thankyou-login-button">
                            <button type="button" class="btn btn-main">Go to Log In</button>
                        </div>
                    </div>
                </div>
            </main>
            <%@include file = "../Components/footer.html" %>

    </body>

    </html>