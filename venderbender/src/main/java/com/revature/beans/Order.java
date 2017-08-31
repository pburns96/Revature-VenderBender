package com.revature.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "ORDER_TABLE")
public class Order {
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderId")
	@SequenceGenerator(name = "OrderId", sequenceName = "ORDER_ID_SEQ")
	int id;

	@OneToMany(mappedBy = "order", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<OrderItem> orderItems;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(nullable = true, name = "CUSTOMER_ID")
	@NotNull
	Customer owner;

	@NotNull
	@Column(name = "ORDER_TIMEORDERED")
	Date timeOrdered;

	public Order()
	{
		super();
	}
	public Order(Customer owner, Date timeOrdered) {
		super();
		this.owner = owner;
		this.timeOrdered = timeOrdered;
	}
	

	public int getId() {
		return id;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addOrderItem(OrderItem item)
	{
		this.orderItems.add(item);
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Date getTimeOrdered() {
		return timeOrdered;
	}

	public void setTimeOrdered(Date timeOrdered) {
		this.timeOrdered = timeOrdered;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((timeOrdered == null) ? 0 : timeOrdered.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (timeOrdered == null) {
			if (other.timeOrdered != null)
				return false;
		} else if (!timeOrdered.equals(other.timeOrdered))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", owner=" + owner + ", timeOrdered=" + timeOrdered
				+ "]";
	}

}
