package com.ebs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ebs.dao.VenueDAOImpl;
import com.ebs.entity.Venue;

@RestController
@CrossOrigin("http://localhost:3000/")
public class VenueController {

	@Autowired
	VenueDAOImpl dao;

	@PostMapping("/AddVenue")
	public String addVenue(@RequestBody Venue venue) {
		String msg = "";
		try {
			dao.addVenue(venue);
			msg = "Venue Object Saved";
		} catch (Exception e) {
			msg = "Venue Object Not Saved";
		}
		return msg;
	}

	@PutMapping("/UpdateVenue")
	public String updateVenue(@RequestBody Venue venue) {
		String msg = "";
		try {
			dao.updateVenue(venue);
			msg = "Venue Object Updated";
		} catch (Exception e) {
			msg = "Venue Object Not Updated";
		}
		return msg;
	}

	@GetMapping("/GetVenue/{id}")
	public Venue performFind(@PathVariable("id") int id) {
		return dao.getVenue(id);

	}

	@GetMapping("/GetAllVenue")
	List<Venue> getAllVenue() {
		return dao.getAllVenue();
	}

}
