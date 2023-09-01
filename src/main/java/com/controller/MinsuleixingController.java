package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MinsuleixingEntity;
import com.entity.view.MinsuleixingView;

import com.service.MinsuleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 民宿类型
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
@RestController
@RequestMapping("/minsuleixing")
public class MinsuleixingController {
    @Autowired
    private MinsuleixingService minsuleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MinsuleixingEntity minsuleixing, 
		HttpServletRequest request){

        EntityWrapper<MinsuleixingEntity> ew = new EntityWrapper<MinsuleixingEntity>();
		PageUtils page = minsuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, minsuleixing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MinsuleixingEntity minsuleixing, 
		HttpServletRequest request){
        EntityWrapper<MinsuleixingEntity> ew = new EntityWrapper<MinsuleixingEntity>();
		PageUtils page = minsuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, minsuleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MinsuleixingEntity minsuleixing){
       	EntityWrapper<MinsuleixingEntity> ew = new EntityWrapper<MinsuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( minsuleixing, "minsuleixing")); 
        return R.ok().put("data", minsuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MinsuleixingEntity minsuleixing){
        EntityWrapper< MinsuleixingEntity> ew = new EntityWrapper< MinsuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( minsuleixing, "minsuleixing")); 
		MinsuleixingView minsuleixingView =  minsuleixingService.selectView(ew);
		return R.ok("查询民宿类型成功").put("data", minsuleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MinsuleixingEntity minsuleixing = minsuleixingService.selectById(id);
        return R.ok().put("data", minsuleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MinsuleixingEntity minsuleixing = minsuleixingService.selectById(id);
        return R.ok().put("data", minsuleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MinsuleixingEntity minsuleixing, HttpServletRequest request){
    	minsuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(minsuleixing);

        minsuleixingService.insert(minsuleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MinsuleixingEntity minsuleixing, HttpServletRequest request){
    	minsuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(minsuleixing);

        minsuleixingService.insert(minsuleixing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MinsuleixingEntity minsuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(minsuleixing);
        minsuleixingService.updateById(minsuleixing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        minsuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MinsuleixingEntity> wrapper = new EntityWrapper<MinsuleixingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = minsuleixingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
