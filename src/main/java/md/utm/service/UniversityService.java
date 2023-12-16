package md.utm.service;

import java.util.List;
import md.utm.entity.University;
import md.utm.exception.AlreadyExistException;
import md.utm.exception.NotFoundException;
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

    public University findById(Long id) {
        if(!universityRepository.existById(id)) {
            throw new NotFoundException("Not found University with id: " + id);
        }

        return universityRepository.findById(id);
    }

    public void create(University university) {
        if(universityRepository.existByShortName(university.getShortName())) {
            throw new AlreadyExistException(
                    "Already exist university with shortName: " + university.getShortName());
        }

        universityRepository.create(university);
    }

    public void update(Long id, University university) {
        universityRepository.update(id, university);
    }

    public void delete(Long id) {
        universityRepository.delete(id);
    }
}
