package com.inatel.dm112.logisticservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Deliveryman {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id()
	private Long id;
	private String name;
	@OneToMany(cascade= { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "deliveryman")
	private List<DeliveryOrder> orders;

	public Deliveryman() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<DeliveryOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<DeliveryOrder> orders) {
		this.orders = orders;
	}
}
