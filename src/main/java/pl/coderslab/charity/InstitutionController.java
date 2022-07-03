package pl.coderslab.charity;

import pl.coderslab.charity.Classes.Donation;
import pl.coderslab.charity.Classes.Institution;
import pl.coderslab.charity.DAOclasses.DonationDAO;
import pl.coderslab.charity.DAOclasses.InstitutionDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class InstitutionController {

    public final InstitutionDAO institutionDAO;
    public final DonationDAO donationDAO;

    public InstitutionController(InstitutionDAO institutionDAO, DonationDAO donationDAO) {
        this.institutionDAO = institutionDAO;
        this.donationDAO = donationDAO;
    }


//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String sendlist(Model model) {
//        List<Institution> institutions=institutionDAO.findallinstitution();
//        model.addAttribute("institutions", institutions);
//
//        List<Donation> donations=donationDAO.findalldonation();
//        model.addAttribute("donations", donations);
//        return "index";
//    }

}
