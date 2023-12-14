package md.utm.repository;

import java.util.List;
import md.utm.entity.Student;
import md.utm.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<University> findAll() {
        return jdbcTemplate.query("SELECT * FROM university", (resultSet, rowNum) -> {
            University university = new University();
            university.setId(resultSet.getLong("id"));
            university.setShortName(resultSet.getString("shortName"));
            university.setFullName(resultSet.getString("fullName"));
            university.setAddress(resultSet.getString("address"));
            return university;
        });
    }

    public University findById(Long id) {
        String sql = "SELECT * FROM university where id = ?";

        University university = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new University(
                        rs.getLong("id"),
                        rs.getString("shortName"),
                        rs.getString("fullName"),
                        rs.getString("address")
                ));

        String sqlForStudents = "SELECT * FROM student where universityId = ?";

        List<Student> studentList = jdbcTemplate.query(sqlForStudents, new Object[]{id}, (resultSet, rowNum) -> {
            Student student = new Student();
            student.setIdnp(resultSet.getString("idnp"));
            student.setFirstName(resultSet.getString("fistName"));
            student.setLastName(resultSet.getString("lastName"));
            student.setMedia(resultSet.getDouble("media"));
            student.setEmail(resultSet.getString("email"));
            return student;
        });

        university.setStudents(studentList);

        return university;
    }

    public void create(University university) {
        String sql = "insert into university(shortName, fullName, address) values (?, ?, ?)";

        jdbcTemplate.update(sql, university.getShortName(), university.getFullName(), university.getAddress());
    }

    public void update(Long id, University university) {
        String sql = "update university set shortName = ?, fullName = ?, address = ? where id = ?";

        jdbcTemplate.update(sql, university.getShortName(), university.getFullName(),
                                   university.getAddress(), id);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM university where id = ?";

        jdbcTemplate.update(sql, id);
    }

}
