package com.flamingo.sell.dao;

import com.flamingo.sell.model.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * ProductCategoryDao
 * dao层
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    /***
     * 根据类目编号List
     * 查询类目信息List
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
