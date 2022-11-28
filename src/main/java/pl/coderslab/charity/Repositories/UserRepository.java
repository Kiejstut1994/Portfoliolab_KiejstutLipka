package pl.coderslab.charity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Classes.Role;
import pl.coderslab.charity.Classes.User;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u.username from User u")
    List<String> emails();
    @Query("SELECT u from User u where u.username=:username ")
    User userveryf(String username);
    @Query("SELECT u from User u where u.role.id=1")
    List<User> usersnotadmin();
    @Query("SELECT u from User u where u.role.id=2")
    List<User> usersadmin();
}