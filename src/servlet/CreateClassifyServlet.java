package servlet;
import domain.Classify;
import domain.ResultInfo;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.ClassifyService;

import domain.User;

public class CreateClassifyServlet extends HttpServlet {

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
		ClassifyService service=new ClassifyService();
		ResultInfo info=new ResultInfo();
		Classify c=null;
		String cname=request.getParameter("cname");
		if(cname.length()==0){
			info.setFlag(false);
		}else{
			info.setFlag(true);
			c=service.createClassify(cname,user.getUid());
			info.setData(c);
		}
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(response.getOutputStream(),info);
	}

}
