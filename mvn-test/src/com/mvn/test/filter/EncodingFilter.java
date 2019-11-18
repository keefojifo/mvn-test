package com.mvn.test.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	private String charSet ="utf-8";
	
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		 String charSet=fConfig.getInitParameter("charSet");
		 
		 //web.xml 에 있는 charSet의 value 값을 가져 오는거 
		 // 톰켓 실행할때 메모리를 생성
		 // filter 대소문자 확인 
		 if(charSet!=null) {
			 this.charSet = charSet;
		 }
		 System.out.println(charSet);
		}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding(this.charSet);
		//HttpServletResponse res =(HttpServletResponse)response;
		//res.setContentType("application/json;charset="+this.charSet);
		System.out.println("application/json;charset="+this.charSet);
		System.out.println("1.dofilter");
		//System.out.println(req.getCharacterEncoding());
		chain.doFilter(request, response);//다음필터에 태우기 위한 chain
	}

	
	

}
