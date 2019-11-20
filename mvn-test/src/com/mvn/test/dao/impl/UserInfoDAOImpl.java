package com.mvn.test.dao.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {
	
	private SqlSessionFactory ssf;

	@Override
	public List<UserInfoVO> selectUserList(Map<String, String> pUser) {
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			return ss.selectList("UserInfo.selectUserList",pUser);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			return ss.selectOne("UserInfo.selectUser",user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}
	@Override
	public int insertUser(UserInfoVO user) {
		SqlSession ss =  InitServlet.getSqlSession();
		System.out.println("DAO의 ss 값이 궁금하군"+ss);
		try {
			int cnt = ss.insert("UserInfo.insertUser",user);
			System.out.println("DAO의 cnt 값이 궁금하군"+cnt);
			ss.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}
	
	@Override
	public int updateUser(UserInfoVO user) {
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			int cnt = ss.update("UserInfo.updateUser",user);
			ss.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}

	@Override
	public int deleteUser(UserInfoVO user) {
		System.out.println("user의 값"+user);
		//위의 값을 통해서 uiNum이 잘 넘어 온것을 확인 할 수 있다.
		SqlSession ss =  InitServlet.getSqlSession();
		try {
			int cnt = ss.delete("UserInfo.deleteUser",user);
			System.out.println("DAO의 cnt 값이 궁금하군"+cnt);
			ss.commit();
			return cnt;
			//service deleteUser 로 cnt 값을 보내준다.
			//int 로 값을 받을 수 있는이유는 queryupdate 이기 때문이다.
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserInfoDAO udao = new UserInfoDAOImpl();
		//Map<UserInfoVO> pUser = new hashMap<UserInfoVO>();
		//pUser.put("uiNum", 116);
		//System.out.println("udao.selectUserList(pUser) 값입니다."+udao.selectUserList(pUser));
		//UserInfoVO user = new HashMap<>();
		//System.out.println("udao.insertBoard(user)" + udao.insertUser(user));
		//System.out.println("udao.selectUser(user)" + udao.selectUser(user));
	}


}
