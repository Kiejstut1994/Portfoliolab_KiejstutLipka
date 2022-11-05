package pl.coderslab.charity.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Classes.Institution;
import pl.coderslab.charity.Repositories.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public Institution findbyid(Long id){
        return institutionRepository.getById(id);
    }
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }
    public void deleteinstitution(Institution institution){
        institutionRepository.delete(institution);
    }

}