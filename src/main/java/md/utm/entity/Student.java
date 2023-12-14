package md.utm.entity;

import java.util.Objects;

public class Student {

    private String idnp;
    private String firstName;
    private String lastName;
    private String email;
    private double media;

    public Student() {
    }

    public Student(String idnp, String firstName, String lastName, String email, double media) {
        this.idnp = idnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.media = media;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;

        if (Double.compare(media, student.media) != 0) {
            return false;
        }
        if (!Objects.equals(idnp, student.idnp)) {
            return false;
        }
        if (!Objects.equals(firstName, student.firstName)) {
            return false;
        }
        if (!Objects.equals(lastName, student.lastName)) {
            return false;
        }
        return Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idnp != null ? idnp.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        temp = Double.doubleToLongBits(media);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idnp='" + idnp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", media=" + media +
                '}';
    }
}
