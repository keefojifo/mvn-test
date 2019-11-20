package com.mvn.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.service.impl.UserInfoServiceImpl;
import com.mvn.test.vo.UserInfoVO;


@WebServlet(name="UserInfoController" , urlPatterns= {"/user/*"})
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uis = new UserInfoServiceImpl();
	private Gson gson = new Gson();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/user/* 의 get 요청이 오면 여기를 거친다");
		response.setContentType("application/json;charset=utf-8");
		String cmd = request.getRequestURI().substring(6);
		System.out.println("나는 controller의 cmd 값 URL을 확인해서 알맞은 곳으로 보내주지"+ cmd);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(uis.getUserList(null));
		}else if("view".equals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("uiNum"));
			UserInfoVO user = new UserInfoVO();
			user.setUiNum(uiNum);
			json = gson.toJson(uis.getUser(user));
		}
		response.getWriter().print(json);
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1. user controller dopost 메소드 입니다.");
		response.setContentType("application/json;charset=utf-8");
		
		BufferedReader br = request.getReader();
		String str =  null;
		String json = "";
		while((str=br.readLine())!=null) {
			json += str;
		}
		
		UserInfoVO user = gson.fromJson(json, UserInfoVO.class);
		System.out.println("2. 나는 controller의 user 값"+ user);
		String cmd = request.getRequestURI().substring(6);
		System.out.println("3. 나는 controller의 cmd 값 URL을 확인해서 알맞은 곳으로 보내주지"+ cmd);
		if("insert".equals(cmd)) {
			Map<String, String> dd = uis.insertUser(user);
			json = gson.toJson(dd);
		}else if("update".equals(cmd)) {
			
			json = gson.toJson(uis.updateUser(user));
		}else if("delete".equals(cmd)) {
			
			json = gson.toJson(uis.deleteUser(user));
		}
		response.getWriter().print(json);
	}

}
