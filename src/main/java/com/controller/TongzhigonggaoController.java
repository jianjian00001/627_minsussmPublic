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

import com.entity.TongzhigonggaoEntity;
import com.entity.view.TongzhigonggaoView;

import com.service.TongzhigonggaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 通知公告
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
@RestController
@RequestMapping("/tongzhigonggao")
public class TongzhigonggaoController {
    @Autowired
    private TongzhigonggaoService tongzhigonggaoService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TongzhigonggaoEntity tongzhigonggao, 
		HttpServletRequest request){

        EntityWrapper<TongzhigonggaoEntity> ew = new EntityWrapper<TongzhigonggaoEntity>();
		PageUtils page = tongzhigonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongzhigonggao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TongzhigonggaoEntity tongzhigonggao, 
		HttpServletRequest request){
        EntityWrapper<TongzhigonggaoEntity> ew = new EntityWrapper<TongzhigonggaoEntity>();
		PageUtils page = tongzhigonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongzhigonggao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TongzhigonggaoEntity tongzhigonggao){
       	EntityWrapper<TongzhigonggaoEntity> ew = new EntityWrapper<TongzhigonggaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tongzhigonggao, "tongzhigonggao")); 
        return R.ok().put("data", tongzhigonggaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TongzhigonggaoEntity tongzhigonggao){
        EntityWrapper< TongzhigonggaoEntity> ew = new EntityWrapper< TongzhigonggaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tongzhigonggao, "tongzhigonggao")); 
		TongzhigonggaoView tongzhigonggaoView =  tongzhigonggaoService.selectView(ew);
		return R.ok("查询通知公告成功").put("data", tongzhigonggaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TongzhigonggaoEntity tongzhigonggao = tongzhigonggaoService.selectById(id);
		tongzhigonggao.setClicknum(tongzhigonggao.getClicknum()+1);
		tongzhigonggao.setClicktime(new Date());
		tongzhigonggaoService.updateById(tongzhigonggao);
        return R.ok().put("data", tongzhigonggao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TongzhigonggaoEntity tongzhigonggao = tongzhigonggaoService.selectById(id);
		tongzhigonggao.setClicknum(tongzhigonggao.getClicknum()+1);
		tongzhigonggao.setClicktime(new Date());
		tongzhigonggaoService.updateById(tongzhigonggao);
        return R.ok().put("data", tongzhigonggao);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        TongzhigonggaoEntity tongzhigonggao = tongzhigonggaoService.selectById(id);
        if(type.equals("1")) {
        	tongzhigonggao.setThumbsupnum(tongzhigonggao.getThumbsupnum()+1);
        } else {
        	tongzhigonggao.setCrazilynum(tongzhigonggao.getCrazilynum()+1);
        }
        tongzhigonggaoService.updateById(tongzhigonggao);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TongzhigonggaoEntity tongzhigonggao, HttpServletRequest request){
    	tongzhigonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tongzhigonggao);

        tongzhigonggaoService.insert(tongzhigonggao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody TongzhigonggaoEntity tongzhigonggao, HttpServletRequest request){
    	tongzhigonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tongzhigonggao);

        tongzhigonggaoService.insert(tongzhigonggao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TongzhigonggaoEntity tongzhigonggao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tongzhigonggao);
        tongzhigonggaoService.updateById(tongzhigonggao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tongzhigonggaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<TongzhigonggaoEntity> wrapper = new EntityWrapper<TongzhigonggaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = tongzhigonggaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,TongzhigonggaoEntity tongzhigonggao, HttpServletRequest request,String pre){
        EntityWrapper<TongzhigonggaoEntity> ew = new EntityWrapper<TongzhigonggaoEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = tongzhigonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongzhigonggao), params), params));
        return R.ok().put("data", page);
    }







}
