package pl.coderslab.charity.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Classes.User;
import pl.coderslab.charity.Repositories.UserRepository;
import pl.coderslab.charity.Service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String registerget(Model model,HttpSession session){
    model.addAttribute("user",new User());
        session.setAttribute("emailrepeat",0);
        session.setAttribute("notrepeat",0);
    return "register";
    }
    @PostMapping("/register")
    public String registerpost(@Valid User user, BindingResult result, @RequestParam String password2, Principal principal, HttpSession session){
        boolean back=false;
        List<String> emails=userRepository.emails();
        Iterator<String> iterator=emails.iterator();
        while (iterator.hasNext()){
            if((iterator.next()).equals(user.getEmail())){
                back=true;
                session.setAttribute("emailrepeat",1);
            }
        }

        if (!user.getPassword().equals(password2)){
            session.setAttribute("notrepeat",1);
            back=true;
        }
        if (back==true|| result.hasErrors()){
            return "register";
        }
        user.setActive(false);

        userService.save(user,principal);
        session.setAttribute("emailrepeat",0);
        session.setAttribute("notrepeat",0);
        return "redirect:/login";
    }
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getlogin(){
        return "/login";
    }
    @PostMapping("/login")
    public String postlogin(@RequestParam String email,@RequestParam String password){
        User user=userRepository.userveryf(email);
        if ((user.getPassword()==password) && user.isActive()==true) {
            return "redirect:/formconfirmation";
        }else {
            return "/login";
        }

    }
    @GetMapping("/deactive/{id}")
    public String getdeactivelist(@PathVariable("id") Long id,Principal principal)
    {
        User user=userService.findbyId(id);
        user.setActive(false);
        userService.save(user,principal);
        return "redirect:/users";
    }
    @GetMapping("/users")
    public String getuserslist(HttpSession session)
    {
        session.setAttribute("users", userService.usersnotadmin());
        return "users";
    }
    @GetMapping("/deleteusers/{id}")
    public String deleteusers(@PathVariable("id") Long id)
    {
        User user=userRepository.getById(id);
      userService.deleteuser(user);
        return "redirect:/users";
    }
    @GetMapping("/edituser/{id}")
    public String editusers(@PathVariable("id") Long id,HttpSession session,Model model)
    {
     session.setAttribute("id",id);
     model.addAttribute("user",new User());
        return "edituser";
    }
    @PostMapping("/edituser")
    public String editpost(@Valid User user, BindingResult result, @RequestParam String password2, Principal principal, HttpSession session){
        boolean back=false;
        List<String> emails=userRepository.emails();
        Iterator<String> iterator=emails.iterator();
        while (iterator.hasNext()){
            if((iterator.next()).equals(user.getEmail())){
                back=true;
                session.setAttribute("emailrepeat",1);
            }
        }

        if (!user.getPassword().equals(password2)){
            session.setAttribute("notrepeat",1);
            back=true;
        }
        if (back==true|| result.hasErrors()){
            return "edituser";
        }

        session.setAttribute("emailrepeat",0);
        session.setAttribute("notrepeat",0);
        Long id=(Long) session.getAttribute("id");
        User userold=userRepository.getById(id);
        userold.setName(user.getName());
        userold.setSurname(user.getSurname());
        userold.setEmail(user.getEmail());
        userold.setPassword(user.getPassword());
        userService.save(userold,principal);
        return "redirect:/login";
    }
}
