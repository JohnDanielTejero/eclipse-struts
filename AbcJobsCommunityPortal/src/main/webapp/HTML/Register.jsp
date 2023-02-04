<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ABC Jobs Community Portal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="images/png" href="<%=request.getContextPath()%>/images/UIF logo header.png">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style.css">
</head>
<body>
        <jsp:include page="/Components/header.jsp"></jsp:include>
        <%!
	    	String errorFNMsg;
	    	String errorLNMsg;
	    	String errorEmailMsg;
	    	String errorPWMsg;
	    	String errorCPWMsg;
	    	String errorAgreeMsg;
    	%>

         <div class="registration-main">
             <div class="registration-img-overlay" style="background-image:linear-gradient(rgba(155, 255, 137, 0.692),rgba(173, 255, 177, 0.911)); background-size: cover;">
                   <img src="<%=request.getContextPath()%>/images/login.jpg" style="opacity:0.3">
                   <div class="registration-text">
	                    <div style="padding:3rem;">
	                       <h1 class="registration-title">Connect With Peers</h1>
	                        <p class="registration-message">
	                          	Interact, connect, and collaborate. The community portal serves as the bridge that aims to connect one another with things in common such as industry, 
	                          	interest and more. Be a part of the ever-growing community and take advantage of the benefits that the
	                            website is providing. Job hunting will not be a difficult feat as the ABC Jobs Pte Ltd also takes into account the employment rate, such that here, 
	                            the job opportunities are more open and diverse.
	                        </p>
	                    </div>
                   </div>
             </div>
              <div class="registration-form" style="background-color: white;">
                 <div class="form">
                      <form class="row g-3 gy-5 px-5" method="post" action="Registration">
                           <div>
                               <h1 class="display-6 fw-bold text-success">Register</h1>
                           </div>
                           <div class="form-floating">
                               <input type="text" class="form-control  
                                <% if(!((String)request.getAttribute("errorFN")).equals("none")){
                                    errorFNMsg = (String)request.getAttribute("errorFN");%>
                        			is-invalid 
                        		<%} %>" 
                        		name="FNfield" onfocusout="onFocusOut(this)"
                        		value = "<%=(request.getParameter("FNfield")!=null)?request.getParameter("FNfield"):""%> ">
                                <label for="FNfield" class="form-label">First Name</label>
                                <div class="invalid-feedback">
                                   <span id="errorFNMsg ">
                                      <%=errorFNMsg%>
                            	   </span>
                                </div>
                            </div>
                            <div class="form-floating">
                                  <input type="text" class="form-control 
                                  <% if(!((String)request.getAttribute("errorLN")).equals("none")){ 
                                	  errorLNMsg =( String)request.getAttribute("errorLN");%> 
                                  is-invalid
                                  <%} %>" name="LNfield" onfocusout="onFocusOut(this)">
                                  <label for="LNfield" class="form-label">Last Name</label>
                                  <div class="invalid-feedback">
                                     <span id="errorLNMsg">
                                        <%=errorLNMsg%>
                           			 </span>
                                  </div>
                            </div>
							<div class="form-floating">
                                 <input type="text" class="form-control
                                 <% if(!((String)request.getAttribute("errorEmail")).equals("none")){
                                    errorEmailMsg = (String)request.getAttribute("errorEmail");%>
                                     is-invalid
                                 <%} %>" name="email" onfocusout="onFocusOut(this)">
                                  <label for="email" class="form-label">Email</label>
                                  <div class="invalid-feedback">
                                      <span id="errorEmailMsg">
                                        	<%=errorEmailMsg%>
                            		  </span>
                                  </div>
                           	</div>
                            <div class="form-floating">
                                <input type="password" class="form-control 
                               	<% if(!((String)request.getAttribute("errorPW")).equals("none")){
                                    errorPWMsg = (String)request.getAttribute("errorPW");%>
                                    is-invalid 
                                <%} %>" name="PassField" onfocusout="onFocusOut(this)">
                                <label for="PassField" class="form-label">Password</label>
                                <div class="invalid-feedback">
                                     <span id="errorPWMsg">
                                        <%=errorPWMsg%>
                            		</span>
                                </div>
                            </div>
                            <div class="form-floating">
                                <input type="password" class="form-control 
                                <% if(!((String)request.getAttribute("errorCPW")).equals("none")){
                                    errorCPWMsg = (String)request.getAttribute("errorCPW");%>
                                    is-invalid 
                               	<%} %>" name="ConfirmPassField" onfocusout="onFocusOut(this) ">
                                 <label for="ConfirmPassField" class="form-label">Confirm Password</label>
                                 <div class="invalid-feedback">
                                     <span id="errorCPWMsg">
                                        <%=errorCPWMsg%>
                            		 </span>
                                  </div>
                            </div>
                            <div class="form-floating">
                                 <div class="form-check">
                                   		<input class="form-check-input" type="checkbox" name="gridCheck" value="true" onchange="onCheck()">
                                        <label class="form-check-label" for="gridCheck">
                                				I hereby acknowledge the terms and conditions of the website. I give full consent to
                                				the ABC Jobs in managing my personal data.
                            			</label>
                                        <% if(!((String)request.getAttribute("errorAgree")).equals("none")){
                                				errorAgreeMsg = (String)request.getAttribute("errorAgree");%>
                                                <span id="errorAgreeMsg" class="check-error">
                                       					<%=errorAgreeMsg%>
                               					</span>
                                       <%}%>
                                   </div>
                           	</div>
                            <div class="button-submit">
                                 <button type="submit" class="btn btn-main">Register</button>
                            </div>
             		</form>
               	</div>
          	</div>
     	</div>

        <%@include file = "../Components/footer.html" %>
		<!-- Just to remove error highlights -->
        <script>
          function onFocusOut(e) {
             e.classList.remove("is-invalid");
          }

          function onCheck() {
              const errorMessage = document.querySelector("#errorAgreeMsg");
              errorMessage.classList.add("d-none");
             }
       </script>
</body>
</html>