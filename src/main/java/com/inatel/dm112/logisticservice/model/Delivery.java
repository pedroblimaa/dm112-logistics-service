package com.inatel.dm112.logisticservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Deliveryman deliveryman;
  @OneToOne
  private DeliveryOrder order;

  public Delivery() {
    super();
  }

  public Long getId() {
    return id;
  }

  public Deliveryman getDeliveryman() {
    return deliveryman;
  }

  public void setDeliveryman(Deliveryman deliveryman) {
    this.deliveryman = deliveryman;
  }

  public DeliveryOrder getOrder() {
    return order;
  }

  public void setOrder(DeliveryOrder order) {
    this.order = order;
  }
}
