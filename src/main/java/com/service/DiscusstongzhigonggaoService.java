package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusstongzhigonggaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusstongzhigonggaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusstongzhigonggaoView;


/**
 * 通知公告评论表
 *
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
public interface DiscusstongzhigonggaoService extends IService<DiscusstongzhigonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstongzhigonggaoVO> selectListVO(Wrapper<DiscusstongzhigonggaoEntity> wrapper);
   	
   	DiscusstongzhigonggaoVO selectVO(@Param("ew") Wrapper<DiscusstongzhigonggaoEntity> wrapper);
   	
   	List<DiscusstongzhigonggaoView> selectListView(Wrapper<DiscusstongzhigonggaoEntity> wrapper);
   	
   	DiscusstongzhigonggaoView selectView(@Param("ew") Wrapper<DiscusstongzhigonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstongzhigonggaoEntity> wrapper);
   	

}

