package dpi.api.book;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Integer> { 
	
	@Query("SELECT m FROM Book m WHERE m.title LIKE %:title%")
	List<Book> searchByTitleLike(@Param("title") String title);

}
