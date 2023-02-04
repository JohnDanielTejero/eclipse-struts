package com.lithan.serverletone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addProducts")
public class AddProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.getParameter("product");
		List<String> cart = (ArrayList<String>)session.getAttribute("cart");
		
		if (cart==null) {cart= new ArrayList<>();}
		
		if (req.getParameter("product")!=null) {
			cart.add(req.getParameter("product"));
			
		}
		session.setAttribute("cart", cart);
		req.setAttribute("cart", cart);
		
		String search = (String)session.getAttribute("search");
		
		ApplicationnDao dao = new ApplicationnDao();
		List<Product> products = dao.searchProducts(search);
		
		req.setAttribute("products", products);
		req.getRequestDispatcher("/searchResults.jsp").forward(req,resp);
 	}
}
