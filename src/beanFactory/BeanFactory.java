package beanFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class BeanFactory {
	private static Properties properties;
	private static Map<String,Object> map;
	static{
		InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
		properties=new Properties();
		try {
			properties.load(in);
			Enumeration<Object> keys=properties.keys();
			map=new HashMap<String, Object>();
			while(keys.hasMoreElements()){
				
				String key=keys.nextElement().toString();
				Object value=Class.forName(properties.getProperty(key)).newInstance();
//				System.out.println(key);
				map.put(key, value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Object getBean(String beanname){
		return map.get(beanname);
	}
}
