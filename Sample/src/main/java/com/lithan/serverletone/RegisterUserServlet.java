package com.lithan.serverletone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/registerUser", initParams = @WebInitParam(name ="name",value="value"))
public class RegisterUserServlet extends HttpServlet{
	
	public String getHTMLString(String filePath, String message) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line="";
		StringBuffer buffer = new StringBuffer();
		while((line=reader.readLine())!=null){
			buffer.append(line);
		}
		
		reader.close();
		String page = buffer.toString();
		
		page = MessageFormat.format(page, message);
		
		return page;
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String activity = req.getParameter("activity");
		int age = Integer.parseInt(req.getParameter("age"));
		
		User user = new User(username, password, firstName,lastName, age, activity);
		
		ApplicationnDao dao = new ApplicationnDao();
		int rows = dao.registerUser(user);
		String infomessage = null;
		if (rows ==0) {
			infomessage = "something went wrong";
		}else {
			infomessage = "user successfully registered";
		}
		System.out.println(infomessage + ", "+ rows +"affected");
		
		String page = getHTMLString(req.getServletContext().getRealPath("/register.html"),infomessage);
		resp.getWriter().write(page);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = getHTMLString(req.getServletContext().getRealPath("/register.html"),"");
		resp.getWriter().write(page);
		
	}
}
