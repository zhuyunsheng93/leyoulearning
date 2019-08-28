package com.leyou.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.mapper.BrandMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        PageHelper.startPage(page, rows);
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name", "%" + key + "%");

        }
        if (StringUtils.isNotBlank(sortBy)
        ) {
            String orderByClause = sortBy + " "+(desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);

        return new PageResult<>(pageInfo.getTotal(),new Long(pageInfo.getPages()), pageInfo);
    }
}

