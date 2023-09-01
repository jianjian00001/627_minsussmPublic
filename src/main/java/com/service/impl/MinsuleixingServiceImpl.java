package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.MinsuleixingDao;
import com.entity.MinsuleixingEntity;
import com.service.MinsuleixingService;
import com.entity.vo.MinsuleixingVO;
import com.entity.view.MinsuleixingView;

@Service("minsuleixingService")
public class MinsuleixingServiceImpl extends ServiceImpl<MinsuleixingDao, MinsuleixingEntity> implements MinsuleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MinsuleixingEntity> page = this.selectPage(
                new Query<MinsuleixingEntity>(params).getPage(),
                new EntityWrapper<MinsuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MinsuleixingEntity> wrapper) {
		  Page<MinsuleixingView> page =new Query<MinsuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MinsuleixingVO> selectListVO(Wrapper<MinsuleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MinsuleixingVO selectVO(Wrapper<MinsuleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MinsuleixingView> selectListView(Wrapper<MinsuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MinsuleixingView selectView(Wrapper<MinsuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
