package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		User newUser = null;
		//getting parameters in registration
		String firstName = req.getParameter("FNfield");
		String lastName = req.getParameter("LNfield");
		//String emailAddress = req.getParameter("email");
		//String password = req.getParameter("PassField");
		//String confirmPassword = req.getParameter("ConfirmPassField");
		//String agreement = null;
		
		if(req.getAttribute("Registration").equals("valid")) {
			newUser = (User)req.getAttribute("UserToRegister");
			registrationDao register = new registrationDao();
			int updatedRows = register.registerUser(newUser);
			
			if (updatedRows == 0) {
				req.setAttribute("errorEmail", "email already registered");
				System.out.println("email already existing, please register a new one");
				req.getRequestDispatcher("/HTML/Register.jsp").forward(req, resp);
			}else {
				req.setAttribute("Registered", firstName + lastName);
				resp.sendRedirect(req.getContextPath() + "/Register-Success");
				//req.getRequestDispatcher("HTML/RegistrationThankYou.jsp").forward(req, resp);
			}
		}
	
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
