package com.bootdo.test1.service;

import com.bootdo.test1.domain.Test1DO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-16 10:15:51
 */
public interface Test1Service {
	
	Test1DO get(Integer id);
	
	List<Test1DO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Test1DO test1);
	
	int update(Test1DO test1);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
