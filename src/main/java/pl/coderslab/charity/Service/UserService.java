package pl.coderslab.charity.Service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Classes.User;
import pl.coderslab.charity.Repositories.RoleRepository;
import pl.coderslab.charity.Repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }
    public void save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
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


    public User findByUsername(String usernamename){
        return userRepository.userveryf(usernamename);
    }
    public List<User> usersnotadmin(){
        return userRepository.usersnotadmin();
    }

    public List<User> usersadmin(){
        return userRepository.usersadmin();
    }
}
