package com.example.bookmyshow.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

@Getter
@Setter
@Entity
@Data
@Table(name = "shows")
public class Show {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showId;

    @Column(name = "showDate", columnDefinition = "DATE", nullable = false)
	private LocalDate showDate;

	@Column(name = "showTime", columnDefinition = "TIME", nullable = false)
	private LocalTime showTime;

    @ManyToOne
    @JsonIgnore
    private Movie movie;
    
    @ManyToOne
    @JsonIgnore
    private Theatre theatre;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Seat> seats;
}
