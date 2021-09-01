package dpi.api.page;

import java.util.List;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PageRepository extends CrudRepository<Page, Integer> { 
	public List<Page> findByChapterId(int chapterId);
}
