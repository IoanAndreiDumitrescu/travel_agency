package ro.sda.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.andrei.entities.TourOfferAdmin;
import ro.sda.andrei.service.TourOfferAdminService;

import java.util.List;


@Controller
public class NavbarLinksController {

    @Autowired
    private TourOfferAdminService tourOfferAdminService;

    private TourOfferAdmin tourOfferAdmin;


    @GetMapping("/cazare-Romania")
    public String showOffersRomania(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("Cazare Romania");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "cazare-Romania";
    }

    @GetMapping("/city-break")
    public String showCityBreak(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("City Break");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "city-break";
    }

    @GetMapping("/promotii")
    public String showPromoted(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("Promotii");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "promotii";
    }

    @GetMapping("/vacante")
    public String showVacante(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("vacante");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "vacante";
    }

    @GetMapping("/bilete-de-avion")
    public String showBileteAvion(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("bilete-de-avion");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "bilete-de-avion";
    }

    @GetMapping("/charter-exotic")
    public String showCharterExotic(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("charter-exotic");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "charter-exotic";
    }

    @GetMapping("/circuite")
    public String showCircuite(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("circuite");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "circuite";
    }

    @GetMapping("/exotice")
    public String showExotice(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("exotice");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "exotice";
    }

    @GetMapping("/craciun-2022")
    public String showCraciun(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("craciun-2022");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "craciun-2022";
    }

    @GetMapping("/revelion-2022")
    public String showRevelion(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("revelion-2022");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "revelion-2022";
    }

    @GetMapping("/senior-voyage")
    public String showSeniorVoyage(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("senior-voyage");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "senior-voyage";
    }

    @GetMapping("/ski")
    public String showSki(Model model) {
        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.searchByName("ski");
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "ski";
    }


    @GetMapping("/contact")
    public String showContact() {
        return "contact";
    }

    @GetMapping("/despre_noi")
    public String showAboutPage(Model model) {
        return "despre_noi";
    }

    @GetMapping("/termeni_si_conditii")
    public String showTermsPage(Model model) {
        return "termeni_si_conditii";
    }

    @GetMapping("/vacanta-placuta")
    public String showText(Model model) {
        return "vacanta-placuta";
    }


}
