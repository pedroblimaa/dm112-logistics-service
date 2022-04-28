package com.inatel.dm112.logisticservice.dto;

import com.inatel.dm112.logisticservice.model.DeliveryOrder;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDto {

  private Long id;
  private String name;
  private Boolean delivered = false;
  private Long deliverymanId;

  public OrderDto(DeliveryOrder order) {
    this.id = order.getId();
    this.name = order.getName();
    this.delivered = order.getDelivered();
    this.deliverymanId = order.getDeliveryman().getId();
  }

  public static List<OrderDto> convertList(List<DeliveryOrder> order) {
    return order.stream().map(OrderDto::new).collect(Collectors.toList());
  }
}
