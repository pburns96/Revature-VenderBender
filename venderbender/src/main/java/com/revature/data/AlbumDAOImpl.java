package com.revature.data;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Album;

public class AlbumDAOImpl implements AlbumDAO {
	private SessionFactory sessionFactory;

	public AlbumDAOImpl() {
		super();
	}

	public AlbumDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Album getAlbumById(int idNumber) {
		int id = idNumber;
		if(id < 1){
			//We may want to throw an exception here.
			return null;
		}
		return (Album) sessionFactory.getCurrentSession().get(Album.class, id);
	}

	@Override
	public List<Album> getAlbumsByArtist(String artist) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Album.class);
		query.add(Restrictions.ilike("artist", artist));
		return query.list();
	}

	@Override
	public List<Album> getAlbumsByType(boolean cd) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Album.class);
		query.add(Restrictions.ilike("cd", cd));
		return query.list();
	}

	@Override
	public List<Album> getAllAlbums() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> getAlbumsByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

}
