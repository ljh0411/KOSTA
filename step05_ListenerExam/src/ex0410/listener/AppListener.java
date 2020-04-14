package ex0410.listener;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;

public class AppListener implements ServletContextListener {

	/**
	 * ServletContext(application)이 start될때 호출
	 */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("AppListener 의 contextInitialized........");
		
		//각 나라별 국가코드를 설정해서 모든 영역에서 사용할 수 있도록 한다.
		Map<String,String> map = new HashMap<String, String>();
		map.put("kr", "대한민국");
		map.put("us", "미국");
		map.put("jp", "일본");
		map.put("ch", "중국");
		map.put("fr", "프랑스");
		
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);
		
		String contextPath = application.getContextPath();
		application.setAttribute("path", contextPath);
	}
	
	/**
	 * ServletContext(application)이 stop 될때 호출
	 */

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener 의 contextDestroyed........");
	}
	
}
