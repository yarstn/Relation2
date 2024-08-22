package com.example.school.Service;

import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Repository.CourseRepo;
import com.example.school.Repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepo courseRepo;
    private final TeacherRepo teacherRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public void updateCourse(Integer id, Course course) {
        Course course1 = courseRepo.findByid(id);
        if (course1 == null) {
            throw new RuntimeException("Course not found");
        }
        course1.setName(course.getName());
        courseRepo.save(course1);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepo.findByid(id);
        if (course == null) {
            throw new RuntimeException("Course not found");
        }
        courseRepo.delete(course);
    }

    public void assignTeacher(Integer courseId, Integer teacherId) {
        Course course = courseRepo.findByid(courseId);
        Teacher teacher = teacherRepo.findByid(teacherId);
        if (teacher == null || course == null) {
            throw new RuntimeException("Teacher or course not found");
        }
        course.setTeacher(teacher);
        courseRepo.save(course); // Save the course

    }
    public Teacher getTeacherById(Integer teacherId) {
     Teacher teacher = teacherRepo.findByid(teacherId);
     if (teacher == null) {
         throw new RuntimeException("Teacher not found");
     }
     return teacher;
    }

    public String getTeacherNameByCourseId(Integer courseId) {
        Course course = courseRepo.findByid(courseId);
        if (course == null) {
            throw new RuntimeException("Course not found");
        }

        Teacher teacher = course.getTeacher();
         if (teacher == null) {
            throw new RuntimeException("No teacher assigned to this course");
        }
       return teacher.getName();
    }



}

