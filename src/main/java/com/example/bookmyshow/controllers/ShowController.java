package com.example.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.services.ShowServices;

@RestController
public class ShowController {
    
    @Autowired
    private ShowServices showServices;

    @GetMapping("/show/{showId}")
    private Show getShowById(@PathVariable long showId) {
        return this.showServices.getShowById(showId);
    }

    @PostMapping("/createShow")
    private ResponseEntity<Show> addShow(@RequestBody Show show){
        return ResponseEntity.ok().body(this.showServices.createShow(show));
    }

}
