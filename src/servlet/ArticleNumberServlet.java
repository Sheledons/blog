package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.User;

import service.ArticleService;
public class ArticleNumberServlet extends HttpServlet {

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
		int number=service.getArticleNumber(uid);
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(response.getOutputStream(),number);
	}

}
