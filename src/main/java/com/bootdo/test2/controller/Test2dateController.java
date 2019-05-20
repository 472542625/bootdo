package com.bootdo.test2.controller;

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

import com.bootdo.test2.domain.Test2dateDO;
import com.bootdo.test2.service.Test2dateService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-17 13:41:10
 */
 
@Controller
@RequestMapping("/test2/test2date")
public class Test2dateController {
	@Autowired
	private Test2dateService test2dateService;
	
	@GetMapping()
	@RequiresPermissions("test2:test2date:test2date")
	String Test2date(){
	    return "test2/test2date/test2date";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("test2:test2date:test2date")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<Test2dateDO> test2dateList = test2dateService.list(query);
		int total = test2dateService.count(query);
		PageUtils pageUtils = new PageUtils(test2dateList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("`")
	String add(){
	    return "test2/test2date/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("test2:test2date:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		Test2dateDO test2date = test2dateService.get(id);
		model.addAttribute("test2date", test2date);
	    return "test2/test2date/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("test2:test2date:add")
	public R save( Test2dateDO test2date){
		if(test2dateService.save(test2date)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("test2:test2date:edit")
	public R update( Test2dateDO test2date){
		test2dateService.update(test2date);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("test2:test2date:remove")
	public R remove( Integer id){
		if(test2dateService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("test2:test2date:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		test2dateService.batchRemove(ids);
		return R.ok();
	}
	
}
