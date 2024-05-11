package com.ebs;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ebs.controller.VenueController;
import com.ebs.entity.Venue;

@SpringBootTest
class EventBookingSystemDevopsApplicationTests {

	@Autowired

	VenueController venueController;

	@Test

	void test_addVenue() {

		Venue venue = new Venue();
		venue.setName("Raja Hall");
		venue.setLocation("Madurai");
		venue.setSeatCapacity(1500);
		venue.setType("Hall");
		String msg = "Venue Object Saved";
		String result = venueController.addVenue(venue);
		assertEquals(msg, result);

	}

	@Test

	void test_updateVenue() {
		Venue venue = new Venue();
		venue.setId(15);
		venue.setName("ABC Auditorium");
		venue.setLocation("Chennai");
		venue.setSeatCapacity(500);
		venue.setType("Auditorium");
		String msg = "Venue Object Updated";
		String result = venueController.updateVenue(venue);
		assertEquals(msg, result);

	}

	@Test
	void test_findVenue() {
		Venue venue = venueController.performFind(5);
		assertNotNull(venue);

	}

}
