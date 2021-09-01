package dpi.api.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PageController { 

			@Autowired
			private PageService pageService;
	
			//get pages in chapter
			@RequestMapping("/books/{bookId}/chapters/{chapterId}/pages")
			public List<Page> getPages(@PathVariable int chapterId) {
				return pageService.getPagesInChapter(chapterId);
			}
			
			//post page data from entire chapter
			@RequestMapping(method = RequestMethod.POST, value = "/books/{bookId}/chapters/{chapterId}/pages")
			public void postPageData(@RequestBody List<Page> pages, @PathVariable int chapterId) {
				 pageService.handlePageData(pages, chapterId);
			}
			
			
}
