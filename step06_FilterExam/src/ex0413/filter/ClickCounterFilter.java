package ex0413.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.bcel.internal.generic.FCONST;


/**
 * Servlet Filter implementation class ClickCounterFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "fileName", value = "clickCount.properties")
		})
public class ClickCounterFilter implements Filter {
	Properties pro = new Properties();
	String path;
	File file;
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("ClickCounterFilter init 호출~~~~~~~~");
		//init-param정보 읽어오기
		String fileName = fConfig.getInitParameter("fileName");

		ServletContext application = fConfig.getServletContext();
		 path = application.getRealPath("/");
		 file = new File(path+"/"+fileName);

		try {
			//count를 저장한 문서가 존재하는지 체크하고
			if(!file.exists()) { //파일이 존재하지 않는다면
				file.createNewFile(); //파일 생성

			}
			
			//무조건 파일은 있다.
			//~.properties파일 로딩해서 자료구조 properties객체에 담는다.
			pro.load(new FileInputStream(file));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}//init 끝

	/**
	 * 병렬처리 프로세스를 분산시켜 좀더 빠르게 작업을 수행 할 수 있도록 Excutor를 사용
	 * jdk 1.5 version에서 추가
	 * 기본 스레드에 대한 부분만 제공한다.
	 * 
	 * Excutor의 구현체 ExecutorService를 이용하면
	 * 스레드의 생성 - 소멸까지 관련된 메소드를 풍부하게 제공한다.
	 */

	ExecutorService service = Executors.newSingleThreadExecutor();
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		//사전 처리
//		//요청된 url 주소를 얻어온다.
//		HttpServletRequest req = (HttpServletRequest)request;
//		String url = req.getRequestURL().toString();
//		
//		//properties 객체안에 url에 해당하는 key가 있는지 찾는다.
//		String value = pro.getProperty(url);
//		if(value==null) {
//			//없으면 key, value를 setXxx()저장 한다.
//			pro.setProperty(url, "1");
//		}else {
//			//있으면 value를 꺼내서 증가하고 다시 저장
//			int count = Integer.parseInt(value)+1;
//			pro.setProperty(url, count+"");
//		}
//		/////////////////////////////////////////////////////여기까지는 자료구조에 data를 넣은것.
//		pro.store(new FileOutputStream(file), ""); //실제 파일에 저장하기
		
		
		//---------------------------------------------------------------
		service.execute(new Runnable() {
			//요청된 url 주소를 얻어온다.
			HttpServletRequest req = (HttpServletRequest)request;
			String url = req.getRequestURL().toString();
			@Override
			public void run() {
				
				
				
				//properties 객체안에 url에 해당하는 key가 있는지 찾는다.
				String value = pro.getProperty(url);
				if(value==null) {
					//없으면 key, value를 setXxx()저장 한다.
					pro.setProperty(url, "1");
				}else {
					//있으면 value를 꺼내서 증가하고 다시 저장
					int count = Integer.parseInt(value)+1;
					pro.setProperty(url, count+"");
				}
				/////////////////////////////////////////////////////여기까지는 자료구조에 data를 넣은것.
				try {
					pro.store(new FileOutputStream(file), ""); //실제 파일에 저장하기
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
				
				
			}
		});
		
		
		chain.doFilter(request, response);
		//사후 처리
		
	}
	
	public void destroy() {
			service.shutdown(); //모든 스레드풀에 있는 스레드를 실행하고 스레드서비스를 종료시킨다.
	}






}
