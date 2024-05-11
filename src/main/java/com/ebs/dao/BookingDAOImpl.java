package com.ebs.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ebs.entity.Booking;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookingDAOImpl implements BookingDAO {

	private EntityManager entity;

	public BookingDAOImpl() {
		super();
	}

	@Autowired
	public BookingDAOImpl(EntityManager entity) {
		super();
		this.entity = entity;
	}

	@Override
	public void addBooking(Booking booking) {
		try {
			entity.persist(booking);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getAllBooking() {
		try {
			return entity.createQuery("select booking from Booking booking").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public Booking getBooking(int bid) {
		try {
			return entity.find(Booking.class, bid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Booking();
	}

	@Override
	public Booking updateBooking(Booking booking) {
		try {
			return entity.merge(booking);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
