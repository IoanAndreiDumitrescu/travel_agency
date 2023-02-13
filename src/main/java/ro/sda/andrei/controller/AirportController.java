package ro.sda.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.andrei.dto.AirportDto;
import ro.sda.andrei.entities.Airport;
import ro.sda.andrei.service.AirportService;
import ro.sda.andrei.service.CityService;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private CityService cityService;


    @GetMapping("/")
    public String showAirportsPage(Model model) {

        List<Airport> airportList = airportService.findAll();
        model.addAttribute("airportsInView", airportList);

        return "airport-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Airport newAirport = new Airport();
        model.addAttribute("airport", newAirport);
        model.addAttribute("name", newAirport.getName());
        model.addAttribute("cities", cityService.findAll());

        return "airport-add";
    }

    @PostMapping("/add")
    public String addNewAirport(@ModelAttribute("airport") @Valid Airport airport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "airport-add";
        }
        airportService.save(airport);
        return "redirect:/airport/";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {
        //TODO check if airport Exists
        model.addAttribute("airport", airportService.findById(id));
        model.addAttribute("name", airportService.findById(id).getName());
        model.addAttribute("cities", cityService.findAll());
        return "airport-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute AirportDto airportDto) {

        airportService.update(id, airportDto);
        return "redirect:/airport/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        airportService.delete(id);
        return "redirect:/airport/";
    }


}
