package com.mvn.test.dao.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;



import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {
	
	@Override
	public  List<UserInfoVO> selectUserList(Map<String,String> pUser){
	    //InitServlet hs = new InitServlet();
		//hs.init();
		SqlSession ss =InitServlet.getSqlSession();
		try {
		return ss.selectList("UserInfo.selectUserList",pUser);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("와따 에러");
		}finally {
			ss.close();
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		UserInfoDAO udao = new UserInfoDAOImpl();
		Map<String,String> pUser = new HashMap<>();
		System.out.println(udao.selectUserList(pUser));
	}

}
