/**
 * 
 */
package com.revature.beans;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Russ Barnes
 * Album bean. Holds all the standard information needed for an album.
 */
public class Album {
	@Id
	@Column(name="ALBUM_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="album_gen")
	@SequenceGenerator(name="album_gen", sequenceName="ALBUM_SEQ")
	private int id;
	@Column
	private String title;
	@Column
	private String artist;
	@Column
	private List<String> tracks;
	@Column
	private short year;
	@Column
	private double price;
	
	public Album() {
		super();
	}

	public Album(String title, String artist, List<String> tracks, short year, double price) {
		super();
		this.setTitle(title);
		this.setArtist(artist);
		this.setTracks(tracks);
		this.setYear(year);
		this.setPrice(price);
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

	public List<String> getTracks() {
		return tracks;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
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

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", artist=" + artist + ", year=" + year + ", price=" + price
				+ "]";
	}

}
