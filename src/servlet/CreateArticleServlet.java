package servlet;
import domain.ResultInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.User;
import domain.Article;
import service.ArticleService;
public class CreateArticleServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		Article art=new Article();
		ArticleService service=new ArticleService();
		Map<String,String[]> map=request.getParameterMap();
		try {
			BeanUtils.populate(art,map);
			art.setContent(request.getParameter("my-editormd-html-code"));
			art.setUid(user.getUid());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
//		String aname=request.getParameter("aname");
//		String content=request.getParameter("my-editormd-html-code");
//		String cid=request.getParameter("classifyId");
//		System.out.println("aname  "+atitle);
//		System.out.println("content  "+content);
//		System.out.println("cid  "+cid);
//		art.setUid(user.getUid());
//		System.out.println("aname  "+art.getAname());
		int flag=service.createArticle(art);
		ObjectMapper mapper=new ObjectMapper();
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(),flag);
	}

}
