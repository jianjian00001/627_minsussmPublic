package com.dao;

import com.entity.DiscusstongzhigonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusstongzhigonggaoVO;
import com.entity.view.DiscusstongzhigonggaoView;


/**
 * 通知公告评论表
 * 
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
public interface DiscusstongzhigonggaoDao extends BaseMapper<DiscusstongzhigonggaoEntity> {
	
	List<DiscusstongzhigonggaoVO> selectListVO(@Param("ew") Wrapper<DiscusstongzhigonggaoEntity> wrapper);
	
	DiscusstongzhigonggaoVO selectVO(@Param("ew") Wrapper<DiscusstongzhigonggaoEntity> wrapper);
	
	List<DiscusstongzhigonggaoView> selectListView(@Param("ew") Wrapper<DiscusstongzhigonggaoEntity> wrapper);

	List<DiscusstongzhigonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstongzhigonggaoEntity> wrapper);
	
	DiscusstongzhigonggaoView selectView(@Param("ew") Wrapper<DiscusstongzhigonggaoEntity> wrapper);
	

}
