package io.javabrains.springbootquickstart.courses;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> { 
	
	
}
