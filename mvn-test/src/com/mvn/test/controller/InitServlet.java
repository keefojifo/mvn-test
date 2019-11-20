package com.mvn.test.controller;

import java.io.InputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mvn.test.dao.impl.UserInfoDAOImpl;

@WebServlet(name="Init",urlPatterns= {"/init"},loadOnStartup = 1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SqlSessionFactory ssf;
	static {
		String path = "/config/mybatis-config.xml";
		//경로 입력 
		InputStream is = UserInfoDAOImpl.class.getResourceAsStream(path);
		
		
		SqlSessionFactoryBuilder ssfb =new SqlSessionFactoryBuilder();
		ssf = ssfb.build(is);
	}


	public static SqlSession getSqlSession() {
		return ssf.openSession();
		}
}
