package dpi.api.chapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> { 
	
	public List<Chapter> findByBookId(int bookId);

}
