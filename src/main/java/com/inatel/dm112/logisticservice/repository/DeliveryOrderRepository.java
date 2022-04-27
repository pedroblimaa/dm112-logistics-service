package com.inatel.dm112.logisticservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.dm112.logisticservice.model.DeliveryOrder;


public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {

}
