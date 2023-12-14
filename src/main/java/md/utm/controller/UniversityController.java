package md.utm.controller;

import java.util.List;
import md.utm.entity.University;
import md.utm.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("university")
public class UniversityController {

    //    Flyway Migration ???

    //    Path - GET /university/{id}
    //    Param - GET /university?id=3&name=24
    //    Body -

    //Rest API
    // CRUD -> CREATE, READ, UPDATE, DELETE
    // POST /university
    // GET /university ; GET /university/{id}
    // PUT /university/{id}
    // DELETE /university/{id}


    // 3 nivele
    // Controller (primul nivel)
    // Service  (nivelul mijlociu)
    // Repositoriu (nivelul 3)

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<University> findAll() {
        return universityService.findAll();
    }

    @GetMapping("/{id}")
    public University findById(@PathVariable Long id) {
        return universityService.fingById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody University university) {
        universityService.create(university);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody University university) {
        universityService.update(id, university);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        universityService.delete(id);
    }
}
