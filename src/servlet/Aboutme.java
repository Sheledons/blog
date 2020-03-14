package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.ArticleServiceProxy;
import proxy.UserServiceProxy;

import beanFactory.BeanFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.ArticleService;
import service.ArticleServiceInter;

import domain.Article;

public class Aboutme extends HttpServlet {

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
		Article  art=null;
		ArticleServiceProxy proxy=(ArticleServiceProxy)BeanFactory.getBean("articleServiceProxy");
		ArticleServiceInter service=proxy.getArticleService();
		art=service.getArticle(64);
		response.setContentType("application/json;charset=utf-8");
		ObjectMapper mapper=(ObjectMapper)BeanFactory.getBean("objectMapper");
		mapper.writeValue(response.getOutputStream(),art);
	}

}
