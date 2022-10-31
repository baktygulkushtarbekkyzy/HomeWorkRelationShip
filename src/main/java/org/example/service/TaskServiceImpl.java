package org.example.service;

import org.example.dao.TaskDao;
import org.example.daoImpl.TaskImpl;
import org.example.model.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    TaskDao taskDao = new TaskImpl();

    @Override
    public void saveTask(Long lessonId, Task task) {
        taskDao.saveTask(lessonId, task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskDao.updateTask(id, task);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        return taskDao.getAllTaskByLessonId(lessonId);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskDao.deleteTaskById(id);
    }
}
