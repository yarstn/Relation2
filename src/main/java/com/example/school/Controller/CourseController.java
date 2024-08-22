package com.example.school.Controller;

import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/course")
@RestController //json
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return ResponseEntity.ok("Course added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.ok("Course updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted");
    }
    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity assignCourse(@PathVariable Integer courseId, @PathVariable Integer teacherId) {
        courseService.assignTeacher(courseId, teacherId);
        return ResponseEntity.ok("Course assigned");
    }
    @GetMapping("/{teacherId}")
    public ResponseEntity getTeacherById(@PathVariable Integer teacherId) {
        Teacher teacher = courseService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacher);
    }
    @GetMapping("/{courseId}/teacher")
    public ResponseEntity getTeacherNameByCourseId(@PathVariable Integer courseId) {
       courseService.getTeacherNameByCourseId(courseId);
        return ResponseEntity.ok(courseId);
    }
}
