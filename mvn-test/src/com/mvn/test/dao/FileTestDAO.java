package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.UserInfoVO;

public interface FileTestDAO {

	public int insertFileTest(SqlSession ss,Map<String,String> fileTest);
	public List<Map<String, String>> selectUserList(Map<String, String> fileTest);
}
