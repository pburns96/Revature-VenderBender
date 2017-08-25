package com.revature.beans;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TABLE")
public class Order {
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderId")
	@SequenceGenerator(name = "OrderId", sequenceName = "ORDER_ID_SEQ")
	int id;

	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItems;

	@ManyToOne
	@JoinColumn(nullable = true, name = "CUSTOMER_ID")
	Customer owner;

	@Column(name = "ORDER_TIMEORDERED")
	Timestamp timeOrdered;

	public Order() {
	}

	public Order(Customer owner, Timestamp timeOrdered) {
		super();
		this.owner = owner;
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
		return "Order [id=" + id + ", orderItems=" + orderItems + ", owner=" + owner + ", timeOrdered=" + timeOrdered
				+ "]";
	}

}
