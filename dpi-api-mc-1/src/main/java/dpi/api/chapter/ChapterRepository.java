package dpi.api.chapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChapterRepository extends CrudRepository<Chapter, Integer> { 
	
	public List<Chapter> findByBookId(int bookId);

}
