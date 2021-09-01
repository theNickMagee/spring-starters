package dpi.api.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dpi.api.book.Book;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;
	}
	
	public List<Book> getBooksInCategory(int id){
		return new ArrayList<Book>(categoryRepository.findById(id).get().getBooks());
	}
	
	
}
