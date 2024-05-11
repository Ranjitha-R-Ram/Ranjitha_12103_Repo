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

import com.ebs.dao.BookingDAOImpl;
import com.ebs.entity.Booking;

@RestController
@CrossOrigin("http://localhost:3000/")
public class BookingController {

	@Autowired
	BookingDAOImpl dao;

	@PostMapping("/AddBooking")
	public String addBooking(@RequestBody Booking booking) {
		String msg = "";
		try {
			dao.addBooking(booking);
			msg = "Booking Object Saved";
		} catch (Exception e) {
			msg = "Booking Object Not Saved";
		}
		return msg;
	}

	@PutMapping("/UpdateBooking")
	public String updateBooking(@RequestBody Booking booking) {
		String msg = "";
		try {
			dao.updateBooking(booking);
			msg = "Booking Object Updated";
		} catch (Exception e) {
			msg = "Booking Object Not Updated";
		}
		return msg;
	}

	@GetMapping("/GetBooking/{bid}")
	public Booking performFind(@PathVariable("bid") int bid) {
		return dao.getBooking(bid);

	}

	@GetMapping("/GetAllBooking")
	public List<Booking> getAllBooking() {
		return dao.getAllBooking();
	}
}
