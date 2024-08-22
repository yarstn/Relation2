package com.example.school.Repository;

import com.example.school.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CourseRepo extends JpaRepository<Course, Integer> {
    Course findByid(Integer id);

}
