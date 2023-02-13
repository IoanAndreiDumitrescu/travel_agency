package ro.sda.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.andrei.dto.TourOfferAdminDto;
import ro.sda.andrei.dto.TourOfferUserDto;
import ro.sda.andrei.entities.TourOfferUser;
import ro.sda.andrei.entities.enums.StarRating;
import ro.sda.andrei.entities.enums.TravelOption;
import ro.sda.andrei.entities.enums.TypeOfRooms;
import ro.sda.andrei.entities.enums.TypeOfService;
import ro.sda.andrei.service.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TourOfferUserController {

    @Autowired
    private TourOfferUserService tourOfferUserService;
    @Autowired
    private TourOfferAdminService tourOfferAdminService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AirportService airportService;
    @Autowired
    private ContinentService continentService;
    @Autowired
    private CountryService countryService;

    private TourOfferUser tourOfferUser;


    @RequestMapping("/")
    public String showTourOfferForm(Model model) {
        List<TourOfferUser> tourOfferUserList = tourOfferUserService.findAll();
        model.addAttribute("formObject", new TourOfferUserDto());
        model.addAttribute("tourOfferUserInView", tourOfferUserList);
        model.addAttribute("travelOption", TravelOption.values());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("departureDate", LocalDate.now());
        model.addAttribute("typeOfService", TypeOfService.values());
        model.addAttribute("typeOfRooms", TypeOfRooms.values());


        return "user-select-tour-offer";
    }

    @PostMapping("/searchOffer")
    public String showResultsFromSearch(TourOfferUserDto formObject, Model model) {
        List<TourOfferAdminDto> allOffers = tourOfferUserService.searchAvailableOffers(formObject);
        model.addAttribute("resultObject", allOffers);
        model.addAttribute("hotels", hotelService.findAll());
        model.addAttribute("starRating", StarRating.values());
        model.addAttribute("travelOption", TravelOption.values());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("departureDate", LocalDate.now());
        model.addAttribute("typeOfService", TypeOfService.values());
        model.addAttribute("typeOfRooms", TypeOfRooms.values());
        model.addAttribute("starRating", StarRating.values());
        return "tourOfferUser-results";
    }

}


