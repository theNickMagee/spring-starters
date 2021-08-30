package dpi.api.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {
	

	
	public String getTest() {
		return "test";
	}
	
	public List<Book> getAllCourses(String topicId){
		List<Book> books = new ArrayList<>();
//		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return books;
	}
	
//	public Course getCourse(String id) {
//		return courseRepository.findById(id).get();
//	}
//
//	public void addCourse(Course course) {
//		courseRepository.save(course); 
//	}
//
//	public void updateCourse(Course course) {
//		courseRepository.save(course);
//		
//	}
//
//	public void deleteCourse(String id) {
//		courseRepository.deleteById(id);
//		
//	}
}
