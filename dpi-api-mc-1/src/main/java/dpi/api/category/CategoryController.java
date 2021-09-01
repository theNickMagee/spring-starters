package dpi.api.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dpi.api.book.Book;


@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	//GET ALL CATEGORIES
	@RequestMapping("/categories")
	public List<Category> getAll() {
		return categoryService.getAllCategories();
	}

//	
	//FIND BOOKS IN CATEGORY
	@RequestMapping("/categories/booksin/{id}")
	public List<Book> getBooksInCategory(@PathVariable int id){
		return categoryService.getBooksInCategory(id);
	}

	//GET ALL RELATIONS
	
	//FIND CATEGORY BY NAME

		

	//ADD CATEGORIES FOR BOOK


	//GET CATEGORIES FOR BOOK
	@RequestMapping("/categories/withbook/{bookId}")
	public List<Category> getCategoriesInBook(@PathVariable int bookId){
		return categoryService.getCategoriesInBook(bookId);
	}


	//GET FULL CATEGORY DETAILS FROM ID ARRAY

	//ADD CATEGORIES FOR BOOK

	//ADD NEW CATEGORY

	//DELET CATEGORY
}
