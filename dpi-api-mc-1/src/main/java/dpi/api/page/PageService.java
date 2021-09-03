package dpi.api.page;

import java.util.ArrayList;
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
		List<Integer> newPageIds = new ArrayList<>();
		
		List<Page> oldPages = getPagesInChapter(chapterId);
		
		for (int i = 0; i < pages.size(); i++) {
			Page page = pages.get(i);
			if (page.getId() > 0) {
				page.setChapter(chapterService.getChapter(chapterId));
				newPageIds.add(page.getId());
				updatePage(page);
			}else {
				addPage(page, chapterId);
			}
		}
		
		//if there is an old id not in the new ones, delete page
		for (Page p : oldPages) {
			if (!newPageIds.contains(p.getId())) {
				deletePage(p.getId());
			}
		}
		
		
	}
	
}
