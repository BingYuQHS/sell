package com.flamingo.sell.service;

import com.flamingo.sell.model.dto.CartDTO;
import com.flamingo.sell.model.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/***
 * 商品service
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /***
     * C端：查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /***
     * 管理端：分页查询
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /***
     * 更新/保存
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 取消订单时减加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 下订单减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
