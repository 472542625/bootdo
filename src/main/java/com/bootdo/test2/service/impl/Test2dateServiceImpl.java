package com.bootdo.test2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.test2.dao.Test2dateDao;
import com.bootdo.test2.domain.Test2dateDO;
import com.bootdo.test2.service.Test2dateService;



@Service
public class Test2dateServiceImpl implements Test2dateService {
	@Autowired
	private Test2dateDao test2dateDao;
	
	@Override
	public Test2dateDO get(Integer id){
		return test2dateDao.get(id);
	}
	
	@Override
	public List<Test2dateDO> list(Map<String, Object> map){
		return test2dateDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return test2dateDao.count(map);
	}
	
	@Override
	public int save(Test2dateDO test2date){
		return test2dateDao.save(test2date);
	}
	
	@Override
	public int update(Test2dateDO test2date){
		return test2dateDao.update(test2date);
	}
	
	@Override
	public int remove(Integer id){
		return test2dateDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return test2dateDao.batchRemove(ids);
	}
	
}
