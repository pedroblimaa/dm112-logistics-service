package com.inatel.dm112.logisticservice.controller;

import com.inatel.dm112.logisticservice.dto.DeliveryRegisterDto;
import com.inatel.dm112.logisticservice.dto.OrderDto;
import com.inatel.dm112.logisticservice.model.DeliveryOrder;
import com.inatel.dm112.logisticservice.repository.DeliveryOrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private DeliveryOrderRepository orderRepo;

  //CREATE A SERVICE AND ORGANIZE THE CODE TO USE IT

  @GetMapping
  public ResponseEntity<List<OrderDto>> getList(
    @RequestParam(required = false) Long deliverymanId
  ) {
    // FIX THIS DELIVERYMAN == NULL
    if (deliverymanId == null) {
      return ResponseEntity.ok(new ArrayList<>());
    }

    List<DeliveryOrder> orders = orderRepo.findOrdersByDeliverymanId(
      deliverymanId
    );
    List<OrderDto> ordersDto = OrderDto.convertList(orders);

    return ResponseEntity.ok(ordersDto);
  }

  @GetMapping("/open")
  public ResponseEntity<List<OrderDto>> getOpenList(
    @RequestParam(required = false) Long deliverymanId
  ) {
    // FIX THIS DELIVERYMAN == NULL
    if (deliverymanId == null) {
      return ResponseEntity.ok(new ArrayList<>());
    }

    List<DeliveryOrder> orders = orderRepo.findOpenOrdersByDeliverymanId(
      deliverymanId
    );
    List<OrderDto> ordersDto = OrderDto.convertList(orders);

    return ResponseEntity.ok(ordersDto);
  }

  @Transactional
  @PostMapping("/register")
  public ResponseEntity<OrderDto> registerDelivery(
    @RequestBody DeliveryRegisterDto registerDelivery
  ) {
    Optional<DeliveryOrder> order = orderRepo.findDeliveryOrderById(
      registerDelivery.getOrderId()
    );

    if (
      order.isPresent() &&
      order.get().getDeliveryman().getId() ==
      registerDelivery.getDeliverymanId() &&
      order.get().getDelivered() == false
    ) {
      order.get().setDelivered();
      return ResponseEntity.ok(new OrderDto(order.get()));
    }

    return ResponseEntity.badRequest().build();
  }
}
