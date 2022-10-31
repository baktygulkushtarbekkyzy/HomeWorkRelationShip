package org.example.daoImpl;

import jakarta.persistence.Query;
import org.example.config.DataBaseConfig;
import org.example.dao.LessonDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonImpl implements LessonDao {
    private EntityManagerFactory entityManagerFactory = DataBaseConfig.createEntityManagerFactory();

    public void saveLesson(Long courseId, Lesson lesson) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Course course = entityManager.find(Course.class, courseId);
        course.addLesson(lesson);
        lesson.setCourse(course);
        entityManager.persist(lesson);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Lesson updateLesson(Long id, Lesson lesson) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Lesson lesson1 = entityManager.find(Lesson.class, id);
        lesson1.setId(id);
        lesson1.setName(lesson.getName());
        lesson1.setVideoLink(lesson.getVideoLink());
        lesson1.setCourse(lesson.getCourse());
        lesson1.setTasks(lesson.getTasks());
        entityManager.merge(lesson1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson1;
    }

    public Lesson getLessonById(Long id) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Lesson lesson = entityManager.find(Lesson.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    public List<Lesson> getLessonByCourseId(Long courseId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, courseId);
        List<Lesson> lessons=course.getLessons();


        entityManager.getTransaction().commit();
        entityManager.close();
        return lessons ;
    }
}
