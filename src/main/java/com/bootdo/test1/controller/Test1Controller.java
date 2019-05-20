package com.bootdo.test1.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.test1.domain.Test1DO;
import com.bootdo.test1.service.Test1Service;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-16 10:15:51
 */
 
@Controller
@RequestMapping("/test1/test1")
public class Test1Controller {
	@Autowired
	private Test1Service test1Service;
	
	@GetMapping()
	@RequiresPermissions("test1:test1:test1")
	String Test1(){
	    return "test1/test1/test1";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("test1:test1:test1")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<Test1DO> test1List = test1Service.list(query);
		int total = test1Service.count(query);
		PageUtils pageUtils = new PageUtils(test1List, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("test1:test1:add")
	String add(){
	    return "test1/test1/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("test1:test1:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		Test1DO test1 = test1Service.get(id);
		model.addAttribute("test1", test1);
	    return "test1/test1/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("test1:test1:add")
	public R save( Test1DO test1){
		if(test1Service.save(test1)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("test1:test1:edit")
	public R update( Test1DO test1){
		test1Service.update(test1);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("test1:test1:remove")
	public R remove( Integer id){
		if(test1Service.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("test1:test1:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		test1Service.batchRemove(ids);
		return R.ok();
	}
	
}
