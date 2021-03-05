package com.tts.WeatherAPI.controller;

import com.tts.WeatherAPI.model.Request;
import com.tts.WeatherAPI.model.Response;
import com.tts.WeatherAPI.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;


    //we're hardcoding the zip code that gets passed into the API
    //change this later
    //    @GetMapping
    //    public String getIndex(Model model) {
    //        Response response = weatherService.getForecast("43220");
    //        model.addAttribute("data", response);
    //        return "index";
    //    }

    //changed to this below slide 30

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("request", new Request());
        model.addAttribute("recentSearches", weatherService.getRecentSearches());
        return "index";
    }

    //create a new method to handle the POST request from the form, and
    // display the index.html page with weather data on it slide 31

    @PostMapping
    public String postIndex(Request request, Model model) {
        Response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);
        return "index";
    }

}
