package dpi.api.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dpi.api.chapter.ChapterService;

@Service
public class PageService {
	
	@Autowired
	private PageRepository pageRepository;
	
	@Autowired
	private ChapterService chapterService;
	
	public void updatePage(Page page) {
		pageRepository.save(page);
	}
	
	public void addPage(Page page, int chapterId) {
		page.setChapter(chapterService.getChapter(chapterId));
		pageRepository.save(page);
	}
	
	public void deletePage(int id) {
		pageRepository.deleteById(id);
	}
	
	public Page getPage(int id) {
		return pageRepository.findById(id).get();
	}
	
	public List<Page> getPagesInChapter(int chapterId){
		return pageRepository.findByChapterId(chapterId);
	}
	
	public void handlePageData(List<Page> pages, int chapterId) {
		for (int i = 0; i < pages.size(); i++) {
			Page page = pages.get(i);
			if (page.getId() > 0) {
				page.setChapter(chapterService.getChapter(chapterId));
				updatePage(page);
			}else {
				addPage(page, chapterId);
			}
		}
	}
	
}
