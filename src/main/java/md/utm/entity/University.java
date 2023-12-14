package md.utm.entity;

import java.util.List;
import java.util.Objects;

public class University {

    private Long id;
    private String shortName;
    private String fullName;
    private String address;

    private List<Student> students;

    public University() {
    }

    public University(Long id, String shortName, String fullName, String address) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        University that = (University) o;

        if (!Objects.equals(id, that.id)) {
            return false;
        }
        if (!Objects.equals(shortName, that.shortName)) {
            return false;
        }
        if (!Objects.equals(fullName, that.fullName)) {
            return false;
        }
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
