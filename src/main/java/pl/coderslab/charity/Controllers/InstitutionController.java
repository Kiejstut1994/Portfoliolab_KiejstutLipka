package pl.coderslab.charity.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.Classes.Institution;
import pl.coderslab.charity.Repositories.InstitutionRepository;
import pl.coderslab.charity.Service.InstitutionService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class InstitutionController {
    private final InstitutionService institutionService;
    private final InstitutionRepository institutionRepository;

    public InstitutionController(InstitutionService institutionService, InstitutionRepository institutionRepository) {
        this.institutionService = institutionService;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/institutions")
    public String showallinstitutionsget(HttpSession session){
        session.setAttribute("institutions",institutionService.findAll());
        return "institutions";
    }
    @GetMapping("/deleteinstitutions/{id}")
    public String deleteinstitution(@PathVariable("id")Long id){
        Institution institution=institutionRepository.getById(id);
        institutionService.deleteinstitution(institution);
        return "redirect:/institutions";
    }
    @GetMapping("/institutionform")
    public String institutionget(Model model,HttpSession session){
        session.setAttribute("choose",1);
        model.addAttribute("institution",new Institution());
        return "institutionform";
    }
    @PostMapping("/institutionform")
    public String editinstitutionpost(@Valid Institution institution, BindingResult result){
        if(result.hasErrors()){
            return "institutionform";
        }
        institutionRepository.save(institution);
        return "redirect:/institutions";
    }
    @GetMapping("/editinstitutions/{id}")
    public String editinstitutionget(@PathVariable("id")Long id, HttpSession session, Model model){
        session.setAttribute("id",id);
        session.setAttribute("choose",0);
        model.addAttribute("institution",new Institution());
        return "editinstitutions";
    }
    @PostMapping("/editinstitutions")
    public String editinstitutionpost(@Valid Institution institution, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "editinstitutions";
        }
        Long id=(Long)  session.getAttribute("id");
        Institution institutionold=institutionRepository.getById(id);
        institutionold.setName(institution.getName());
        institutionold.setDescription(institution.getDescription());
        institutionRepository.save(institutionold);
       return "redirect:/institutions";
    }
}
