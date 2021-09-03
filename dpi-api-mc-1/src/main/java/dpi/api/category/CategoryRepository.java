package dpi.api.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dpi.api.book.Book;

public interface CategoryRepository extends JpaRepository<Category, Integer> { 
	
	Category findByName(@Param("name") String name);
}