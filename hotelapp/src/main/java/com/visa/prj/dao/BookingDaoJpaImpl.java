package com.visa.prj.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Hotel> findHotels(String criteria) {
		TypedQuery<Hotel> query = em.createQuery("from Hotel where hotel_name like :a or address like :a", Hotel.class);
		query.setParameter("a", "%"+criteria+"%");
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		String jpql = "select u from User u where u.email = :e and password= :p";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("e", email);
		query.setParameter("p", password);
		
		return query.getResultList().get(0);
	}

	@Override
	public long createBooking(Booking booking) {
		em.persist(booking);
		return 0;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		TypedQuery<Booking> query = em.createQuery("select b from Booking b where user = :u", Booking.class);
		query.setParameter("u", user);
		return query.getResultList();
		//return null;
	}

}
