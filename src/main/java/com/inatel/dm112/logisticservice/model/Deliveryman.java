package com.inatel.dm112.logisticservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Deliveryman {

	@Id
	private Long id;
	@OneToMany(cascade= { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "deliveryman")
	private List<DeliveryOrder> orders;

	public Deliveryman() {
		super();
	}

	public Long getId() {
		return id;
	}

	public List<DeliveryOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<DeliveryOrder> orders) {
		this.orders = orders;
	}
}
