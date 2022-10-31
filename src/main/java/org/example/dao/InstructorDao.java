package org.example.dao;

import org.example.model.Instructor;

import java.util.List;

public interface InstructorDao {
    void saveInstructor(Instructor instructor);

    Instructor updateInstructor(Long id,Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long courseId);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long instructorId, Long courseId);


}
