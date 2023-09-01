package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MinsuleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MinsuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MinsuleixingView;


/**
 * 民宿类型
 *
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
public interface MinsuleixingService extends IService<MinsuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MinsuleixingVO> selectListVO(Wrapper<MinsuleixingEntity> wrapper);
   	
   	MinsuleixingVO selectVO(@Param("ew") Wrapper<MinsuleixingEntity> wrapper);
   	
   	List<MinsuleixingView> selectListView(Wrapper<MinsuleixingEntity> wrapper);
   	
   	MinsuleixingView selectView(@Param("ew") Wrapper<MinsuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MinsuleixingEntity> wrapper);
   	

}

