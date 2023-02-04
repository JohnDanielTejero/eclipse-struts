package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.Connect;

@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet{
	
	public Connection connect = null;
	@Override
	public void init() throws ServletException {
		System.out.println("init");
		connect = Connect.connectToDatabase();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("name");
		String htmlResponse = "<html>Welcome </html>";
		
		PrintWriter w = resp.getWriter();
		w.write(htmlResponse + value);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
}
