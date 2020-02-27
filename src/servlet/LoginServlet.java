package servlet;
import service.UserService;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.ResultInfo;
import domain.User;
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("dopost");
		User user=new User();
		Map<String,String[]> map=req.getParameterMap();	
		try {
			BeanUtils.populate(user,map);//java工具类 BeanUtils
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("name  "+user.getName());
		System.out.println("pwd  "+user.getPwd());
		UserService service=new UserService();
		ResultInfo info=new ResultInfo();
		ObjectMapper mapper=new ObjectMapper();
		User ruser=service.login(user);
		if(ruser==null){//验证失败
			info.setFlag(false);
		}else{//验证成功
			info.setFlag(true);
			HttpSession session=req.getSession();
			ruser.setPwd("");
			session.setAttribute("user",ruser);
		}
		resp.setContentType("application/json;charset=utf-8");
		mapper.writeValue(resp.getOutputStream(),info);
	}
}
