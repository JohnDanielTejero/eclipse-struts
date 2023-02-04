<%@page import="java.io.PrintWriter"%>
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
    <link href="<%=request.getContextPath()%>/Bootstrap/bootstrap.css">
    <script src="<%=request.getContextPath()%>/Bootstrap/bootstrap.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style.css">
</head>

<body>
    <%@include file = "../Components/header.jsp" %>
    <%!
    	String errorFNMsg;
    	String errorLNMsg;
    	String errorEmailMsg;
    	String errorPWMsg;
    	String errorCPWMsg;
    	String errorAgreeMsg;
    %>
    <div class="container-fluid bg-light">
        <div class="row">
            <div class="d-none d-md-block position-relative col-md-6 col-12 p-5 h-auto" style="background-image:linear-gradient(rgba(155, 255, 137, 0.692),rgba(173, 255, 177, 0.911)); background-size: cover;">
           		<img src ="<%=request.getContextPath()%>/images/login.jpg" class ="w-100 h-100 position-absolute start-0 top-0" style="opacity:0.3">
                <div class ="w-100 h-100 position-absolute start-0 top-0 p-5">
               	 	<h1 class="display-3 mb-6 text-success fw-bold">Connect With Peers</h1>
	                <p class="display-6 text-start text-dark">
	                    Interact, connect, and collaborate. The community portal serves as the bridge that aims to connect one another with things in common such as industry, interest and more. Be a part of the ever-growing community and take advantage of the benefits that the
	                    website is providing. Job hunting will not be a difficult feat as the ABC Jobs Pte Ltd also takes into account the employment rate, such that here, the job opportunities are more open and diverse.
	                </p>
                </div>
            </div>
            <div class="d-flex col-md-6 col-12 p-5 h-auto justify-content-center" style="background-color: white;">
                <div class="p-5 rounded shadow-lg">
                    <form class="row g-3 gy-5 px-5" method="post" action="Registration">
                        <div class="col-md-12 form-floating">
                            <h1 class="display-6 fw-bold text-success">Register</h1>
                        </div>
                        <div class="col-md-12 form-floating">
                           <input type="text" class="form-control  
                           <% if(!((String)request.getAttribute("errorFN")).equals("none")){
                        		errorFNMsg = (String)request.getAttribute("errorFN");%>
                            is-invalid 
                            <%} %>" name="FNfield" 
                            value = "<%=(request.getParameter("FNfield")!=null)? request.getParameter("FNfield"):"" %>"
                            onfocusout="onFocusOut(this)">
                            <label for="FNfield" class="form-label ms-2">First Name</label>
                            <div class ="invalid-feedback">
                            	<span id="errorFNMsg">
                            		<%=errorFNMsg%>
                            	</span>
                            </div>
                            
                        </div>
                        <div class="col-md-12 form-floating">
                            <input type="text" class="form-control
                             <% if(!((String)request.getAttribute("errorLN")).equals("none")){
                        		errorLNMsg = (String)request.getAttribute("errorLN");%> is-invalid 
                        	<%} %>" name="LNfield" 
                        	value = "<%=(request.getParameter("LNfield")!=null)? request.getParameter("LNfield"):"" %>"
                        	onfocusout="onFocusOut(this)">
                            <label for="LNfield" class="form-label ms-2">Last Name</label>
                            <div class ="invalid-feedback">
                            	<span id="errorLNMsg">
                            		<%=errorLNMsg%>
                            	</span>
                            </div>
                        </div>
                        
                        <div class="col-12 form-floating">
                         	<input type="text" class="form-control
                         	<% if(!((String)request.getAttribute("errorEmail")).equals("none")){
                        		errorEmailMsg = (String)request.getAttribute("errorEmail");%>
                        		is-invalid
                        	<%} %>" name="email" 
                        	value = "<%=(request.getParameter("email")!=null)? request.getParameter("email"):"" %>"
                        	onfocusout="onFocusOut(this)">
                            <label for="email" class="form-label ms-2">Email</label>
                            <div class ="invalid-feedback">
                            	<span id="errorEmailMsg">
                            		<%=errorEmailMsg%>
                            	</span>
                            </div>
                        </div>
                        <div class="col-md-12 form-floating">
                            <input type="password" class="form-control
                            <% if(!((String)request.getAttribute("errorPW")).equals("none")){
                        		errorPWMsg = (String)request.getAttribute("errorPW");%>
                        		is-invalid
                        	<%} %>" name="PassField" 
                        	value = "<%=(request.getParameter("PassField")!=null)? request.getParameter("PassField"):"" %>"
                        	onfocusout="onFocusOut(this)">
                            <label for="PassField" class="form-label ms-2">Password</label>
                            <div class ="invalid-feedback">
                            	<span id="errorPWMsg">
                            		<%=errorPWMsg%>
                            	</span>
                           </div>
                        </div>
                        <div class="col-md-12 form-floating">
                            <input type="password" class="form-control
                            <% if(!((String)request.getAttribute("errorCPW")).equals("none")){
                        		errorCPWMsg = (String)request.getAttribute("errorCPW");%>
                        		is-invalid
                        	<%} %>" name="ConfirmPassField"
                        	value = "<%=(request.getParameter("ConfirmPassField")!=null)? request.getParameter("ConfirmPassField"):"" %>"
                        	onfocusout="onFocusOut(this)">
                            <label for="ConfirmPassField" class="form-label ms-2">Confirm Password</label>
                        	<div class ="invalid-feedback">
                            	<span id="errorCPWMsg">
                            		<%=errorCPWMsg%>
                            	</span>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="gridCheck" value="true" onchange ="onCheck()">
                                <label class="form-check-label" for="gridCheck">
                                    I hereby acknowledge the terms and conditions of the website. I give full consent to
                                    the ABC Jobs in managing my personal data.
                                </label>
                                <% if(!((String)request.getAttribute("errorAgree")).equals("none")){
 									errorAgreeMsg = (String)request.getAttribute("errorAgree");%>
 									<span id="errorAgreeMsg" class ="text-danger">
		                            		<%=errorAgreeMsg%>
		                            </span>
                                <%}%>        
                            </div>
                        </div>
                        <div class="col-12">
                            <button type="submit" class="btn btn-main p-2 w-100">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  	<%@include file = "../Components/footer.html" %>
  	
  	<!-- Just to remove error highlights -->
  	<script>
  		function onFocusOut(e){
  			e.classList.remove("is-invalid"); 
  		}
  		
  		function onCheck(){
  			const errorMessage = document.querySelector("#errorAgreeMsg");
  			errorMessage.classList.add("d-none");
  		}
  	</script>
  	
</body>

</html>