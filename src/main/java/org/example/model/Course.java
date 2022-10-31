package org.example.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private int duration;

    private LocalDate createAt;

    private String imageLink;

    private String description;

    @OneToMany(cascade = ALL, fetch = EAGER)
    private List<Lesson> lessons;

    public void addLesson(Lesson lesson){
        lessons.add(lesson);

    }

    @ManyToMany(cascade = {DETACH,MERGE, PERSIST, REFRESH}, fetch = EAGER)
    @JoinTable(name = "course_instructor",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Instructor> instructors=new ArrayList<>();


    public void addInstructor(Instructor instructor) {
        System.out.println(instructors.add(instructor));
    }

    public Course(String courseName, int duration, LocalDate createAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", createAt=" + createAt +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                ", lessons=" + lessons +
                ", instructors=" + instructors +
                '}';
    }
}
