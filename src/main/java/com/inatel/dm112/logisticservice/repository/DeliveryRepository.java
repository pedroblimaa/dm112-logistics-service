package com.inatel.dm112.logisticservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.dm112.logisticservice.model.Delivery;


public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}