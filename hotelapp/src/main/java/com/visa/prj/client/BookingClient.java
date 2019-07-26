package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.services.BookingService;

public class BookingClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa.prj");
		ctx.refresh();
		BookingService service = ctx.getBean("bookingService", BookingService.class);

		User user = service.getUser("amrnaray@gmail.com", "506250");
		
		Hotel hotel = service.findHotelById(1);
		//System.out.println(user);
		Booking booking = new Booking(hotel, user);
		service.createBooking(booking);
		
		System.out.println(service.getAllBookingsOfUser(user));
		service.findHotels("Street").forEach(h-> System.out.println(h.getName()));
	}

}
