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
		System.out.println("ClickCounterFilter init ȣ��~~~~~~~~");
		//init-param���� �о����
		String fileName = fConfig.getInitParameter("fileName");

		ServletContext application = fConfig.getServletContext();
		 path = application.getRealPath("/");
		 file = new File(path+"/"+fileName);

		try {
			//count�� ������ ������ �����ϴ��� üũ�ϰ�
			if(!file.exists()) { //������ �������� �ʴ´ٸ�
				file.createNewFile(); //���� ����

			}
			
			//������ ������ �ִ�.
			//~.properties���� �ε��ؼ� �ڷᱸ�� properties��ü�� ��´�.
			pro.load(new FileInputStream(file));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}//init ��

	/**
	 * ����ó�� ���μ����� �л���� ���� ������ �۾��� ���� �� �� �ֵ��� Excutor�� ���
	 * jdk 1.5 version���� �߰�
	 * �⺻ �����忡 ���� �κи� �����Ѵ�.
	 * 
	 * Excutor�� ����ü ExecutorService�� �̿��ϸ�
	 * �������� ���� - �Ҹ���� ���õ� �޼ҵ带 ǳ���ϰ� �����Ѵ�.
	 */

	ExecutorService service = Executors.newSingleThreadExecutor();
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		//���� ó��
//		//��û�� url �ּҸ� ���´�.
//		HttpServletRequest req = (HttpServletRequest)request;
//		String url = req.getRequestURL().toString();
//		
//		//properties ��ü�ȿ� url�� �ش��ϴ� key�� �ִ��� ã�´�.
//		String value = pro.getProperty(url);
//		if(value==null) {
//			//������ key, value�� setXxx()���� �Ѵ�.
//			pro.setProperty(url, "1");
//		}else {
//			//������ value�� ������ �����ϰ� �ٽ� ����
//			int count = Integer.parseInt(value)+1;
//			pro.setProperty(url, count+"");
//		}
//		/////////////////////////////////////////////////////��������� �ڷᱸ���� data�� ������.
//		pro.store(new FileOutputStream(file), ""); //���� ���Ͽ� �����ϱ�
		
		
		//---------------------------------------------------------------
		service.execute(new Runnable() {
			//��û�� url �ּҸ� ���´�.
			HttpServletRequest req = (HttpServletRequest)request;
			String url = req.getRequestURL().toString();
			@Override
			public void run() {
				
				
				
				//properties ��ü�ȿ� url�� �ش��ϴ� key�� �ִ��� ã�´�.
				String value = pro.getProperty(url);
				if(value==null) {
					//������ key, value�� setXxx()���� �Ѵ�.
					pro.setProperty(url, "1");
				}else {
					//������ value�� ������ �����ϰ� �ٽ� ����
					int count = Integer.parseInt(value)+1;
					pro.setProperty(url, count+"");
				}
				/////////////////////////////////////////////////////��������� �ڷᱸ���� data�� ������.
				try {
					pro.store(new FileOutputStream(file), ""); //���� ���Ͽ� �����ϱ�
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
				
				
			}
		});
		
		
		chain.doFilter(request, response);
		//���� ó��
		
	}
	
	public void destroy() {
			service.shutdown(); //��� ������Ǯ�� �ִ� �����带 �����ϰ� �����弭�񽺸� �����Ų��.
	}






}
