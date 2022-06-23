package pl.coderslab.charity;

import Classes.Institution;
import DAOclasses.InstitutionDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class InstitutionController {
    public final InstitutionDAO institutionDAO;

    public InstitutionController(InstitutionDAO institutionDAO) {
        this.institutionDAO = institutionDAO;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String sendlist(Model model) {
        List<Institution> institutions=institutionDAO.findallinstitution();
        model.addAttribute("institutions", institutions);
        return "index";
    }
}
