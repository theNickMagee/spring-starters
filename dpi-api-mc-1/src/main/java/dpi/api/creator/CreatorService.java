package dpi.api.creator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dpi.api.book.Book;
import dpi.api.book.BookRepository;

@Service
public class CreatorService {
	
	@Autowired
	private CreatorRepository creatorRepository;

	public List<Creator> getAllCreators() {
		List<Creator> creators = new ArrayList<>();
		creatorRepository.findAll().forEach(creators::add);
		return creators;
	}

	public List<Creator> getCreatorsForBook(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Creator> getBooksOfCreator(int creatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Creator> getCreatorsInDomain(int domainId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Creator createCreator(Creator creator) {
		creatorRepository.save(creator);
		return creator;
	}

	public void updateCreator(Creator creator, int id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCreator(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Book> searchByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
