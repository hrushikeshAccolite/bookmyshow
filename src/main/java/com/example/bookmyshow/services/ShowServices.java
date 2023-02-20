package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Show;

public interface ShowServices {
    Show createShow(Show show);
    Show getShowById(Long showId);
}
