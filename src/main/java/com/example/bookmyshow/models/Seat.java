package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seatId;

    private String seatName;

    private String seatType;

    private String seatStatus;

    private Long showId;

    private Long userId;

    private Long bookingId;

    private Long price;

    private Long movieId;

    private Long theatreId;

    private Long screenId;

    private Long seatNumber;
}
