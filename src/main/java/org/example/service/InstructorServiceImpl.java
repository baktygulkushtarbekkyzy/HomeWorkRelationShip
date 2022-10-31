package org.example.service;

import org.example.dao.InstructorDao;
import org.example.daoImpl.InstructorImpl;
import org.example.model.Instructor;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    InstructorDao instructorDao = new InstructorImpl();

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        return instructorDao.updateInstructor(id, instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long courseId) {
        return instructorDao.getInstructorByCourseId(courseId);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorDao.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorDao.assignInstructorToCourse(instructorId, courseId);
    }
}
