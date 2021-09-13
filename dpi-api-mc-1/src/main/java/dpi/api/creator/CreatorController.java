package dpi.api.creator;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dpi.api.book.Book;
import dpi.api.book.BookService;
import dpi.api.creator_role.CreatorRole;

@RestController
public class CreatorController {

	@Autowired
	private CreatorService creatorService;
	
	//GET ALL CREATORS
	@RequestMapping("/creators")
	public List<Creator> getAllCreators(){
		return creatorService.getAllCreators();
	}
	
	//GET CREATORS FOR BOOK
	@RequestMapping("/book/{bookId}/creators")
	public List<Creator> getCreatorsForBook(@PathVariable int bookId){
		return creatorService.getCreatorsForBook(bookId);
	}
	
	//GET BOOKS CREATOR CONTRIBUTED TO
	@RequestMapping("/creator/{creatorId}/books")
	public List<Creator> getBooksOfCreator(@PathVariable int creatorId){
		return creatorService.getBooksOfCreator(creatorId);
	}
	
	//GET ALL CREATORS OF A DOMAIN
	@RequestMapping("/domain/{domainId}/creators")
	public List<Creator> getCreatorsInDomain(@PathVariable int domainId){
		return creatorService.getCreatorsInDomain(domainId);
	}
	
	
	@RequestMapping("/creator/search/{name}")
	public List<Book> searchByTitleLike(@PathVariable String name) {
		return creatorService.searchByNameLike(name);
	}
	
	
	//CREATE NEW CREATOR
	@RequestMapping(method = RequestMethod.POST, value = "/creators")
	public Creator createCreator(@RequestBody Book book) {
		return creatorService.createCreator(book);
	}
	
	//UPDATE CREATOR
	@RequestMapping(method = RequestMethod.PUT, value = "/creators/{id}")
	public void updateBook(@RequestBody Creator creator, @PathVariable int id) {
		creatorService.updateCreator(creator, id);
	}
	
	//DELETE CREATOR
	@RequestMapping(method = RequestMethod.DELETE, value = "/creators/{id}")
	public void deleteCreator( @PathVariable int id) {
		creatorService.deleteCreator(id);
	}
	
	//MAY BE HANDLED BY BOOK CONTROLLER
	//ADD A CONTRIBUTION
//	@RequestMapping(method = RequestMethod.POST, value = "/creators/{id}/role")
//	public void addRole(@RequestBody CreatorRole role, @PathVariable int id) {
//		creatorService.addRole(role, id);
//	}
//	
//	//UPDATE A CONTRIBUTION
//	@RequestMapping(method = RequestMethod.PUT, value = "/creators/{id}/role")
//	public void updateRole(@RequestBody CreatorRole role, @PathVariable int id) {
//		creatorService.updateRole(role, id);
//	}
	
	
	
	
}
