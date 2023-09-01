package com.dao;

import com.entity.MinsuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MinsuleixingVO;
import com.entity.view.MinsuleixingView;


/**
 * 民宿类型
 * 
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
public interface MinsuleixingDao extends BaseMapper<MinsuleixingEntity> {
	
	List<MinsuleixingVO> selectListVO(@Param("ew") Wrapper<MinsuleixingEntity> wrapper);
	
	MinsuleixingVO selectVO(@Param("ew") Wrapper<MinsuleixingEntity> wrapper);
	
	List<MinsuleixingView> selectListView(@Param("ew") Wrapper<MinsuleixingEntity> wrapper);

	List<MinsuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<MinsuleixingEntity> wrapper);
	
	MinsuleixingView selectView(@Param("ew") Wrapper<MinsuleixingEntity> wrapper);
	

}
