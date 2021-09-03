package dpi.api.category;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dpi.api.book.Book;
import dpi.api.book.BookRepository;
import dpi.api.book.BookService;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookService bookService;

	
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;
	}
	
	public List<Book> getBooksInCategory(int id){
		return new ArrayList<Book>(categoryRepository.findById(id).get().getBooks());
	}

	public List<Category> getCategoriesInBook(int bookId) {
		List<Category> categories = new ArrayList<>();
		List<Category> selected = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		for (Category c : categories) {
			if (c.getBooks().contains(bookService.getBook(bookId))){
				selected.add(c);
			}
		}
		return selected;
	}

	public void addCategory(Category category) {
		categoryRepository.save(category);
		
	}

	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	public Category getCategory(int id) {
		return categoryRepository.findById(id).get();
	}

	public void updateCategoriesForBook(String[] categoryString, int bookId) {
		
		List<Category> categories = new ArrayList<>();
		for (int i = 0; i < categoryString.length; i++) {
			System.out.println(categoryString[i]);
			categories.add(getCategory(Integer.parseInt(categoryString[i])));
		}
		
		
		
		
		
		for (Category c : categories) {
			System.out.println(c.getName());
			Book b = bookService.getBook(bookId);
//			b.getCategories().add(c);
//			bookRepository.save(b);
 			c.getBooks().add(bookService.getBook(bookId));
			categoryRepository.save(c);
		}
	}
	
	
}
