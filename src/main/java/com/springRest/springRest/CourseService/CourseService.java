package com.springRest.springRest.CourseService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springRest.springRest.CourseEntity.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	public Course getCourse(Long courseId);
	
	public Course addCourse(Course course);
	
	public ResponseEntity<HttpStatus>deleteCourse(Long courseId);
	
	public Course updateCourse(Course course);
}
