package com.springRest.springRest.CourseRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRest.springRest.CourseEntity.Course;

public interface CourseRepo extends JpaRepository<Course,Long>{

}
