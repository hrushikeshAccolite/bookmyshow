package com.example.bookmyshow.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Column(name = "seat" , nullable = false)
    private String seat;

    @Column(name = "bookingPrice" , nullable = false)
    private double bookingPrice;

    @CreationTimestamp
    private Date bookingDateAndTime;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
	@JsonIgnore
	private Show show;

	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Seat> seats;
}
