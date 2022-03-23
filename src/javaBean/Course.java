package javaBean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_table")
public class Course {

    @Id
    @Column(name = "course_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseNo;

    private String courseName;

    @ManyToMany(targetEntity = Student.class)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "course_no", referencedColumnName = "course_no"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
    private Set<Student> students= new HashSet<>();

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public Course(){ }

    public Course(String courseName){
        this.courseName = courseName;
    }

    public Course(Integer courseNo, String courseName){
        this.courseNo = courseNo;this.courseName = courseName;
    }

}

