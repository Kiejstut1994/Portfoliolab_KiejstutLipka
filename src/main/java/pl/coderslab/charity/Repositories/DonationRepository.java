package pl.coderslab.charity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Classes.Donation;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer sumQuantity();
    @Query("SELECT COUNT(d) FROM Donation d")
    Integer sumDonations();
    @Query("SELECT d FROM Donation d join User u on d.user.id=u.id join Institution i on d.institution.id=i.id where d.user.id=:id")
    List<Donation> mydonation(Long id);
    @Query("SELECT d FROM Donation d join User u on d.user.id=u.id join Institution i on d.institution.id=i.id where (d.user.id=:id and ((d.pickUpDate<function('date_format',current_date ,'%Y-%m-%d')) or (d.pickUpDate=function('date_format',current_date ,'%Y-%m-%d') and d.pickUpTime<function('time_format',current_time,'%H:%i' ) ))) ")
    List<Donation> mypickeddonations(Long id);
    @Query("SELECT d FROM Donation d join User u on d.user.id=u.id join Institution i on d.institution.id=i.id where d.user.id=:id and ((d.pickUpDate>function('date_format',current_date ,'%Y-%m-%d')) or (d.pickUpDate=function('date_format',current_date ,'%Y-%m-%d') and d.pickUpTime>function('time_format',current_time,'%H:%i' ) )) ")
    List<Donation> mynotpickeddonations(Long id);
}