package com.test;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by qimenggao on 2017/12/20.
 */
public class PageHelperTest {
    @Test
    public void testPageHelper() {
//    加载配置文件，初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

//        获得mapper的代理对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
//        设置PageHelper
        PageHelper.startPage(1,5);
//        获得查询列表
        TbItemExample itemExample = new TbItemExample();
        List<TbItem> tbItems = itemMapper.selectByExample(itemExample);
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);

        System.out.println(info);
        System.out.println(info.getList());
        System.out.println(info.getFirstPage());
        System.out.println(info.getLastPage());
        System.out.println(info.getNextPage());
        System.out.println(info.getPageNum());
        System.out.println(info.getSize());
        System.out.println(info.getTotal());

//        格式化
    }
}
