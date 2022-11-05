package pl.coderslab.charity.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Classes.Role;
import pl.coderslab.charity.Classes.User;
import pl.coderslab.charity.Repositories.RoleRepository;
import pl.coderslab.charity.Repositories.UserRepository;

import java.security.Principal;
import java.util.List;

@Service
public class UserService {
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public void save(User user, Principal principal){
        userRepository.save(user);
    }
    public List<User> findall(){
        return userRepository.findAll();
    }
    public void deleteuser(User user){
        userRepository.delete(user);
    }
    public User findbyId(Long id){
        return userRepository.getById(id);
    }
    public List<User> usersnotadmin(){
        return userRepository.justusers();
    }
}
