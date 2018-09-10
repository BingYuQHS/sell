package com.flamingo.sell.service;

import com.flamingo.sell.model.entity.ProductCategory;

import java.util.List;

/***
 * 类目
 * service层
 */
public interface ProductCategoryService {

    /** 管理端. */
    ProductCategory findOne(Integer categoryId);

    /** 管理端.查询所有 */
    List<ProductCategory> findAll();

    /** 买家端. */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /** 买家端. 新增/更新 */
    ProductCategory save(ProductCategory productCategory);


}
