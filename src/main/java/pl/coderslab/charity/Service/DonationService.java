package pl.coderslab.charity.Service;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.Classes.Donation;
import pl.coderslab.charity.Repositories.DonationRepository;

import java.security.Principal;
import java.util.List;

@Service
public class DonationService {

    public final DonationRepository donationRepository;


    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;

    }

    public void save(Donation donation, Principal principal) {
        donationRepository.save(donation);
    }

    public Integer countBags() {
        return donationRepository.sumQuantity();
    }
    public Integer countDonations() {
        return donationRepository.sumDonations();
    }
public List<Donation> mydonations(Long id){
        return donationRepository.mydonation(id);
}
public List<Donation> mypiceddonations(Long id){
        return donationRepository.mypickeddonations(id);
}
    public List<Donation> mynotpickeddonations(Long id){
        return donationRepository.mynotpickeddonations(id);
    }
    public Donation findbyid(Long id){
        return donationRepository.getById(id);
    }
}
