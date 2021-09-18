package dpi.api.domain;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dpi.api.chapter.Chapter;



@RestController
public class DomainController {
	
	@Autowired
	private DomainService domainService;

//	@RequestMapping("/test")
//	public String getTest() {
//		return bookService.getTest();
//	}
		@RequestMapping("/domains/{id}")
		public Domain getDomain(@PathVariable int id) {
			return domainService.getDomain(id);
		}
		
		@RequestMapping("/domains/{id}/name")
		public String getDomainName(@PathVariable int id) {
			return domainService.getDomainName(id);
		}
		
		@RequestMapping("/domains")
		public List<Domain> getAllDomains() {
			return domainService.getAllDomains();
		}
		
		
		@RequestMapping(method = RequestMethod.POST, value = "/domains")
		public void addDomain(@RequestBody Domain domain) {
			domainService.createDomain(domain);
		}
		
		@RequestMapping(method = RequestMethod.PUT, value = "/domains/{id}")
		public void updateDomain(@RequestBody Domain domain, @PathVariable int id) {
			domainService.updateDomain(domain, id);
		}
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/domains/{id}")
		public void deleteDomain( @PathVariable int id) {
			domainService.deleteDomain(id);
		}

		
}