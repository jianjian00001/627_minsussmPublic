package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChatEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChatVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChatView;


/**
 * 在线咨询
 *
 * @author 
 * @email 
 * @date 2022-03-24 10:20:21
 */
public interface ChatService extends IService<ChatEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChatVO> selectListVO(Wrapper<ChatEntity> wrapper);
   	
   	ChatVO selectVO(@Param("ew") Wrapper<ChatEntity> wrapper);
   	
   	List<ChatView> selectListView(Wrapper<ChatEntity> wrapper);
   	
   	ChatView selectView(@Param("ew") Wrapper<ChatEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChatEntity> wrapper);
   	

}

