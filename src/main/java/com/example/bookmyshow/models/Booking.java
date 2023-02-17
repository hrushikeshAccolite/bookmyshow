package com.example.bookmyshow.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;

    // private long userId;
    // private long showId;
    // private long seatId;
    // private long movieId;
    // private long theatreId;
    // private long screenId;
    // private long paymentId;

    @CreationTimestamp
    private Date bookingDateAndTime;

    // private String bookingStatus;
    
    private long bookingPrice;
}
