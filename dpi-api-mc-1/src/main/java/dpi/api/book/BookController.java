package dpi.api.book;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dpi.api.chapter.Chapter;






@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

//	@RequestMapping("/test")
//	public String getTest() {
//		return bookService.getTest();
//	}
		@RequestMapping("/books/{id}")
		public Book getBook(@PathVariable int id) {
			return bookService.getBook(id);
		}
		
		@RequestMapping("/books")
		public List<Book> getAllBooks() {
			return bookService.getAllBooks();
		}
		
//		%20 as space in url
		@RequestMapping("/books/search/{title}")
		public List<Book> searchByTitleLike(@PathVariable String title) {
			return bookService.searchByTitleLike(title);
		}
		
		@RequestMapping(method = RequestMethod.POST, value = "/books")
		public void addCourse(@RequestBody Book book) {
			bookService.addBook(book);
		}
		
		@RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
		public void updateCourse(@RequestBody Book book, @PathVariable int id) {
			bookService.updateBook(book, id);
		}
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
		public void deleteCourse( @PathVariable int id) {
			bookService.deleteBook(id);
		}
		
		
		
		
		
		
	
		
}
