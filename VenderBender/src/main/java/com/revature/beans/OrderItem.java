package com.revature.beans;

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
@Table
public class OrderItem {
	
	@Id
	@Column(name = "ORDER_ITEM_ID")
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "OrderItemId")
	@SequenceGenerator(name="OrderItemId", sequenceName = "ORDER_ITEM_ID_SEQ")
	int id;
	@ManyToOne
	@JoinColumn(name = "ORDER_ID", nullable = false)
	Order order;
	@ManyToOne
	@JoinColumn(name = "TODO PAT", nullable = true)
	Album album;
	@ManyToOne
	@JoinColumn(name = "CONCERT_ID", nullable = true)
	Concert concertTicket;
	@Column(name = "ORDER_ITEM_QUANTITY")
	int quantity;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
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

	public void setId(int id) {
		this.id = id;
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
	
	

	//TODO PAT: add generated methhods once class fully implemented
}
