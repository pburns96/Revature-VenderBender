/**
 * 
 */
package com.revature.data;

import java.util.List;

import com.revature.beans.Album;

/**
 * @author Russ Barnes
 * Simple data access object for the artist bean.
 */
public interface AlbumDAO {
	/**
	 * Returns a single album from a known identification number.
	 * @param idNumber the id number in the database.
	 * @return the found album object.
	 */
	public Album getAlbumById(int idNumber);
	/**
	 * Finds all the albums with a matching string in the artist field.
	 * @param artist, the string version of the artist.
	 * @return a set of all the albums found.
	 */
	public List<Album> getAlbumsByArtist(String artist);
	/**
	 * Mainly to find all albums of type CD or LP—most fanatics want one but not the other.
	 * @param cd true for CD false for Vinyl  
	 * @return a set of all the albums found.
	 */
	public List<Album> getAlbumsByType(byte cd);
	/**
	 * gets every album in the database. We try to split this up once we learn how.
	 * @return a set of all albums.
	 */
	public List<Album> getAllAlbums();
	/**
	 * Who wants to even bother looking at jazz or country albums. Forget that and use this.
	 * @param genre, the string version of the genre.
	 * @return a set of all the albums found.
	 */
	public List<Album> getAlbumsByGenre(String genre);
	/**
	 * Adds a single album to the database.
	 * @param album the album to be added.
	 */
	public void createAlbum(Album album);
	/**
	 * Updates the input album.
	 * @param album the album that needs updating.
	 */
	public void updateAlbum(Album album);
	/**
	 * Completely removes the album from the database.
	 * @param album the album to be deleted.
	 */
	public void deleteAlbum(Album album);

}
