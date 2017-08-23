/**
 * 
 */
package com.revature.beans;

import java.util.List;

/**
 * @author Russ Barnes
 * Album bean. Holds all the standard information needed for an album.
 */
public class Album {
	private int id;
	private String title;
	private String artist;
	private List<String> tracks;
	private short year;
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
