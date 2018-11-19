package com.flamingo.sell.dao;

import com.flamingo.sell.model.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

    /**
     * 根据买家OpenId查询，且含有分页
     * @param buyerId
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerId, Pageable pageable);



}
