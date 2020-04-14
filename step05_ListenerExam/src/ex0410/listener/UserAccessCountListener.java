package ex0410.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 * tomcat version 9.x 이므로 interface에 있는 메소드 default이다.
 * 그래서 , 필요한 
 *
 */
//annotaion listener 등록
@WebListener
public class UserAccessCountListener implements HttpSessionListener, ServletContextListener {
	/**
	 *1. 서버가 start될때 접속자 수를 count 해줄 변수의 초기화 작업이 필요
	 */
	
	ServletContext application;
	@Override
	public void contextInitialized(ServletContextEvent e) {
		application = e.getServletContext();
		
		application.setAttribute("count", new AtomicInteger()); //서버가 스타트될때 count에 0이 초기화됨.
	}
	
	/**
	 * 2. session이 시작되면 접속자 수를 증가한다
	 */
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		AtomicInteger count = (AtomicInteger)application.getAttribute("count");
		
		//증가
		int i = count.incrementAndGet();
		System.out.println("증가된 후 : "+i+"명");
	}
	
	/**
	 * 2. session이 종료되면 접속자 수를 감소한다
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		AtomicInteger count = (AtomicInteger)application.getAttribute("count");
		int i = count.decrementAndGet();
		System.out.println("감소된 후 : "+i+"명");
	}
		
}
