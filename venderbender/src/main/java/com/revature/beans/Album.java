/**
 * 
 */
package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Russ Barnes
 * Album bean. Holds all the standard information needed for an album.
 */
@Entity
@Table
public class Album {
	@Id
	@Column(name="ALBUM_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="album_gen")
	@SequenceGenerator(name="album_gen", sequenceName="ALBUM_SEQ")
	private int id;
	@NotBlank
	@Column(name="ALBUM_TITLE", nullable=false)
	private String title;
	@NotBlank
	@Column(name="ALBUM_ARTIST", nullable=false)
	private String artist;
	@NotNull
	@Column(name="ALBUM_TRACKS")
	private String tracks;
	@Min(value=1900)
	@Column(name="ALBUM_YEAR", nullable=false)
	private short year;
	@DecimalMin(value="0")
	@Column(name="ALBUM_PRICE")
	private double price;
	@Column
	private String imagePath;
	@JsonIgnore
	@OneToMany(mappedBy ="album")
	private Set<OrderItem> orderItems;
	@Column(name="IS_CD_OR_NOT")
	private boolean cd;
	


	public Album() {
		super();
	}


	public Album(String title, String artist, short year, double price, String imagePath,
			Set<OrderItem> orderItems) {
		super();
		this.title = title;
		this.artist = artist;
		//this.tracks = tracks;
		this.year = year;
		this.price = price;
		this.imagePath = imagePath;
		this.orderItems = orderItems;
	}


	public String getTracks() {
		return tracks;
	}
	
	
	public void setTracks(String tracks) {
		this.tracks = tracks;
	}
	
	
	public boolean isCd() {
		return cd;
	}
	
	
	public void setCd(boolean cd) {
		this.cd = cd;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", artist=" + artist + ", year=" + year + ", price=" + price
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
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
		Album other = (Album) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
