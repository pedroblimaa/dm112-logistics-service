package com.inatel.dm112.logisticservice.service;

import com.inatel.dm112.logisticservice.dto.DeliveryRegisterDto;
import com.inatel.dm112.logisticservice.dto.OrderDto;
import com.inatel.dm112.logisticservice.model.DeliveryOrder;
import com.inatel.dm112.logisticservice.repository.DeliveryOrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private DeliveryOrderRepository orderRepo;

  public List<OrderDto> getDeliverymanOpenOrders(Long deliverymanId) {
    deliverymanVerification(deliverymanId);

    List<DeliveryOrder> orders = orderRepo.findByDeliverymanIdAndDelivered(deliverymanId, false);

    return OrderDto.convertList(orders);
  }

  public List<OrderDto> getDeliverymanOrders(Long deliverymanId) {
    deliverymanVerification(deliverymanId);

    List<DeliveryOrder> orders = orderRepo.findByDeliverymanId(deliverymanId);

    return OrderDto.convertList(orders);
  }

  public void deliverymanVerification(Long deliverymanId) {
    if (deliverymanId == null) {
      throw new IllegalArgumentException("Deliveryman id cannot be null");
    }
  }

  public void verifyOrderRegistration(Optional<DeliveryOrder> order, Long deliverymanId) {
    if (order.isEmpty()) {
      throw new IllegalArgumentException("Invalid order id");
    }

    if (order.get().getDelivered() == true) {
      throw new IllegalArgumentException("Order already registered");
    }

    if (order.get().getDeliveryman().getId() != deliverymanId) {
      throw new IllegalArgumentException("The order is not assigned to this deliveryman");
    }
  }
}
