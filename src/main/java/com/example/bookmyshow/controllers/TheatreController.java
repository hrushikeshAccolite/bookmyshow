package com.example.bookmyshow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bookmyshow.models.Theatre;
import com.example.bookmyshow.services.TheatreServices;

@RestController
public class TheatreController {

    @Autowired
    private TheatreServices theatreServices;

    @GetMapping("/theatres")
    private ResponseEntity<List<Theatre>> getAllTheatres(){
        return ResponseEntity.ok().body(this.theatreServices.getAllTheatres());
    }

    @GetMapping("/theatres/{theatreId}")
    private Theatre getTheatreById(@PathVariable long theatreId) {
        return this.theatreServices.getTheatreById(theatreId);
    }

    @PostMapping("/addTheatre")
    private ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre){
        return ResponseEntity.ok().body(this.theatreServices.createTheatre(theatre));
    }

    @PutMapping("/updateTheatre/{theatreId}")
    private ResponseEntity<Theatre> updateTheatre(@PathVariable long theatreId, @RequestBody Theatre theatre){
        theatre.setTheatreId(theatreId);
        return ResponseEntity.ok().body(this.theatreServices.updateTheatre(theatre));
    }
    
    @DeleteMapping("/deleteTheatre/{theatreId}")
    private HttpStatus deleteTheatre(@PathVariable long theatreId){
        this.theatreServices.deleteTheatre(theatreId);
        return HttpStatus.OK;
    }
}
