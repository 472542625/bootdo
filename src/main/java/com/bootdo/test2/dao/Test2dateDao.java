package com.bootdo.test2.dao;

import com.bootdo.test2.domain.Test2dateDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-17 13:41:10
 */
@Mapper
public interface Test2dateDao {

	Test2dateDO get(Integer id);
	
	List<Test2dateDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Test2dateDO test2date);
	
	int update(Test2dateDO test2date);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
