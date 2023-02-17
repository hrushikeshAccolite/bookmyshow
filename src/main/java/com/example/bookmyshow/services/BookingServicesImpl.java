package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.repository.BookingRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServicesImpl implements BookingServices{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        Optional<Booking> bookingObj = this.bookingRepository.findById(bookingId);
        if(bookingObj.isPresent()){
            return bookingObj.get();
        } else {
            throw new RuntimeException("Booking not found with id " + bookingId);
        }
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Optional<Booking> bookingObj = this.bookingRepository.findById(bookingId);
        if(bookingObj.isPresent()){
            this.bookingRepository.deleteById(bookingId);
        } else {
            throw new RuntimeException("Booking not found with id " + bookingId);
        }
    }   
}
