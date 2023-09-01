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


import com.dao.DiscusstongzhigonggaoDao;
import com.entity.DiscusstongzhigonggaoEntity;
import com.service.DiscusstongzhigonggaoService;
import com.entity.vo.DiscusstongzhigonggaoVO;
import com.entity.view.DiscusstongzhigonggaoView;

@Service("discusstongzhigonggaoService")
public class DiscusstongzhigonggaoServiceImpl extends ServiceImpl<DiscusstongzhigonggaoDao, DiscusstongzhigonggaoEntity> implements DiscusstongzhigonggaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstongzhigonggaoEntity> page = this.selectPage(
                new Query<DiscusstongzhigonggaoEntity>(params).getPage(),
                new EntityWrapper<DiscusstongzhigonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstongzhigonggaoEntity> wrapper) {
		  Page<DiscusstongzhigonggaoView> page =new Query<DiscusstongzhigonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusstongzhigonggaoVO> selectListVO(Wrapper<DiscusstongzhigonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstongzhigonggaoVO selectVO(Wrapper<DiscusstongzhigonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstongzhigonggaoView> selectListView(Wrapper<DiscusstongzhigonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstongzhigonggaoView selectView(Wrapper<DiscusstongzhigonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
