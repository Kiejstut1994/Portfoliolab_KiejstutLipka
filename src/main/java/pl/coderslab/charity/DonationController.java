package pl.coderslab.charity;



import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Classes.Category;
import pl.coderslab.charity.Classes.Donation;
import pl.coderslab.charity.Classes.Institution;
import pl.coderslab.charity.DAOclasses.CategoryDAO;
import pl.coderslab.charity.DAOclasses.DonationDAO;
import pl.coderslab.charity.DAOclasses.InstitutionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class DonationController {
    @Autowired
    public final DonationDAO donationDAO;
    public final InstitutionDAO institutionDAO;
public final CategoryDAO categoryDAO;

    public DonationController(DonationDAO donationDAO, InstitutionDAO institutionDAO, CategoryDAO categoryDAO) {
        this.donationDAO = donationDAO;
        this.institutionDAO = institutionDAO;
        this.categoryDAO = categoryDAO;
    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String sendlist(Model model) {
//        List<Donation> donations=donationDAO.findalldonation();
//        model.addAttribute("donations", donations);
//        return "index";
//    }
    @GetMapping(value = "/donationform")
    public String donationadd(Model model) {
        model.addAttribute("donation",new Donation());
        model.addAttribute("categories",categoryDAO.findallcategory());
        model.addAttribute("donations",donationDAO.findalldonation());
        model.addAttribute("institutions",institutionDAO.findallinstitution());
        return "donationform";
    }
    @PostMapping(value = "/donationform")
    public String donationaddpost(Model model,@Valid Donation donation, BindingResult result) {
if (result.hasErrors())
{
    model.addAttribute("categories",categoryDAO.findallcategory());
    model.addAttribute("donations",donationDAO.findalldonation());
    model.addAttribute("institutions",institutionDAO.findallinstitution());
    return "donationform";
}
donationDAO.saveDonation(donation);
        return "redirect:index";
    }
}
