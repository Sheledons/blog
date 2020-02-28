package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ShowArticleFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session=((HttpServletRequest) request).getSession();
		int aid=0;
		try{
			aid=Integer.parseInt((String)request.getParameter("aid"));
			session.setAttribute("aid",aid);
			System.out.println("aid : "+aid);
			HttpServletResponse resp=(HttpServletResponse)response;
			ObjectMapper mapper=new ObjectMapper();
			resp.setContentType("application/json;charset=utf-8");
			mapper.writeValue(resp.getOutputStream(),"showArticlePage.html");
		}catch(NumberFormatException e){
			System.out.println("NumberFormatException");
			chain.doFilter(request,response);
		}catch(NullPointerException n){
			System.out.println("NullPointerException");
			chain.doFilter(request,response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
