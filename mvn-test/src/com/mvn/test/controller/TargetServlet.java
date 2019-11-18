package com.mvn.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TargetController", urlPatterns = { "/target/*" })
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. get방식이 일어날때마다 날 호출하겠지");
		
		String[] as = request.getParameterValues("a");
	
		List<String> strList = new ArrayList<>();
		for(String a:as) {
			strList.add(a);
		}
		request.setAttribute("list", strList);
		String path ="/views/target/final";
		RequestDispatcher rd =request.getRequestDispatcher(path);
		rd.forward(request, response);
		//System.out.println(strList);
		//response.getWriter().println(strList);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
