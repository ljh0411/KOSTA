package ex0413.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter {
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SimpleFilter의 init call...........");
		
		//init-param정보 받기
		String addr = filterConfig.getInitParameter("addr");
		String message = filterConfig.getInitParameter("message");
		
		System.out.println(addr);
		System.out.println(message);
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(req, res);   //실제 component 호출됨...
		System.out.println("SimpleFilter 의 사전 처리 중입니다............");

	}
	
	@Override
	public void destroy() {
		System.out.println("SimpleFilter 의 사후 처리 중입니다..........");
	}

}
