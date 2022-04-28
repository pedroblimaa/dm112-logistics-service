package com.inatel.dm112.logisticservice.controller;

import com.inatel.dm112.logisticservice.dto.DeliveryRegisterDto;
import com.inatel.dm112.logisticservice.dto.ErrorHandleDto;
import com.inatel.dm112.logisticservice.dto.OrderDto;
import com.inatel.dm112.logisticservice.model.DeliveryOrder;
import com.inatel.dm112.logisticservice.repository.DeliveryOrderRepository;
import com.inatel.dm112.logisticservice.service.OrderService;
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

  @Autowired
  private OrderService orderService;

  @GetMapping
  public ResponseEntity<List<OrderDto>> getList(@RequestParam(required = false) Long deliverymanId) {
    List<OrderDto> orders = orderService.getDeliverymanOrders(deliverymanId);

    return ResponseEntity.ok(orders);
  }

  @GetMapping("/open")
  public ResponseEntity<List<OrderDto>> getOpenList(@RequestParam(required = false) Long deliverymanId) {
    List<OrderDto> orders = orderService.getDeliverymanOpenOrders(deliverymanId);

    return ResponseEntity.ok(orders);
  }

  @Transactional
  @PostMapping("/register")
  public ResponseEntity<OrderDto> registerDelivery(@RequestBody DeliveryRegisterDto registerDelivery) {
    Optional<DeliveryOrder> order = orderRepo.findDeliveryOrderById(registerDelivery.getOrderId());

    orderService.verifyOrderRegistration(order, registerDelivery.getDeliverymanId());

    order.get().setDelivered();
    return ResponseEntity.ok(new OrderDto(order.get()));
  }
}
