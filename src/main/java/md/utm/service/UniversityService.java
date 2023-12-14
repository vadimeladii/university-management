package md.utm.service;

import java.util.List;
import md.utm.entity.University;
import md.utm.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public University fingById(Long id) {
        return universityRepository.findById(id);
    }

    public void create(University university) {
        universityRepository.create(university);
    }

    public void update(Long id, University university) {
        universityRepository.update(id, university);
    }

    public void delete(Long id) {
        universityRepository.delete(id);
    }
}
