package pl.coderslab.charity.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Repositories.*;
import pl.coderslab.charity.Service.CategoryService;
import pl.coderslab.charity.Service.DonationService;
import pl.coderslab.charity.Service.InstitutionService;


@Controller
public class HomeController {

    public final CategoryRepository categoryRepository;
    public final InstitutionRepository institutionRepository;
    public final DonationRepository donationRepository;
    public final InstitutionService institutionService;
    public final DonationService donationService;
    public final CategoryService categoryService;

    public HomeController( CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository, InstitutionService institutionService, DonationService donationService, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String homeAction(Model model)
    {
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("numberofquantity", donationService.countBags());
        model.addAttribute("numberodonation", donationService.countDonations());
        return "index";
    }


}
