package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proxy.ArticleServiceProxy;

import beanFactory.BeanFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.ArticleService;
import service.ArticleServiceInter;

import domain.ResultInfo;
import domain.User;

public class ShowAppointArticleServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		ArticleServiceProxy proxy=(ArticleServiceProxy)BeanFactory.getBean("articleServiceProxy");
		ArticleServiceInter service=proxy.getArticleService();
		ResultInfo info=null;
		try{
			int locpage=Integer.parseInt(request.getParameter("locpage"));
			int cid=Integer.parseInt(request.getParameter("cid"));			
			info=service.showAppointArticle(cid, locpage);
		}catch(NumberFormatException e){
			
		}
		response.setContentType("application/json;charset=utf-8");
		ObjectMapper mapper=(ObjectMapper)BeanFactory.getBean("objectMapper");
		mapper.writeValue(response.getOutputStream(),info);
	}

}
