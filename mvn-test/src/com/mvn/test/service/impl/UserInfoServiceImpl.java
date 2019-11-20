package com.mvn.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.dao.impl.UserInfoDAOImpl;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	
	private UserInfoDAO uidao = new UserInfoDAOImpl();
	@Override
	public List<UserInfoVO> getUserList(Map<String, String> pUser) {
		return uidao.selectUserList(pUser);
	}
	@Override
	public UserInfoVO getUser(UserInfoVO user) {
		return uidao.selectUser(user);
	}
	@Override
	public Map<String, String> insertUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<String,String>();
		rMap.put("msg","회원추가가 실패하였습니다.");
		rMap.put("result","false");
		if(uidao.insertUser(user)==1) {
			rMap.put("msg","회원추가가 성공하였습니다.");
			rMap.put("result","true");
		}
		System.out.println("나는 insert 서비스가 잘 작동 되었는지 여부를 확인하지");
		return rMap;
	}
	@Override
	public Map<String, String> updateUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<String,String>();
		rMap.put("msg","회원 수정이 실패하였습니다.");
		rMap.put("result","false");
		if(uidao.updateUser(user)==1) {
			rMap.put("msg","회원 수정이 성공하였습니다.");
			rMap.put("result","true");
		}
		return rMap;
	}
	@Override
	public Map<String, String> deleteUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<String,String>();
		if(uidao.deleteUser(user)==1) {
			rMap.put("msg", "회원 삭제가 성공하였습니다.");
			rMap.put("result","true");
		}else {
			rMap.put("msg", "회원 삭제가 실패하였습니다.");
			rMap.put("result","false");
		}
		System.out.println("나는 deleteUser 서비스가 잘 작동 되었는지 여부를 확인하지");
		return rMap;
	}
	@Override
	public UserInfoVO selectUser(List<UserInfoVO> user) {
		// TODO Auto-generated method stub
		return null;
	}

}

