package com.bootdo.test1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.test1.dao.Test1Dao;
import com.bootdo.test1.domain.Test1DO;
import com.bootdo.test1.service.Test1Service;



@Service
public class Test1ServiceImpl implements Test1Service {
	@Autowired
	private Test1Dao test1Dao;
	
	@Override
	public Test1DO get(Integer id){
		return test1Dao.get(id);
	}
	
	@Override
	public List<Test1DO> list(Map<String, Object> map){
		return test1Dao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return test1Dao.count(map);
	}
	
	@Override
	public int save(Test1DO test1){
		return test1Dao.save(test1);
	}
	
	@Override
	public int update(Test1DO test1){
		return test1Dao.update(test1);
	}
	
	@Override
	public int remove(Integer id){
		return test1Dao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return test1Dao.batchRemove(ids);
	}
	
}
