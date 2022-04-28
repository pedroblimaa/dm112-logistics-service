package com.inatel.dm112.logisticservice.repository;

import com.inatel.dm112.logisticservice.model.DeliveryOrder;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {
  List<DeliveryOrder> findByDeliverymanId(Long deliverymanId);

  List<DeliveryOrder> findByDeliverymanIdAndDelivered(Long deliverymanId, Boolean delivered);

  Optional<DeliveryOrder> findDeliveryOrderById(Long orderId);

  Optional<DeliveryOrder> findDeliveryOrderByIdAndDeliverymanId(Long orderId, Long deliverymanId);
}
