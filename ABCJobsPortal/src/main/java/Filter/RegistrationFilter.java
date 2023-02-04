package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.User;
import Classes.DataValidation.EmailValidation;
import Classes.DataValidation.NameValidation;

@WebFilter("/Registration")
public class RegistrationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	HttpServletRequest req = (HttpServletRequest)request;
	HttpServletResponse resp = (HttpServletResponse)response;
	//user class
			User newUser = new User();
			//getting parameters in registration
			String firstName = req.getParameter("FNfield");
			String lastName = req.getParameter("LNfield");
			String emailAddress = req.getParameter("email");
			String password = req.getParameter("PassField");
			String confirmPassword = req.getParameter("ConfirmPassField");
			String agreement = null;
			
			
			//variable for checking purposes only
			Boolean firstNameCheck = false;
			Boolean lastNameCheck = false;
			Boolean emailCheck = false;
			Boolean passwordCheck = false;
			Boolean confirmPWCheck = false;
			Boolean agreementCheck = false;
			
			if(!(firstName == null) && !(lastName ==null) && !(emailAddress == null)
					&& !(password==null) && !(confirmPassword==null)) {
				//check if field is empty
				if((req.getParameter("gridCheck") == null)) {		
					req.setAttribute("errorAgree", "Please acknowledge the terms and conditons of the platform");
					System.out.println("no acknowledgement");
				}else {
					agreement = req.getParameter("gridCheck");
					agreementCheck = true;
					req.setAttribute("errorAgree", "none");
				}
				
				if (firstName.equals("")) {
					req.setAttribute("errorFN", "Do not leave the field empty");
					System.out.println("empty fn");
				}else {
					//check if field has correct data type
					NameValidation validateName = new NameValidation();
					if(!validateName.nameValidate(firstName)) {
						req.setAttribute("errorFN", "invalid name format");
					}else {
						firstNameCheck = true;
						newUser.setFirstName(firstName);
						req.setAttribute("errorFN", "none");
					}
				}
			
				if (lastName.equals("")) {
					req.setAttribute("errorLN", "Do not leave the field empty");
					System.out.println("empty ln");
				}else {
					//check if field has correct data type
					NameValidation validateName = new NameValidation();
					if(!validateName.nameValidate(lastName)) {
						req.setAttribute("errorLN", "invalid name format");
						System.out.println("invalid ln");
					}else {
						lastNameCheck = true;
						newUser.setLastName(lastName);
						req.setAttribute("errorLN", "none");
					}
				}
				
				if (emailAddress.equals("")) {
					req.setAttribute("errorEmail", "Do not leave the field empty");
					System.out.println("empty email");
				}else {
					//check if field has correct data type
					EmailValidation validateEmail = new EmailValidation();
					if(!validateEmail.emailValidate(emailAddress)) {
						req.setAttribute("errorEmail", "invalid email format");
						System.out.println("invalid email");
					}else {
						
						//check if email is registered
						if(validateEmail.checkEmail(emailAddress)) {
							req.setAttribute("errorEmail", "email already registered");
							System.out.println("email already existing, please register a new one");
						}else {
							emailCheck = true;
							req.setAttribute("errorEmail","none");
							newUser.setEmailAddress(emailAddress);
							
						}
					}
				}
				
				if (password.equals("")) {
					req.setAttribute("errorPW", "Do not leave the field empty");
					System.out.println("empty pw");
				}else {
					passwordCheck = true;
					req.setAttribute("errorPW", "none");
				}
				if (confirmPassword.equals("")) {
					req.setAttribute("errorCPW", "Do not leave the field empty");
					System.out.println("empty cpw");
				}else {
					if (!password.equals(confirmPassword)) {
						req.setAttribute("errorCPW", "field does not match the password");
						System.out.println("wrong pw mismatch");
					}else {
						confirmPWCheck = true;
						newUser.setPassword(confirmPassword);
						req.setAttribute("errorCPW", "none");
					}
				}
				
				//check if user data has been validated, if one fails, they will not be registered
				if (proceedRegister(firstNameCheck, lastNameCheck, emailCheck, 
						passwordCheck, confirmPWCheck, agreementCheck)) {
					
					//calling DAO for insert operation]
					req.setAttribute("Registration", "valid");
					req.setAttribute("UserToRegister", newUser);
					
				}else {
					req.getRequestDispatcher("/HTML/Register.jsp").forward(req, resp);
				}
			}
	chain.doFilter(req, resp);
	}

	public Boolean proceedRegister(boolean fnNameCheck, boolean lnNameCheck, boolean emailCheck, 
			boolean passwordCheck, boolean confirmPWCheck, boolean agreementCheck) {
		
		if(fnNameCheck && lnNameCheck && emailCheck && passwordCheck 
				&& confirmPWCheck && agreementCheck) {
			System.out.println("ready for register");
			return true;
		}
		return false;
	}
	
}
