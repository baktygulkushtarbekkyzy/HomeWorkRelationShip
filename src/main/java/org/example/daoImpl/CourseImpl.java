package org.example.daoImpl;

import org.example.config.DataBaseConfig;
import org.example.dao.CourseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.model.Course;

import java.util.List;

public class CourseImpl implements CourseDao {
   private EntityManagerFactory entityManagerFactory=DataBaseConfig.createEntityManagerFactory();

    public void saveCourse(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(course);
        System.out.println("Course iygiliktuu koshuldu!");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return course;
    }

    public List<Course> getAllCourse() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Course> courses = entityManager.createQuery("select  c from Course c order by createAt").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return courses;
    }

    public Course updateCourse(Long id, Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course1 = entityManager.find(Course.class, id);
            course1.setCourseName(course.getCourseName());
            course1.setId(id);
            course1.setDuration(course.getDuration());
            course1.setCreateAt(course.getCreateAt());
            course1.setImageLink(course.getImageLink());
            course1.setDescription(course.getDescription());
//            course1.setLesson(course.getLesson());
            course1.setInstructors(course.getInstructors());
        entityManager.merge(course1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course1;
    }

    public void deleteCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Course getCourseByName(String name) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course name1 = (Course) entityManager.createQuery("select c from Course c where c.courseName =: name").setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return name1;
    }
}
