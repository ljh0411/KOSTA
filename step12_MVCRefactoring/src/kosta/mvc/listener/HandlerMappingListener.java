package kosta.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.mvc.controller.Controller;
import kosta.mvc.controller.InsertController;
import kosta.mvc.controller.SelectController;

/**
 * 사용자 요청에 해당하는 key에 따른 객체를 미리 생성해서
 * Map에 저장한 후 모든 영역에서 사용할 수 있도록 application scope에
 * Map을 저장한다.
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {


	public void contextDestroyed(ServletContextEvent sce)  { 

	}


	public void contextInitialized(ServletContextEvent e)  { 
		//System.out.println("HandlerMappingListener call............");

		Map<String, Controller> map = new HashMap<String, Controller>();
		ServletContext application = e.getServletContext();
		//    	map.put("insert", new InsertController());
		//    	map.put("select", new SelectController());
		//    	map.put("delete", new DeleteController());
		//    	map.put("update", new UpdateController()); 이런것들 대신 properties 파일 사용

		//key에 해당하는 classname을 관리하는 properties문서로딩
		String fileName = application.getInitParameter("fileName");   //web.xml문서에 context param에 filename 지정해주고 씀.
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		Set<String> keys = rb.keySet();

		try {
			for(String key: keys) {
				String value = rb.getString(key);
				//System.out.println(key +" = "+value);
				//String value를 객체로(Controller) 만들어서 Map저장한다.
				Controller controller = (Controller)Class.forName(value).newInstance();   //String 값을 객체로 만들어준다.
				
				System.out.println(key +" = "+controller);
				map.put(key, controller);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		//application 영역에 저장한다.

		application.setAttribute("map", map);

	}

}
