package com.ebs.dao;

import java.util.List;

import com.ebs.entity.Booking;

public interface BookingDAO {

	public void addBooking(Booking booking);

	List<Booking> getAllBooking();

	public Booking getBooking(int bid);

	public Booking updateBooking(Booking booking);

}
