package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Booking;

public interface BookingServices {

    Booking createBooking(Booking booking);
    Booking getBookingById(Long bookingId);
    void cancelBooking(Long bookingId);
    
}
