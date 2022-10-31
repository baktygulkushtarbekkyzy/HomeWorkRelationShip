package org.example.service;

import org.example.model.Task;

import java.util.List;

public interface TaskService {
    void saveTask(Long lessonId, Task task);

    Task updateTask(Long id, Task task);

    List<Task> getAllTaskByLessonId(Long lessonId);

    void deleteTaskById(Long id);
}
