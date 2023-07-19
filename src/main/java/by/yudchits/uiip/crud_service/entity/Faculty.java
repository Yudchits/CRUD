package by.yudchits.uiip.crud_service.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotBlank(message = "The field can't be empty")
    @Length(min = 2, max = 10, message = "The length of a name must be between 2 and 10")
    private String name;

    @Column(name = "number_of_students")
    @Min(value = 0, message = "A number of students can't be less than 0")
    @Max(value = Integer.MAX_VALUE, message = "A number of students can't be more than 2147483647")
    private int numberOfStudents;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
    private List<Student> students;

    public Faculty() {
    }

    public Faculty(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
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

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
