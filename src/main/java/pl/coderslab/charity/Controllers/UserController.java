package pl.coderslab.charity.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Classes.Role;
import pl.coderslab.charity.Classes.Token;
import pl.coderslab.charity.Classes.User;
import pl.coderslab.charity.Repositories.RoleRepository;
import pl.coderslab.charity.Repositories.TokenRepository;
import pl.coderslab.charity.Repositories.UserRepository;
import pl.coderslab.charity.SendMail.NotificationService;
import pl.coderslab.charity.Service.TokenService;
import pl.coderslab.charity.Service.UserService;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TokenRepository tokenRepository;
    private final TokenService tokenService;
    @Autowired
    private NotificationService notificationService;
    public UserController(UserService userService, UserRepository userRepository, RoleRepository roleRepository, TokenRepository tokenRepository, TokenService tokenService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tokenRepository = tokenRepository;
        this.tokenService = tokenService;
    }
    @GetMapping("/register/{roleid}")
    public String registerget(@PathVariable("roleid") Long roleid, Model model, HttpSession session) {
        model.addAttribute("user", new User());
        session.setAttribute("emailrepeat", 0);
        session.setAttribute("notrepeat", 0);
        session.setAttribute("roleid", roleid);
        return "register";
    }
    @PostMapping("/register")
    public String registerpost(@Valid User user, BindingResult result, @RequestParam String password2, HttpSession session) {
        boolean back = false;
        List<String> emails = userRepository.emails();
        Iterator<String> iterator = emails.iterator();
        while (iterator.hasNext()) {
            if ((iterator.next()).equals(user.getUsername())) {
                back = true;
                session.setAttribute("emailrepeat", 1);
            }
        }
        if (!user.getPassword().equals(password2)) {
            session.setAttribute("notrepeat", 1);
            back = true;
        }
        if (back == true || result.hasErrors()) {
            return "register";
        }
        Role role = roleRepository.findById((Long) session.getAttribute("roleid"));
        user.setRole(role);
        Token token = new Token();
        user.setIsactive(false);
        String tokenvalue = token.generatetoken();
        String[] tokenexists = tokenService.alltokenvalues();
        while (tokenexists.equals(tokenvalue)) {
            tokenvalue = token.generatetoken();
        }
        token.setToken(tokenvalue);
        token.setActivetoken(true);
        token.setUser(user);
        notificationService.sendveryficatingwithtoken(user, tokenvalue);
        userService.save(user);
        tokenRepository.save(token);
        session.setAttribute("emailrepeat", 0);
        session.setAttribute("notrepeat", 0);
        session.setAttribute("roleid", 0);
        return "redirect:/formsuccess";
    }
    @GetMapping("/formsuccess")
    public String success() {
        return "formsuccess";
    }
    @GetMapping("/emailandaccountveryfication/{token}")
    public String eaaveryfication(@PathVariable("token") String token) {
        Token token1 = tokenRepository.tokenofuser(token);
        User user = token1.getUser();
        if (token1.isActivetoken() && token.length()==10) {
            user.setIsactive(true);
            userService.save(user);
            token1.setActivetoken(false);
            tokenRepository.save(token1);
            return "emailaccountveryficated";
        } else {
            return "403";
        }
    }
    @GetMapping("/login")
    public String getlogin() {
        return "login";
    }
    @GetMapping("/deactive/{id}")
    public String getdeactivelist(@PathVariable("id") Long id) {
        User user = userService.findbyId(id);
        user.setIsactive(false);
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/users")
    public String getuserslist(HttpSession session) {
        session.setAttribute("users", userService.usersnotadmin());
        return "users";
    }
    @GetMapping("/admins")
    public String getadminslist(HttpSession session, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Long id = (userService.findByUsername(username)).getId();
        model.addAttribute("myid", id);
        session.setAttribute("admins", userService.usersadmin());
        return "admins";
    }
    @GetMapping("/deleteusers/{id}")
    public String deleteusers(@PathVariable("id") Long id) {
        User user = userRepository.getById(id);
        userService.deleteuser(user);
        return "redirect:/deleted";
    }
    @GetMapping("/deleted")
    public String deletedusers() {
        return "deleted";
    }
    @GetMapping("/edituser/{id}")
    public String editusers(@PathVariable("id") Long id, HttpSession session, Model model) {
        session.setAttribute("id", id);
        model.addAttribute("user", new User());
        return "edituser";
    }
    @PostMapping("/edituser")
    public String editpost(@Valid User user, BindingResult result, @RequestParam String password2, HttpSession session) {
        boolean back = false;

        if (!user.getPassword().equals(password2)) {
            session.setAttribute("notrepeat", 1);
            back = true;
        }
        if (back == true || result.hasErrors()) {
            return "edituser";
        }
        session.setAttribute("notrepeat", 0);
        Long id = (Long) session.getAttribute("id");
        User userold = userRepository.getById(id);
        userold.setName(user.getName());
        userold.setSurname(user.getSurname());
        userold.setUsername(user.getUsername());
        userold.setPassword(user.getPassword());
        userService.save(userold);
        return "redirect:/edited";
    }
    @GetMapping("/edited")
    public String editedusers() {
        return "edited";
    }
    @GetMapping("/profile")
    public String myprofile(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Long id = (userService.findByUsername(username)).getId();
        User user=userService.findbyId(id);
        model.addAttribute("user",user);
        return "profile";
    }
    @GetMapping("/findbyemail")
    public String findbyemail(HttpSession session) {
        return "findbyemail";
    }
    @PostMapping("/findbyemail")
    public String findbyemailpost(@RequestParam String username,HttpSession session) {
        boolean back = false;
        List<String> emails = userRepository.emails();
        Iterator<String> iterator = emails.iterator();
        while (iterator.hasNext()) {
            if ((iterator.next()).equals(username)) {
                back = true;
            }
        }
        if (back==false){
            session.setAttribute("nouser",1);
            return "findbyemail";
        }else {
            session.setAttribute("nouser",0);
            User user=userService.findByUsername(username);
            Token token=new Token();
            String tokenvalue = token.generalongertetoken();
            String[] tokenexists = tokenService.alltokenvalues();
            while (tokenexists.equals(tokenvalue)) {
                tokenvalue = token.generalongertetoken();
            }
            token.setToken(tokenvalue);
            token.setActivetoken(true);
            token.setUser(user);
            tokenRepository.save(token);
            notificationService.sendresetpasswordwithtoken(user,tokenvalue);
            return "redirect:/resetpasswordsend";
        }
    }
    @GetMapping("/resetpasswordsend")
    public String resetpasswordsend() {
        return "resetpasswordsend";
    }
    @GetMapping("/changepasswordsend/{token}")
    public String changepasswordsend(@PathVariable("token") String token,HttpSession session) {
        Token token1 = tokenRepository.tokenofuser(token);
        if (token.length()!=15 || !token1.isActivetoken() ){
            return "403";
        }else {
            session.setAttribute("token",token);

            return "changepasswordsend";
        }
    }
    @PostMapping("/changepasswordsend")
    public String changepasswordsendpost(HttpSession session,@RequestParam String password,@RequestParam String password2) {
        String token= (String) session.getAttribute("token");

        boolean back=false;
        if (password.length()<8){
            session.setAttribute("tooshort",1);
            back=true;
        }else {
            session.setAttribute("tooshort",0);
        }

        boolean nonumbers= Pattern.matches("[0-9]{0}",password);
        if (nonumbers){
            session.setAttribute("nonumbers",1);
            back=true;
        }else {
            session.setAttribute("nonumbers",0);
        }

        boolean regex = Pattern.matches("[A-Z]{0}", password);
        if (regex){
            session.setAttribute("nobigletters",1);
            back=true;
        }else {
            session.setAttribute("nobigletters",0);
        }
        boolean regex1 = Pattern.matches("[a-z]{0}", password);
        if (regex1){
            session.setAttribute("nolowletters",1);
            back=true;
        }else {
            session.setAttribute("nolowletters",0);
        }
        if (!password.equals(password2)){
            session.setAttribute("nosamepassword",1);
            back=true;
        }else{
            session.setAttribute("nosamepassword",0);
        }

        if (back==true){
            return "changepasswordsend";
        }else {
            Token token1 = tokenRepository.tokenofuser(token);

                User user = token1.getUser();
                user.setPassword(password);
                token1.setActivetoken(false);
                userService.save(user);
                tokenRepository.save(token1);
                return "changedpassword";

        }
    }
    @GetMapping("/changedpassword")
    public String changedpasswordview(){
            return "changedpassword";
    }
}

