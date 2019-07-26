package com.visa.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Actor;
import com.visa.prj.entity.Movie;

@Repository
@Transactional
public class MovieDaoJpaImpl implements MovieDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void addMovie(Movie m) {
		em.persist(m);
	}

	@Override
	public void addActor(Actor a) {
		em.persist(a);
	}

	@Override
	public Movie getMovie(int movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public Actor getActor(int actorId) {
		return em.find(Actor.class, actorId);
	}

	@Override
	public void assignActorstoMovie(Movie m) {
		em.merge(m); // update
	}

}



