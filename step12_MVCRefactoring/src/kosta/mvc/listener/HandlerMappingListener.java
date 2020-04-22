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
 * ����� ��û�� �ش��ϴ� key�� ���� ��ü�� �̸� �����ؼ�
 * Map�� ������ �� ��� �������� ����� �� �ֵ��� application scope��
 * Map�� �����Ѵ�.
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
		//    	map.put("update", new UpdateController()); �̷��͵� ��� properties ���� ���

		//key�� �ش��ϴ� classname�� �����ϴ� properties�����ε�
		String fileName = application.getInitParameter("fileName");   //web.xml������ context param�� filename �������ְ� ��.
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		Set<String> keys = rb.keySet();

		try {
			for(String key: keys) {
				String value = rb.getString(key);
				//System.out.println(key +" = "+value);
				//String value�� ��ü��(Controller) ���� Map�����Ѵ�.
				Controller controller = (Controller)Class.forName(value).newInstance();   //String ���� ��ü�� ������ش�.
				
				System.out.println(key +" = "+controller);
				map.put(key, controller);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		//application ������ �����Ѵ�.

		application.setAttribute("map", map);

	}

}
