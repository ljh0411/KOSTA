package ex0410.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

	long start, end;
    public void requestDestroyed(ServletRequestEvent e)  { 
        System.out.println("RequestListener의 requestDestroyed....");
        ServletRequest sr = e.getServletRequest();
        HttpServletRequest request = (HttpServletRequest)sr;
        String url = request.getRequestURL().toString();
        
        end = System.nanoTime();
        System.out.println(url+"에 요청된 총 소요 시간 : "+(end-start)+"ns");
    }

	
    public void requestInitialized(ServletRequestEvent e)  { 
         System.out.println("RequestListener의 requestInitialized...");
         start = System.nanoTime();
       
    }
	
}
//출력결과 : //localhost:8888/step05_ListenerExam/servletContextTest.jsp 문서의
		//총 소요시간~~~~