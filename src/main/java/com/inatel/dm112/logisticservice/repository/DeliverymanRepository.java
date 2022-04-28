package com.inatel.dm112.logisticservice.repository;

import com.inatel.dm112.logisticservice.model.Deliveryman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverymanRepository
  extends JpaRepository<Deliveryman, Long> {}
