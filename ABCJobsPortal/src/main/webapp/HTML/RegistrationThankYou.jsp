<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="shortcut icon" type="images/png" href="../images/UIF logo header.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <title>ABC Jobs Pte Ltd</title>
        <link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css">
        <script src="<%=request.getContextPath()%>/bootstrap/bootstrap.js"></script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style.css">
    </head>

    <body>
        <%@include file = "/Components/header.jsp" %>
            <div class="d-flex justify-content-center p-5" style="min-height: 800px;">
                <div class="row shadow-lg rounded p-5 w-75">
                    <div class="col-12">
                        <h1 class="h2 text-center">Congratulations!</h1>
                    </div>
                    <div class="col-12">
                        <p>
                            You are now officially registered in the community portal. Thank you for registering, should you have any issue within the platform, do not hesitate to contact our support staff. Have fun exploring the community portal. We wish you the best, we hope you
                            find the features helpful not only for you, but also for your career.
                        </p>
                    </div>
                    <div class="col-12">
                        <p></p>
                        <p></p>
                        <p class="text-start">Best regards!</p>
                        <p class="text-start">ABC Jobs Support Staff</p>
                    </div>
                    <div class="d-flex justify-content-center col-12">
                        <button type="button" class="btn btn-outline-success px-4 rounded">Go to Log In</button>
                    </div>
                </div>
            </div>
            <%@include file = "../Components/footer.html" %>

    </body>

    </html>