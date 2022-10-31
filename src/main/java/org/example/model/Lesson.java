package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String videoLink;

    @ManyToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH},fetch = FetchType.LAZY)
    private Course course;

    @OneToMany(cascade = ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "lesson_id")
    private List<Task> tasks;

    public void addTask(Task task){
        tasks.add(task);
    }

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;

    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }
}
