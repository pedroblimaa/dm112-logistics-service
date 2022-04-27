package com.inatel.dm112.logisticservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DeliveryOrder {

  @Id
  private Long id;
  private String product;
  @ManyToOne
  private Deliveryman deliveryman;

  public DeliveryOrder() {
    super();
  }

  public Long getId() {
    return id;
  }

  public String getProduct() {
    return product;
  }
}
