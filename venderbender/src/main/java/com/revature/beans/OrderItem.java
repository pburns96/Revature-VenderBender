package com.revature.beans;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class OrderItem {
	
	@Id
	@Column(name = "ORDER_ITEM_ID")
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "OrderItemId")
	@SequenceGenerator(name="OrderItemId", sequenceName = "ORDER_ITEM_ID_SEQ")
	int id;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	@NotNull
	Order order;
	
	@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
	@JoinColumn(name = "ALBUM_ID", nullable = true)
	Album album;
	@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
	@JoinColumn(name = "CONCERT_ID", nullable = true)
	Concert concertTicket;
	@Min(value =1)
	@Column(name = "ORDER_ITEM_QUANTITY", nullable = false)
	int quantity;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Album album, Concert concertTicket, int quantity) {
		super();
		this.album = album;
		this.concertTicket = concertTicket;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Concert getConcertTicket() {
		return concertTicket;
	}

	public void setConcertTicket(Concert concertTicket) {
		this.concertTicket = concertTicket;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((concertTicket == null) ? 0 : concertTicket.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + quantity;
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
		OrderItem other = (OrderItem) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (concertTicket == null) {
			if (other.concertTicket != null)
				return false;
		} else if (!concertTicket.equals(other.concertTicket))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", album=" + album + ", concertTicket=" + concertTicket
				+ ", quantity=" + quantity + "]";
	}
	
	

	
}
