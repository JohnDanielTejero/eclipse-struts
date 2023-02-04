package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.User;
import Classes.DataValidation.EmailValidation;
import Classes.DataValidation.NameValidation;
import DataAccessObject.registrationDao;



@WebServlet("/Registration")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("errorFN", "none");
		req.setAttribute("errorLN", "none");
		req.setAttribute("errorEmail","none");
		req.setAttribute("errorPW", "none");
		req.setAttribute("errorCPW", "none");
		req.setAttribute("errorAgree", "none");
		
		//go to registration page
		req.getRequestDispatcher("/HTML/Register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//user class
		User newUser = new User();
		//getting parameters in registration
		String firstName = req.getParameter("FNfield");
		String lastName = req.getParameter("LNfield");
		String emailAddress = req.getParameter("email");
		String password = req.getParameter("PassField");
		String confirmPassword = req.getParameter("ConfirmPassField");
		String agreement = null;
		
		System.out.println(agreement);
		//variable for checking purposes only
		Boolean firstNameCheck = false;
		Boolean lastNameCheck = false;
		Boolean emailCheck = false;
		Boolean passwordCheck = false;
		Boolean confirmPWCheck = false;
		Boolean agreementCheck = false;
		
		//check if field is empty
		if((req.getParameter("gridCheck") == null)) {		
			req.setAttribute("errorAgree", "Please acknowledge the terms and conditons of the platform");
			//System.out.println("no acknowledgement");
		}else {
			agreement = req.getParameter("gridCheck");
			agreementCheck = true;
			req.setAttribute("errorAgree", "none");
		}
		
		if (firstName.equals("")) {
			req.setAttribute("errorFN", "Do not leave the field empty");
			//System.out.println("empty fn");
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
			//System.out.println("empty ln");
		}else {
			//check if field has correct data type
			NameValidation validateName = new NameValidation();
			if(!validateName.nameValidate(lastName)) {
				req.setAttribute("errorLN", "invalid name format");
				//System.out.println("invalid ln");
			}else {
				lastNameCheck = true;
				newUser.setLastName(lastName);
				req.setAttribute("errorLN", "none");
			}
		}
		
		if (emailAddress.equals("")) {
			req.setAttribute("errorEmail", "Do not leave the field empty");
			//System.out.println("empty email");
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
			//System.out.println("empty pw");
		}else {
			passwordCheck = true;
			req.setAttribute("errorPW", "none");
		}
		if (confirmPassword.equals("")) {
			req.setAttribute("errorCPW", "Do not leave the field empty");
			//System.out.println("empty cpw");
		}else {
			if (!password.equals(confirmPassword)) {
				req.setAttribute("errorCPW", "field does not match the password");
				//System.out.println("wrong pw mismatch");
			}else {
				confirmPWCheck = true;
				newUser.setPassword(confirmPassword);
				req.setAttribute("errorCPW", "none");
			}
		}
		
		//check if user data has been validated, if one fails, they will not be registered
		if (proceedRegister(firstNameCheck, lastNameCheck, emailCheck, 
				passwordCheck, confirmPWCheck, agreementCheck)) {
			
			//calling DAO for insert operation
			registrationDao register = new registrationDao();
			int updatedRows = register.registerUser(newUser);
			
			if (updatedRows == 0) {
				req.setAttribute("errorEmail", "email already registered");
				//System.out.println("email already existing, please register a new one");
				req.getRequestDispatcher("/HTML/Register.jsp").forward(req, resp);
			}else {
				//System.out.println("user successfully registered");
				req.setAttribute("Registered", firstName + lastName);
				resp.sendRedirect(req.getContextPath() + "/Register-Success");
				//req.getRequestDispatcher("/Register-Success").forward(req, resp);
				
			}
			
		}else {
			req.getRequestDispatcher("/HTML/Register.jsp").forward(req, resp);
			
		}
	}
	
	public Boolean proceedRegister(boolean fnNameCheck, boolean lnNameCheck, boolean emailCheck, 
			boolean passwordCheck, boolean confirmPWCheck, boolean agreementCheck) {
		
		if(fnNameCheck && lnNameCheck && emailCheck && passwordCheck 
				&& confirmPWCheck && agreementCheck) {
			//System.out.println("ready for register");
			return true;
		}
		return false;
	}
	
}
