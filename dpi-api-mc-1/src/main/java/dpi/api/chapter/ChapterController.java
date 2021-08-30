package dpi.api.chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dpi.api.book.BookService;


@RestController
public class ChapterController {
	
	@Autowired
	private ChapterService chapterService;

	
	
	//create chapter from bookId and data
	@RequestMapping(method = RequestMethod.POST, value = "/books/{bookId}/chapters")
	public void addChapter(@RequestBody Chapter chapter, @PathVariable int bookId) {
//		chapter.setBook_id(bookId);
		chapterService.addChapter(chapter, bookId);
	}
	
	//create multiple chapters
	@RequestMapping(method = RequestMethod.POST, value = "/books/{bookId}/manyChapters")
	public void addManyChapters(@RequestBody List<Chapter> chapters, @PathVariable int bookId) {
		chapterService.adjustChaptersInBook(chapters, bookId);
	}
	
	@RequestMapping("/books/{bookId}/chapters")
	public List<Chapter> getChaptersInBook(@PathVariable int bookId){
//		return bookService.getBook(bookId).getChapters();
		System.out.println("called");
		 return chapterService.getChaptersInBook(bookId);
	}
		
	//get chapters in book
//	@RequestMapping("/books/{bookId}/chapters")
//	public List<Chapter> getChaptersInBook(@PathVariable int bookId){
////		/return bookService.getBook(bookId).getChapters();
//		 return chapterService.getChaptersInBook(bookId);
//	}
	
	//update chapter with chapter data
	
	
	
	//delete chapter 
	
//	@RequestMapping("/topics/{id}/courses")
//	public List<Course> getAllCourses(@PathVariable String id) {
//		return courseService.getAllCourses(id);
//	}
//	
//	@RequestMapping("/topics/{topicId}/courses/{id}")
//	public Course getCourse(@PathVariable String id) {
//		return courseService.getCourse(id);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
//	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
//		course.setTopic(new Topic(topicId, "", ""));
//		courseService.addCourse(course);
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
//	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
//		courseService.updateCourse(course);
//	}
//	
//	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
//	public void deleteCourse( @PathVariable String id) {
//		courseService.deleteCourse(id);
//	}
}
