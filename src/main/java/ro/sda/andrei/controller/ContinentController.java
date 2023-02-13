package ro.sda.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.andrei.dto.ContinentDto;
import ro.sda.andrei.entities.Continent;
import ro.sda.andrei.service.ContinentService;
import ro.sda.andrei.service.CountryService;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/continent")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @Autowired
    private CountryService countryService;


    @GetMapping("/")
    public String showContinentsPage(Model model) {

        List<Continent> continentList = continentService.findAll();
        model.addAttribute("continentsInView", continentList);

        return "continent-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Continent newContinent = new Continent();
        model.addAttribute("continent", newContinent);
        model.addAttribute("countries",countryService.findAll());
        return "continent-add";
    }

    @PostMapping("/add")
    public String addNewContinent(@ModelAttribute("continent") @Valid Continent continent, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "continent-add";
        }
        continentService.save(continent);
        return "redirect:/continent/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {
        //TODO check if continent Exists
        model.addAttribute("continent", continentService.findById(id));
        model.addAttribute("countries", countryService.findAll());
        return "continent-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute ContinentDto continentDto) {

        continentService.update(id, continentDto);
        return "redirect:/continent/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        continentService.delete(id);
        return "redirect:/continent/";
    }
}
