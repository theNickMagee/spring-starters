package dpi.api.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {
	

	@Autowired
	private BookRepository bookRepository;
	
	public String getTest() {
		return "test";
	}
	
	public Book getBook(int id) {
		return bookRepository.findById(id).get();
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}
	
	public Book addBook(Book book) {
		bookRepository.save(book);
		System.out.println(book);
		return book;
	}
	
	public void updateBook(Book book, int id) {
		book.setId(id);
		bookRepository.save(book);
	}
	
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
		
	}
	
	public List<Book> searchByTitleLike(String title){
		return bookRepository.searchByTitleLike(title);
		
	}

//	public List<Book> findByTitleLike(String title){
//		
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
