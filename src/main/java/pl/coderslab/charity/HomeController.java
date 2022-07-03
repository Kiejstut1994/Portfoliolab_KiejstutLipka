package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Classes.Category;
import pl.coderslab.charity.Classes.Institution;
import pl.coderslab.charity.DAOclasses.CategoryDAO;
import pl.coderslab.charity.DAOclasses.DonationDAO;
import pl.coderslab.charity.DAOclasses.InstitutionDAO;

import java.util.List;


@Controller
public class HomeController {

    public final InstitutionDAO institutionDAO;
    public final DonationDAO donationDAO;
    public final CategoryDAO categoryDAO;

    public HomeController(InstitutionDAO institutionDAO, DonationDAO donationDAO, CategoryDAO categoryDAO) {
        this.institutionDAO = institutionDAO;
        this.donationDAO = donationDAO;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping("/")
    public String homeAction(Model model)
    {

      model.addAttribute("categories",categoryDAO.findallcategory());
        model.addAttribute("institutions",institutionDAO.findallinstitution());
//        model.addAttribute("numberofquantity",donationDAO.numberofquantity());
        model.addAttribute("numberofquantity",0);
            model.addAttribute("numberodonation",0);

//        model.addAttribute("numberodonation",donationDAO.numberodonation());
        return "index";
    }


}
