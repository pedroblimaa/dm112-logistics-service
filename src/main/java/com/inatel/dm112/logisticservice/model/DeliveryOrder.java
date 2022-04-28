package com.inatel.dm112.logisticservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DeliveryOrder {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String name;
  private Boolean delivered = false;

  @ManyToOne
  private Deliveryman deliveryman;

  public DeliveryOrder() {
    super();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Boolean getDelivered() {
    return delivered;
  }

  public Boolean setDelivered() {
    return this.delivered = true;
  }

  public Deliveryman getDeliveryman() {
    return deliveryman;
  }
}
