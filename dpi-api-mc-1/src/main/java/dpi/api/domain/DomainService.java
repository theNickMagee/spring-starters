package dpi.api.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DomainService {
	
	@Autowired
	DomainRepository domainRepository;

	public Domain getDomain(int id) {
		return domainRepository.findById(id).get();
	}

	public List<Domain> getAllDomains() {
		List<Domain> domains = new ArrayList<>();
		domainRepository.findAll().forEach(domains::add);
		return domains;
	}

	public void createDomain(Domain domain) {
		domainRepository.save(domain);
		
	}

	public void updateDomain(Domain domain, int id) {
		domain.setId(id);
		domainRepository.save(domain);
		
	}

	public void deleteDomain(int id) {
		domainRepository.deleteById(id);
		
	}

}
