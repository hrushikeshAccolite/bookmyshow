package com.example.bookmyshow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.repository.ShowRepository;

@Service
public class ShowServicesImpl implements ShowServices{

    @Autowired
    private ShowRepository showRepository;

    @Override
    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public Show getShowById(Long showId) {
        Optional<Show> showObj = this.showRepository.findById(showId);
        if(showObj.isPresent()){
            return showObj.get();
        } else {
            throw new RuntimeException("Show not found with id " + showObj);
        }
    }
    
}
