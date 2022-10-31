package org.example.daoImpl;

import org.example.config.DataBaseConfig;
import org.example.dao.TaskDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.model.Lesson;
import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskImpl implements TaskDao {
    private EntityManagerFactory entityManagerFactory= DataBaseConfig.createEntityManagerFactory();


    public void saveTask(Long lessonId, Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        lesson.addTask(task);
//        task.setLesson(lesson);
        entityManager.persist(task);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Task updateTask(Long id, Task task) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Task task1 = entityManager.find(Task.class, id);
        task1.setId(id);
        task1.setName(task.getName());
        task1.setDeadLine(task.getDeadLine());
        task1.setTask(task.getTask());
//        task1.setLesson(task.getLesson());
        entityManager.merge(task1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task1;
    }

    public List<Task> getAllTaskByLessonId(Long lessonId) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List <Task> tasks = entityManager.createQuery("select t from Task t ").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    public void deleteTaskById(Long id) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
