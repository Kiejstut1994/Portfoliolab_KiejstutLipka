package pl.coderslab.charity;



import Classes.Donation;
import DAOclasses.CategoryDAO;
import DAOclasses.DonationDAO;
import DAOclasses.InstitutionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class DonationController {
    @Autowired
    public final DonationDAO donationDAO;
    public InstitutionDAO institutionDAO;
public final CategoryDAO categoryDAO;

    public DonationController(DonationDAO donationDAO, CategoryDAO categoryDAO) {
        this.donationDAO = donationDAO;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String sendlist(Model model) {
        List<Donation> donations=donationDAO.findalldonation();
        model.addAttribute("donations", donations);
        return "index";
    }
    @RequestMapping(value = "/donationform", method = RequestMethod.GET)
    public String donationadd(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories",categoryDAO.findallcategory());
        model.addAttribute("institutions",institutionDAO.findallinstitution());
        return "donationform";
    }
    @RequestMapping(value = "/donationform", method = RequestMethod.POST)
    public String donationaddpost(@Valid Donation donation, BindingResult result) {
if (result.hasErrors())
{
    return "donationform";
}
donationDAO.saveDonation(donation);
        return "form-confirmation";
    }
}
