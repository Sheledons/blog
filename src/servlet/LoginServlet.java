package servlet;
import service.UserService;
import service.UserServiceInter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import proxy.UserServiceProxy;

import beanFactory.BeanFactory;

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
		UserServiceProxy proxy=(UserServiceProxy)BeanFactory.getBean("userServiceProxy");
		UserServiceInter service=proxy.getUserService();
		ResultInfo info=new ResultInfo();
		ObjectMapper mapper=(ObjectMapper)BeanFactory.getBean("objectMapper");
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
