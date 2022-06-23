package pl.coderslab.charity;



import Classes.Donation;
import DAOclasses.DonationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class DonationController {
    @Autowired
    public final DonationDAO donationDAO;

//    public DonationController(DonationDAO donationDAO) {
//        this.donationDAO = donationDAO;
//    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String sendlist(Model model) {
        List<Donation> donations=donationDAO.findalldonation();
        model.addAttribute("donations", donations);
        return "index";
    }

}
