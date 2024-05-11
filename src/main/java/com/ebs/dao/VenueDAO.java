package com.ebs.dao;

import java.util.List;
import com.ebs.entity.Venue;

public interface VenueDAO {

	public void addVenue(Venue venue);

	List<Venue> getAllVenue();

	public Venue getVenue(int id);

	public Venue updateVenue(Venue venue);
}
