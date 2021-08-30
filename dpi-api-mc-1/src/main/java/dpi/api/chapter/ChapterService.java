package dpi.api.chapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dpi.api.book.Book;
import dpi.api.book.BookRepository;
import dpi.api.book.BookService;

@Service
public class ChapterService {
	
	@Autowired
	private ChapterRepository chapterRepository;
	
	@Autowired
	private BookService bookService;
	
	public String getTest() {
		return "test";
	}
	
	public Chapter getChapter(int id) {
		return chapterRepository.findById(id).get();
	}
	
	public List<Chapter> getChaptersInBook(int bookId){
		List<Chapter> chapters = new ArrayList<>();
		
		chapterRepository.findByBookId(bookId).forEach(chapters::add);
		return chapters;
	}
	
	public void addChapter(Chapter chapter, int bookId) {
		bookService.getBook(bookId).addToChapters(chapter);
		chapter.setBook(bookService.getBook(bookId));
		
		chapterRepository.save(chapter);
	}
	
//	Chapter must include id
	public void updateChapter(Chapter chapter) {
		chapterRepository.save(chapter);
	}
	
	public void deleteChapter(int id) {
		chapterRepository.deleteById(id);
		
	}
	
	public void adjustChaptersInBook(List<Chapter> chapters, int bookId){
		System.out.println("Called");
		for (int i = 0; i < chapters.size(); i++) {
			Chapter chapter = chapters.get(i);
//			Maybe needed
			System.out.println(chapter.getId());
			
//			chapterRepository.save(chapter);
			if (chapter.getId() > 0) {
				chapter.setBook(bookService.getBook(bookId));
				updateChapter(chapter);
			}else {
				addChapter(chapter, bookId);
			}
		}
	}
}
