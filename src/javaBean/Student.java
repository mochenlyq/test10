package javaBean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sex;

    private String name;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_no", referencedColumnName = "course_no"))
    private Set<Course> courses = new HashSet<>();

    public void setCourses(Set<Course> courses) { this.courses = courses; }

    public void setSex(String sex) { this.sex = sex; }

    public String getSex() {
        return sex;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setId(Integer id) { this.id = id; }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student(){}

}
