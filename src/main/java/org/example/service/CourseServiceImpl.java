package org.example.service;

import org.example.dao.CourseDao;
import org.example.dao.InstructorDao;
import org.example.daoImpl.CourseImpl;
import org.example.daoImpl.InstructorImpl;
import org.example.model.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseImpl();

    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {

        return courseDao.getAllCourse();
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return courseDao.updateCourse(id, course);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseDao.deleteCourseById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDao.getCourseByName(name);
    }
}
