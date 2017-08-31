package com.revature.services;

import java.util.Date;
import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.revature.beans.Album;
import com.revature.beans.Concert;
import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;
import com.revature.data.AlbumDAO;
import com.revature.data.ConcertDAO;
import com.revature.data.CustomerDAO;
import com.revature.data.OrderDAO;

@Service
public class DataService {

	@Autowired
	ConcertDAO concertDao;
	@Autowired
	AlbumDAO albumDao;
	@Autowired
	CustomerDAO customerDao;
	@Autowired
	OrderDAO orderDao;
	
	/**
	 * AlbumDAO
	 */
	
	public Album getAlbumById(int idNumber){
		return albumDao.getAlbumById(idNumber);
	}
	
	public List<Album> getAlbumsByArtist(String artist){
		return albumDao.getAlbumsByArtist(artist);
	}
	
	public List<Album> getAlbumsByType(byte cd){
		return albumDao.getAlbumsByType(cd);
	}
	
	public List<Album> getAllAlbums(){
		return albumDao.getAllAlbums();
	}
	
	public List<Album> getAlbumsByGenre(String genre){
		return albumDao.getAlbumsByGenre(genre);
	}
	
	public void createAlbum(Album album){
		albumDao.createAlbum(album);
	}

	public void updateAlbum(Album album){
		albumDao.updateAlbum(album);
	}
	
	public void deleteAlbum(Album album){
		albumDao.updateAlbum(album);
	}
	
	/**
	 * ConcertDAO
	 */
	
	public Concert getConcert(int id){
		return concertDao.getConcert(id);
	}
	
	public List<Concert> getConcertsStarting(Date date){
		return concertDao.getConcertsStarting(date);
	}
	
	public List<Concert> getConcertsByDates(Date start, Date end){
		return concertDao.getConcertsByDates(start, end);
	}
	
	public List<Concert> getConcertsByBand(String band){
		return concertDao.getConcertsByBand(band);
	}
	
	public List<Concert> getConcertsByLocation(String location){
		return concertDao.getConcertsByLocation(location);
	}
	
	public List<Concert> getAllConcerts(){
		return concertDao.getAllConcerts();
	}
	
	public void createConcert(Concert concert){
		concertDao.createConcert(concert);
	}
	
	public void deleteConcert(Concert concert){
		concertDao.deleteConcert(concert);
	}
	
	/**
	 * CustomerDAO
	 */
	
	public Customer getCustomer(int id){
		return customerDao.getCustomer(id);
	}
	
	public Customer getCustomer(String username){
		return customerDao.getCustomer(username);
	}
	
	public void createCustomer(Customer customer){
		customerDao.createCustomer(customer);
	}

	public void deleteCustomer(Customer customer){
		customerDao.deleteCustomer(customer);
	}
	
	/**
	 *OrderDAO 
	 */
	
	public void createOrder(Order order) throws InvalidDataAccessApiUsageException, UnexpectedTypeException{
		orderDao.createOrder(order);
	}
	
	public void createOrderItem(OrderItem orderItem){
		orderDao.createOrderItem(orderItem);
	}
	
	public List<OrderItem> getOrderItems(Order order){
		return orderDao.getOrderItems(order);
	}
	
	public List<Order>getOrders(){
		return orderDao.getOrders();
	}
	
	//Return all customer orders if they are a manager
	public List<Order>getOrders(Customer customer){
		if(customer.isManager())
		{
		 return orderDao.getOrders();
		}
		return orderDao.getOrders(customer);
	}
	public Order getOrder(int id)
	{
		return orderDao.getOrder(id);
	}
	public OrderItem getOrderItem(int id)
	{
		return orderDao.getOrderItem(id);
	}
	
	public void updateOrderItem(OrderItem item){
		orderDao.updateOrderItem(item);
	}
	
	public void deleteOrder(Order order){
		orderDao.deleteOrder(order);
	}
	
	public void deleteOrderItem(OrderItem item){
		orderDao.deleteOrderItem(item);
	}
	
	
	public void setConcertDao(ConcertDAO concertDao) {
		this.concertDao = concertDao;
	}
	public void setAlbumDao(AlbumDAO albumDao) {
		this.albumDao = albumDao;
	}
	public void setCustomerDao(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}
	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}
}
