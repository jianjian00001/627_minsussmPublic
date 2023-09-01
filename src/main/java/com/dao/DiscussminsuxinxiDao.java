package com.dao;

import com.entity.DiscussminsuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussminsuxinxiVO;
import com.entity.view.DiscussminsuxinxiView;


/**
 * 民宿信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
public interface DiscussminsuxinxiDao extends BaseMapper<DiscussminsuxinxiEntity> {
	
	List<DiscussminsuxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussminsuxinxiEntity> wrapper);
	
	DiscussminsuxinxiVO selectVO(@Param("ew") Wrapper<DiscussminsuxinxiEntity> wrapper);
	
	List<DiscussminsuxinxiView> selectListView(@Param("ew") Wrapper<DiscussminsuxinxiEntity> wrapper);

	List<DiscussminsuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussminsuxinxiEntity> wrapper);
	
	DiscussminsuxinxiView selectView(@Param("ew") Wrapper<DiscussminsuxinxiEntity> wrapper);
	

}
