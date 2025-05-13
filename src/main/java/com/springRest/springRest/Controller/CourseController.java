package com.springRest.springRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.CourseEntity.Course;
import com.springRest.springRest.CourseService.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to Course application";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		List<Course> list = courseService.getCourses();
		return list;
	}
	
	@GetMapping("/course/{courseid}")
	public Course getCourse(@PathVariable("courseid") Long courseId) {
		Course course = courseService.getCourse(courseId);
		return course;
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		Course addedCourse = courseService.addCourse(course);
		return addedCourse;
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseid}")
	ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseid){
		try {
			courseService.deleteCourse(Long.parseLong(courseid));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
