package servlet;
import service.ArticleService;
import service.ArticleServiceInter;
import service.ClassifyServiceInter;
import domain.Article;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proxy.ArticleServiceProxy;
import proxy.ClassifyServiceProxy;

import beanFactory.BeanFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Classify;
import service.ClassifyService;
public class CshowServlet extends HttpServlet {

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
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		int locpage=Integer.parseInt(request.getParameter("locpage"));
		List<Classify> listClassify=null;
		List<Article> listArticle=new ArrayList<Article>();
		ClassifyServiceProxy proxy=(ClassifyServiceProxy)BeanFactory.getBean("classifyServiceProxy");
		ClassifyServiceInter cservice=proxy.getClassifyService();
		ArticleServiceProxy aproxy=(ArticleServiceProxy)BeanFactory.getBean("articleServiceProxy");
		ArticleServiceInter aservice=aproxy.getArticleService();
		listClassify=cservice.getClassifyLimit(user.getUid(), locpage);
		if(listClassify!=null){
			/*遍历list，按classify的顺序将检索到的article放入list集合中*/
			for(Classify c:listClassify){
				int cid=c.getCid();
				listArticle.add(aservice.getArticleOne(cid));
			}
		}
		List<Object> resultList=new ArrayList<Object>();
		resultList.add(listClassify);
		resultList.add(listArticle);
		ObjectMapper mapper=(ObjectMapper)BeanFactory.getBean("objectMapper");
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(),resultList);
	}

}
