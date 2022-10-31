package org.example;

import org.example.config.DataBaseConfig;
import org.example.dao.InstructorDao;
import org.example.dao.LessonDao;
import org.example.dao.TaskDao;
import org.example.daoImpl.CourseImpl;
import org.example.daoImpl.InstructorImpl;
import org.example.daoImpl.LessonImpl;
import org.example.daoImpl.TaskImpl;
import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Lesson;
import org.example.model.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        DataBaseConfig.creatSessionFactory();
        CourseImpl courseDao = new CourseImpl();
        InstructorDao instructorDao = new InstructorImpl();
        LessonDao lessonDao = new LessonImpl();
        TaskDao taskDao = new TaskImpl();


        Course course1 = new Course("java", 9, LocalDate.now(), "image", "baku is hardworking student");
        Course course2 = new Course("java script", 9, LocalDate.now(), "link", "baku is clever student");


        Instructor instructor1 = new Instructor("Muhammed", "Batyrov", "nuhammedBatyrov@gmail.com", "07074112028");
        Instructor instructor2 = new Instructor("Janarbek", "Abdurasulov", "nuhammedBatyrov@gmail.com", "07074112028");


        Lesson lesson1 = new Lesson("Chemistry", "http//996787/chemistry");
        Lesson lesson2 = new Lesson("Mathematic", "http//84365mathematic");


        Task task1 = new Task("Execise 1", "29.10.22", "task");
        Task task2 = new Task("Execise 2", "30.10.22", "task");

        while (true) {
            System.out.println("""
                    
                    
                    """);
            System.out.println("""
                    Kanchanchy orundagy konstantalar jonundo maalymat bilginiz kelet
                    1- Course
                    2- Instructor
                    3- Lesson 
                    4- Task   """);
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();

            if (a == 1) {
                System.out.println("""
                        Course tun kaisy metodun ishtetuunu kaalaisyz
                        1- saveCourse
                        2- getCourseById
                        3- getAllCourse
                        4- updateCourse
                        5- deleteCourseById
                        6- getCourseByName""");
                int b = scanner.nextInt();
                switch (b) {
                    case 1:
                        courseDao.saveCourse(course1);
                        break;
                    case 2:
                        System.out.println(courseDao.getCourseById(1L));
                        break;
                    case 3:
                        courseDao.getAllCourse().forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println(courseDao.updateCourse(1L, course2));
                        break;
                    case 5:
                        courseDao.deleteCourseById(1L);
                        break;
                    case 6:
                        try {
                            System.out.println(courseDao.getCourseByName("java script"));
                        } catch (Exception e) {
                            System.out.println("Myndai kurs data base da jok!");
                        }
                        break;
                    default:
                        System.out.println("Bashka tandoo sanyn jaza albaisyz ");
                }
            } else if (a == 2) {
                System.out.println("""
                        Instructor dun kaisy metodun ishtetuunu kaalaisyz
                        1- saveInstructor
                        2- updateInstructor
                        3- getInstructorById
                        4- getInstructorByCourseId
                        5- deleteInstructorById
                        6- assignInstructorToCourse""");
                int c = scanner.nextInt();
                switch (c) {
                    case 1:
                        instructorDao.saveInstructor(instructor1);
                        break;
                    case 2:
                        instructorDao.updateInstructor(1L, instructor2);
                        break;
                    case 3:
                        System.out.println(instructorDao.getInstructorById(1L));
                        break;
                    case 4:
                        System.out.println(instructorDao.getInstructorByCourseId(1L));
                        break;
                    case 5:
                        instructorDao.deleteInstructorById(1L);
                        break;
                    case 6:
                        try {
                            instructorDao.assignInstructorToCourse(1L, 1L);
                        } catch (Exception e) {
                            System.out.println("id lerin tuura beriniz!!!");
                        }
                        break;
                    default:
                        System.out.println("Bashka tandoo sanyn jaza albaisyz ");
                }
            } else if (a == 3) {
                System.out.println("""
                        Lesson dun kaisy metodun ishtetuunu kaalaisyz
                         1- saveLesson
                         2- updateLesson
                         3- getLessonById
                         4- getLessonByCourseId
                         """);
                int w = scanner.nextInt();
                switch (w) {
                    case 1:
                        lessonDao.saveLesson(1L, lesson1);
                        break;
                    case 2:
                        lessonDao.updateLesson(1L, lesson2);
                        break;
                    case 3:
                        System.out.println(lessonDao.getLessonById(1L));
                        break;
                    case 4:
                        System.out.println(lessonDao.getLessonByCourseId(1L));
                        break;
                    default:
                        System.out.println("Bashka tandoo sanyn jaza albaisyz ");
                }
            } else if (a == 4) {
                System.out.println("""
                        Task tyn kaisy metodun ishtetuunu kaalaisyz
                         1- saveTask
                         2- updateTask
                         3- getAllTaskByLessonId
                         4- deleteTaskById
                         """);
                int i = scanner.nextInt();
                switch (i) {
                    case 1:
                        taskDao.saveTask(1L, task1);
                        break;
                    case 2:
                        taskDao.updateTask(1L, task2);
                        break;
                    case 3:
                        System.out.println(taskDao.getAllTaskByLessonId(1L));
                        break;
                    case 4:
                        taskDao.deleteTaskById(1L);
                        break;
                    default:
                        System.out.println("Bashka tandoo sanyn jaza albaisyz ");
                }
            } else {
                System.out.println("Sizde 4 gana komanda bar!!!");
            }
        }
    }
}
