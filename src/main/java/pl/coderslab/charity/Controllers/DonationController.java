package pl.coderslab.charity.Controllers;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.Classes.Donation;
import pl.coderslab.charity.Classes.User;
import pl.coderslab.charity.Service.CategoryService;
import pl.coderslab.charity.Service.DonationService;
import pl.coderslab.charity.Service.InstitutionService;
import pl.coderslab.charity.Service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

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
    public String donationformpost(@Valid Donation donation, BindingResult result, Principal principal1) {
        if(result.hasErrors()){
            return "donationform";
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username  = ((UserDetails)principal).getUsername();
        Long id=(userService.findByUsername(username)).getId();
        User user=userService.findbyId(id);
        donation.setUser(user);
        donationService.save(donation, principal1);
        return "redirect:/formconfirmation";
    }
    @GetMapping("/formconfirmation")
    public String formconfirmation() {
        return "formconfirmation";
    }
    @GetMapping("/mydonations")
    public String mydonationget(Model model, HttpSession session){
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username  = ((UserDetails)principal).getUsername();
            Long id=(userService.findByUsername(username)).getId();
            model.addAttribute("mydonations",donationService.mydonations(id));
            model.addAttribute("mypiceddonations",donationService.mypiceddonations(id));
            model.addAttribute("mynotpickeddonations",donationService.mynotpickeddonations(id));
        return "mydonations";
    }
    @GetMapping("/changedataofdonation/{id}")
    public String changedataget(@PathVariable("id") Long id, HttpSession session){
        session.setAttribute("idofchanging",id);
        return "changedataofdonation";
    }
    @PostMapping("/changedataofdonation")
    public String changedatapost(@RequestParam String pickUpDate, @RequestParam String pickUpTime, HttpSession session, Principal principal){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("HH:mm");
        Long id=(Long) session.getAttribute("idofchanging");
        Donation donation=donationService.findbyid(id);
        donation.setPickUpDate(LocalDate.parse(pickUpDate,formatter));
        donation.setPickUpTime(LocalTime.parse(pickUpTime,formatter2));
        donationService.save(donation,principal);
        return "redirect:mydonations";
    }
}
