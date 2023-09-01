package com.dao;

import com.entity.MinsuyudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MinsuyudingVO;
import com.entity.view.MinsuyudingView;


/**
 * 民宿预订
 * 
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
public interface MinsuyudingDao extends BaseMapper<MinsuyudingEntity> {
	
	List<MinsuyudingVO> selectListVO(@Param("ew") Wrapper<MinsuyudingEntity> wrapper);
	
	MinsuyudingVO selectVO(@Param("ew") Wrapper<MinsuyudingEntity> wrapper);
	
	List<MinsuyudingView> selectListView(@Param("ew") Wrapper<MinsuyudingEntity> wrapper);

	List<MinsuyudingView> selectListView(Pagination page,@Param("ew") Wrapper<MinsuyudingEntity> wrapper);
	
	MinsuyudingView selectView(@Param("ew") Wrapper<MinsuyudingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<MinsuyudingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MinsuyudingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MinsuyudingEntity> wrapper);
}
