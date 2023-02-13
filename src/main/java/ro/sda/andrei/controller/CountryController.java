package ro.sda.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.andrei.dto.CountryDto;
import ro.sda.andrei.entities.Country;
import ro.sda.andrei.service.ContinentService;
import ro.sda.andrei.service.CountryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private ContinentService continentService;
//    @Autowired
//    private CityService cityService;


    @GetMapping("/")
    public String showCountriesPage(Model model) {
        List<Country> country = countryService.findAll();
        model.addAttribute("countriesInView", country);
        return "country-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Country newCountry = new Country();
        model.addAttribute("country", newCountry);
        model.addAttribute("continents", continentService.findAll());
        return "country-add";
    }

    @PostMapping("/add")
    public String addNewCountry(@Valid Country country, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "country-add";
        }
        countryService.save(country);
        return "redirect:/country/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("country", countryService.findById(id));
        return "country-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute CountryDto countryDto) {

        countryService.update(id, countryDto);
        return "redirect:/country/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        countryService.delete(id);
        return "redirect:/country/";
    }

}
