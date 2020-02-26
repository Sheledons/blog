package servlet;
import domain.ResultInfo;
import domain.Article;
import domain.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


import service.ArticleService;
public class ArticleByTimesServlet extends HttpServlet {

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
		ArticleService service=new ArticleService();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		Integer uid=user.getUid();
		List<Article> list=service.getArticleByTimes(uid);
		ResultInfo info=new ResultInfo();
		if(list==null){
			info.setFlag(false);
		}else{
			info.setData(list);
			info.setFlag(true);
		}
		ObjectMapper mapper=new ObjectMapper();
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(),info);
	}

}
