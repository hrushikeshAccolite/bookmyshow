package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Theatre;
import com.example.bookmyshow.repository.TheatreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TheatreServicesImpl implements TheatreServices{

    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public Theatre updateTheatre(Theatre theatre) {
        Optional<Theatre> theatreObj = this.theatreRepository.findById(theatre.getTheatreId());    
        if(theatreObj.isPresent()){
            Theatre updatedTheatre = theatreObj.get();
            updatedTheatre.setTheatreName(theatre.getTheatreName());
            updatedTheatre.setTheatreCity(theatre.getTheatreCity());
            return this.theatreRepository.save(updatedTheatre);
        } else {
            throw new RuntimeException("Theatre not found with id: " + theatre.getTheatreId());
        }
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return this.theatreRepository.findAll();
    }

    @Override
    public Theatre getTheatreById(Long theatreId) {
        Optional<Theatre> theatreObj = this.theatreRepository.findById(theatreId);
        if(theatreObj.isPresent()){
            return theatreObj.get();
        } else {
            throw new RuntimeException("Theatre not found with id " + theatreId);
        }
    }

    @Override
    public void deleteTheatre(Long theatreId) {
        Optional<Theatre> theatreObj = this.theatreRepository.findById(theatreId);
        if(theatreObj.isPresent()){
            this.theatreRepository.deleteById(theatreId);
        } else {
            throw new RuntimeException("Theatre not found with id " + theatreId);
        }
    }
}
