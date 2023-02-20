package com.example.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmyshow.services.ShowServices;

@RestController
public class ShowController {
    
    @Autowired
    private ShowServices showServices;

}
