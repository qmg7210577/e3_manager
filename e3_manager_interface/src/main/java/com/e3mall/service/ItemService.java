package com.e3mall.service;

import com.e3mall.pojo.EasyUIDataGridResult;
import com.e3mall.pojo.TbItem;

/**
 * Created by qimenggao on 2017/12/19.
 */
public interface ItemService {
    TbItem selectByPrimaryKey(Long id);
    EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
