package org.example.daoImpl;

import org.example.config.DataBaseConfig;
import org.example.dao.InstructorDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.model.Course;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorImpl implements InstructorDao {

    private EntityManagerFactory entityManagerFactory = DataBaseConfig.createEntityManagerFactory();

    public void saveInstructor(Instructor instructor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(instructor);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Instructor updateInstructor(Long id, Instructor instructor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setId(id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        instructor1.setCourses(instructor.getCourses());
        entityManager.merge(instructor1);

        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor1;
    }

    public Instructor getInstructorById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Instructor instructor = entityManager.find(Instructor.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return instructor;
    }

    public List<Instructor> getInstructorByCourseId(Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, courseId);
        List<Instructor> instructors = new ArrayList<>(course.getInstructors());
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;
    }

    public void deleteInstructorById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, courseId);
        Instructor instructor1 = entityManager.find(Instructor.class, instructorId);

        List<Instructor> instructors = new ArrayList<>();
        instructors.add(instructor1);
        List<Course> courses = new ArrayList<>();
        courses.add(course);

        instructor1.setCourses(courses);
        course.addInstructor(instructor1);

        entityManager.persist(instructor1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
