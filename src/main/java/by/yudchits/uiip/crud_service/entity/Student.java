package by.yudchits.uiip.crud_service.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotBlank(message = "The field can't be empty")
    @Size(min = 1, max = 25, message = "The length of a name must be between 1 and 25")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "The field can't be empty")
    @Size(min = 1, max = 25, message = "The length of a name must be between 1 and 25")
    private String surname;

    @Column(name = "course")
    @Min(value = 1, message = "A course can't be less than 1")
    @Max(value = 6, message = "A course can't be more than 6")
    private int course;

    @Column(name = "email")
    @Pattern(regexp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", message = "Incorrect email address")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Student() {
    }

    public Student(String name, String surname, int course, String email) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
