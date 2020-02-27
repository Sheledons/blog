package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.ArticleService;

import domain.Article;
import domain.ResultInfo;
import domain.User;

public class ArticleIdServlet extends HttpServlet {

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
		ResultInfo info=new ResultInfo();
		List<Article> list=null;
		ArticleService service=new ArticleService();
		list=service.getArticleId(user.getUid());
		if(list==null){
			info.setFlag(false);
		}else{
			info.setFlag(true);
			info.setData(list);
		}
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(response.getOutputStream(),info);
	}

}
