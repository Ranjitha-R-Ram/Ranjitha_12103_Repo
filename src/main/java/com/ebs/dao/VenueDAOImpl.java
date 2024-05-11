package com.ebs.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ebs.entity.Venue;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VenueDAOImpl implements VenueDAO {

	private EntityManager entity;

	public VenueDAOImpl() {
		super();

	}

	@Autowired
	public VenueDAOImpl(EntityManager entity) {
		super();
		this.entity = entity;
	}

	@Override
	public void addVenue(Venue venue) {
		try {
			entity.persist(venue);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venue> getAllVenue() {
		try {
			return entity.createQuery("select venue from Venue venue").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public Venue getVenue(int id) {
		try {
			return entity.find(Venue.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Venue();
	}

	@Override
	public Venue updateVenue(Venue venue) {
		try {
			return entity.merge(venue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
