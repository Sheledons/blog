package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.ClassifyService;

import dao.UserDao;
import domain.User;

public class DeleteClassifyServlet extends HttpServlet {

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
		ClassifyService service=new ClassifyService();
		boolean flag;
		int cid=0;
		try{
			cid=Integer.parseInt(request.getParameter("cid"));
		    flag=service.delClassify(cid);
		}catch(NumberFormatException e){
			//≤ª¥¶¿Ì
			flag=false;
		}
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(response.getOutputStream(),flag);
	}
}
