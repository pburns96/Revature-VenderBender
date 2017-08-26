package com.revature.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public Album getAlbumById(int idNumber) {
		int id = idNumber;
		if(id < 1){
			//TODO We may want to throw an exception here.
			return null;
		}
		return (Album) sessionFactory.getCurrentSession().get(Album.class, id);
	}

	@Override
	@Transactional
	public List<Album> getAlbumsByArtist(String artist) {
		if (artist.length() > 0) {
			Criteria query = sessionFactory.getCurrentSession().createCriteria(Album.class);
			query.add(Restrictions.like("artist", artist));
			return query.list();
		}
		//TODO We may want to throw an exception here.
		return null;
	}

	@Override
	@Transactional
	public List<Album> getAlbumsByType(byte cd) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Album.class);
		query.add(Restrictions.like("cd", cd));
		return query.list();
	}

	@Override
	@Transactional
	public List<Album> getAllAlbums() {
		return sessionFactory.getCurrentSession().createQuery("FROM Album").list();
	}

	@Override
	@Transactional
	public List<Album> getAlbumsByGenre(String genre) {
		if (genre.length() > 0) {
			Criteria query = sessionFactory.getCurrentSession().createCriteria(Album.class);
			query.add(Restrictions.like("genre", genre));
			return query.list();
		}
		//TODO We may want to throw an exception here.
		return null;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void createAlbum(Album album) {
		if(album.getArtist() == null){
			//TODO We may want to throw an exception here.
			return;
		}
		sessionFactory.getCurrentSession().saveOrUpdate(album);

	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void updateAlbum(Album album) {
		if(album.getArtist() == null){
			//TODO We may want to throw an exception here.
			return;
		}
		sessionFactory.getCurrentSession().saveOrUpdate(album);
		
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void deleteAlbum(Album album) {
		if(album.getArtist() == null){
			//TODO We may want to throw an exception here.
			return;
		}
		sessionFactory.getCurrentSession().delete(album);
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
