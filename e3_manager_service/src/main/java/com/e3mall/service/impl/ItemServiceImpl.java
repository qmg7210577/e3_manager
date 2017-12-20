package com.e3mall.service.impl;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.EasyUIDataGridResult;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qimenggao on 2017/12/19.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    TbItemMapper tbItemMapper;

    @Override
    public TbItem selectByPrimaryKey(Long id) {
        System.out.println("123");
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {

//        设置分页信息
        PageHelper.startPage(page, rows);
//        执行查询
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);
//      获得查询结果
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);
        EasyUIDataGridResult result = new EasyUIDataGridResult(info.getTotal(), tbItems);

        return result;
    }
}
