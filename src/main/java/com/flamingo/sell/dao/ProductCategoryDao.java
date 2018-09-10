package com.flamingo.sell.dao;

import com.flamingo.sell.model.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * ProductCategoryDao
 * dao层
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

}
