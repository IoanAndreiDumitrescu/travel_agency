package ro.sda.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.andrei.dto.HotelDto;
import ro.sda.andrei.entities.Hotel;
import ro.sda.andrei.entities.enums.StarRating;
import ro.sda.andrei.service.CityService;
import ro.sda.andrei.service.HotelService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;


    @GetMapping("/")
    public String showHotelsPage(Model model) {

        List<Hotel> hotel = hotelService.findAll();
        model.addAttribute("hotelsInView", hotel);

        return "hotel-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Hotel newHotel = new Hotel();
        model.addAttribute("hotel", newHotel);
        model.addAttribute("stars", StarRating.values());
        model.addAttribute("description", newHotel.getDescription());
        model.addAttribute("cities",cityService.findAll());

        return "hotel-add";
    }

    @PostMapping("/add")
    public String addNewHotel(@ModelAttribute("hotel") @Valid Hotel hotel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "hotel-add";
        }
        hotelService.save(hotel);
        return "redirect:/hotel/";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("hotel", hotelService.findById(id));
        model.addAttribute("stars", StarRating.values());
        model.addAttribute("description", hotelService.findById(id).getDescription());
        model.addAttribute("cities",cityService.findAll());
        return "hotel-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute HotelDto hotelDto) {

        hotelService.update(id, hotelDto);
        return "redirect:/hotel/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        hotelService.delete(id);
        return "redirect:/hotel/";
    }
}