package com.springRest.springRest.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springRest.springRest.CourseEntity.Course;
import com.springRest.springRest.CourseRepo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepo courseRepo;

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		List<Course> list = courseRepo.findAll();
		return list;
	}

	@Override
	public Course getCourse(Long courseId) {
		// TODO Auto-generated method stub
		return courseRepo.findById(courseId).orElseThrow(()-> new RuntimeException("Course not found course id "+courseId));
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		Course addedCourse = courseRepo.save(course);
		return addedCourse;
	}

	@Override
	public ResponseEntity<HttpStatus> deleteCourse(Long courseId) {
		// TODO Auto-generated method stub
		courseRepo.deleteById(courseId);
		return null;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		Course savedCourse = courseRepo.save(course);
		return savedCourse;
	}

}
