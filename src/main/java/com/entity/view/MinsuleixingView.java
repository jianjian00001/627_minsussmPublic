package com.entity.view;

import com.entity.MinsuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 民宿类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
@TableName("minsuleixing")
public class MinsuleixingView  extends MinsuleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MinsuleixingView(){
	}
 
 	public MinsuleixingView(MinsuleixingEntity minsuleixingEntity){
 	try {
			BeanUtils.copyProperties(this, minsuleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
