package pl.coderslab.charity.Controllers;



import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Classes.Donation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.coderslab.charity.Service.CategoryService;
import pl.coderslab.charity.Service.DonationService;
import pl.coderslab.charity.Service.InstitutionService;
import pl.coderslab.charity.Service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class DonationController {

    private final DonationService donationService;
    private InstitutionService institutionService;
    private CategoryService categoryService;
    private UserService userService;


    public DonationController(DonationService donationService, InstitutionService institutionService, CategoryService categoryService, UserService userService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/donationform")
    public String donationformget(Model model, HttpSession session){
        model.addAttribute("donation", new Donation());
        session.setAttribute("institutions", institutionService.findAll());
        session.setAttribute("categories", categoryService.findAll());
        return "donationform";
    }

    @PostMapping("/donationform")
    public String donationformpost(@Valid Donation donation,BindingResult result, Principal principal) {
        if(result.hasErrors()){
            return "donationform";
        }
        donationService.save(donation, principal);
        return "formconfirmation";
    }
    @GetMapping("/mydonations")
    public String mydonationget(Model model, HttpSession session){
        model.addAttribute("mydonations",donationService.mydonations(1L));
        model.addAttribute("mypiceddonations",donationService.mypiceddonations(1L));
        model.addAttribute("mynotpickeddonations",donationService.mynotpickeddonations(1L));
        return "mydonations";
    }
    @GetMapping("/changedataofdonation/{id}")
    public String changedataget(@PathVariable("id") Long id, HttpSession session){
        session.setAttribute("idofchanging",id);
        return "changedataofdonation";
    }
    @PostMapping("/changedataofdonation")
    public String changedatapost(@RequestParam LocalDate pickUpDate, @RequestParam LocalTime pickUpTime, HttpSession session,Principal principal){
        Long id=(Long) session.getAttribute("idofchanging");
        Donation donation=donationService.findbyid(id);
        donation.setPickUpDate(pickUpDate);
        donation.setPickUpTime(pickUpTime);
        donationService.save(donation,principal);
        return "redirect:mydonations";
    }
}
