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
@WebFilter("/Register-Success")
public class ThankYouPageFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println(req.getRequestURI());
		System.out.println(req.getAttribute("Registered"));
		if(req.getRequestURI().equals(req.getContextPath() +"/Register-Success")) {
			
			if(req.getAttribute("Registered")==null) {
				req.getRequestDispatcher("/Registration").forward(req, resp);
			}
		}
		chain.doFilter(req, response);
	}
	
}
