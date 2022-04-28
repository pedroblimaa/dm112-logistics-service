package com.inatel.dm112.logisticservice.repository;

import java.util.List;
import java.util.Optional;

import com.inatel.dm112.logisticservice.model.DeliveryOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {

  @Query(value = "SELECT * FROM delivery_order o WHERE o.delivered = false AND o.deliveryman_id = ?1", nativeQuery = true)
  List<DeliveryOrder> findOpenOrdersByDeliverymanId(Long deliverymanId);

  @Query(value = "SELECT * FROM delivery_order o WHERE o.deliveryman_id = ?1", nativeQuery = true)
  List<DeliveryOrder> findOrdersByDeliverymanId(Long deliverymanId);

  Optional<DeliveryOrder> findDeliveryOrderById(Long orderId);

  Optional<DeliveryOrder> findDeliveryOrderByIdAndDeliverymanId(Long orderId, Long deliverymanId);
}
