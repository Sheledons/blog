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

import dao.DelArticleDao;
import domain.Article;
import domain.ResultInfo;
import domain.User;

public class RecoverServlet extends HttpServlet {

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
		ArticleServiceProxy proxy=(ArticleServiceProxy)BeanFactory.getBean("articleServiceProxy");
		ArticleServiceInter service=proxy.getArticleService();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		int uid=user.getUid();
		Article art=null;
		ResultInfo info=new ResultInfo();
		int aid;
		try{
			aid=Integer.parseInt(request.getParameter("aid"));
			art=service.recoverArticle(aid,uid);
			info.setData(art);
			info.setFlag(true);
		}catch(NumberFormatException e){
			info.setFlag(false);
		}
		ObjectMapper mapper=(ObjectMapper)BeanFactory.getBean("objectMapper");
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(),info);
	}
}
