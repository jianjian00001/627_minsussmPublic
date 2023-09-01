package com.entity.vo;

import com.entity.MinsuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 民宿信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
public class MinsuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 民宿类型
	 */
	
	private String minsuleixing;
		
	/**
	 * 民宿户型
	 */
	
	private String minsuhuxing;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 价格
	 */
	
	private Float jiage;
		
	/**
	 * 面积
	 */
	
	private String mianji;
		
	/**
	 * 民宿设施
	 */
	
	private String minsusheshi;
		
	/**
	 * 民宿详情
	 */
	
	private String minsuxiangqing;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：民宿类型
	 */
	 
	public void setMinsuleixing(String minsuleixing) {
		this.minsuleixing = minsuleixing;
	}
	
	/**
	 * 获取：民宿类型
	 */
	public String getMinsuleixing() {
		return minsuleixing;
	}
				
	
	/**
	 * 设置：民宿户型
	 */
	 
	public void setMinsuhuxing(String minsuhuxing) {
		this.minsuhuxing = minsuhuxing;
	}
	
	/**
	 * 获取：民宿户型
	 */
	public String getMinsuhuxing() {
		return minsuhuxing;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(Float jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getJiage() {
		return jiage;
	}
				
	
	/**
	 * 设置：面积
	 */
	 
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	
	/**
	 * 获取：面积
	 */
	public String getMianji() {
		return mianji;
	}
				
	
	/**
	 * 设置：民宿设施
	 */
	 
	public void setMinsusheshi(String minsusheshi) {
		this.minsusheshi = minsusheshi;
	}
	
	/**
	 * 获取：民宿设施
	 */
	public String getMinsusheshi() {
		return minsusheshi;
	}
				
	
	/**
	 * 设置：民宿详情
	 */
	 
	public void setMinsuxiangqing(String minsuxiangqing) {
		this.minsuxiangqing = minsuxiangqing;
	}
	
	/**
	 * 获取：民宿详情
	 */
	public String getMinsuxiangqing() {
		return minsuxiangqing;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
