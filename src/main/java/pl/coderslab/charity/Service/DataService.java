package pl.coderslab.charity.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Classes.*;
import pl.coderslab.charity.Repositories.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataService {

    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;


    public DataService(CategoryRepository categoryRepository, DonationRepository donationRepository, InstitutionRepository institutionRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void loadData() {
        //role
        if(roleRepository.findAll().size() == 0) {
            roleRepository.saveAll(Arrays.asList(
                    new Role("USER"),
                    new Role("ADMIN")
            ));
        }
        //CategoryCreate
        if(categoryRepository.findAll().size() == 0) {
            categoryRepository.saveAll(Arrays.asList(
                    new Category(1L,"ubrania, które nadają się do ponownego użycia"),
                    new Category(2L,"ubrania, do wyrzucenia"),
                    new Category(3L,"zabawki"),
                    new Category(4L,"ubrania"),
                    new Category(5L,"inne")
            ));

        }
        if(institutionRepository.findAll().size() == 0) {
            institutionRepository.saveAll(Arrays.asList(
                    new Institution(1L,"Fundacja \"Dbam o Zdrowie\"","Cel i misja: Pomoc dzieciom z ubogich rodzin."),
                    new Institution(2L,"Fundacja \"A kogo\"", "Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki."),
                    new Institution(3L,"Fundacja \"Dla dzieci\"", "Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej."),
                    new Institution(4L,"Fundacja \"Bez domu\"", "Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania.")
            ));
        }
        if(userRepository.findAll().size() == 0) {
            userRepository.saveAll(Arrays.asList(
                    //login: user@user.com / pass: 12345
                    new User(1L,"UserFirstName","UserLastName","user@user.com",
                            "$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e",true,
                            roleRepository.findByName("USER")),
                    //login: admin@admin.com / pass: 12345
                    new User(2L,"AdminFirstName","AdminLastName","admin@admin.com",
                            "$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e",true,
                            roleRepository.findByName("ADMIN"))
            ));
        }

//        if(donationRepository.findAll().size() == 0) {
//            donationRepository.saveAll(Arrays.asList(
//                    new Donation(
//                            1L,20,"Mickiewicza 0","Katowice",555111555,"40-092",LocalDate.parse("2022-06-19"),
//                            LocalTime.parse("18:00"),"2nd floor", Arrays.asList(categoryRepository.getById(1L),categoryRepository.getById(3L)),
//                            institutionRepository.findAll().get(0),
//                            userRepository.findAll().get(0)
//                    )
//            ));
//        }
    }
}
