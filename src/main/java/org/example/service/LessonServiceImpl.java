package org.example.service;

import org.example.dao.LessonDao;
import org.example.daoImpl.LessonImpl;
import org.example.model.Lesson;

import java.util.List;

public class LessonServiceImpl implements LessonService{
    LessonDao lessonDao=new LessonImpl();

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        lessonDao.saveLesson(courseId,lesson);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        return lessonDao.updateLesson(id,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long courseId) {
        return lessonDao.getLessonByCourseId(courseId);
    }
}
