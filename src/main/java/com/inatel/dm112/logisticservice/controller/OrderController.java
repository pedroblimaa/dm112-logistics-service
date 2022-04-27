package com.inatel.dm112.logisticservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inatel.dm112.logisticservice.model.DeliveryOrder;
import com.inatel.dm112.logisticservice.model.Deliveryman;
import com.inatel.dm112.logisticservice.repository.DeliveryOrderRepository;
import com.inatel.dm112.logisticservice.repository.DeliverymanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private DeliveryOrderRepository orderRepo;

  @Autowired
  private DeliverymanRepository deliverymanRepo;

  @GetMapping
  public ResponseEntity<List<DeliveryOrder>> getList(@RequestParam Long deliverymanId) {

    Optional<Deliveryman> deliveryman = deliverymanRepo.findById(deliverymanId);
		List<DeliveryOrder> orders = new ArrayList<>();

		if(deliveryman.isPresent()) {
			orders = deliveryman.get().getOrders();
		}

    return ResponseEntity.ok(orders);
  }
}
