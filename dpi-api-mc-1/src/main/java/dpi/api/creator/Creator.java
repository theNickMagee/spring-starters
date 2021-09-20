package dpi.api.creator;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import dpi.api.domain.Domain;


@Entity
public class Creator {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
    @JoinColumn(name="domain_id")
	private Domain domain;
	private String nationality;

//	@Autowired
//	DomainService domainService;
	
//	@JsonProperty("domain_id")
//	private void unpackNested(Integer domain_id) {
//	    this.domain = domainService.getDomain(domain_id);
//	}
	
	
	public Creator() {
		super();
	}
	
	public Creator(int id, String name, Domain domain, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.domain = domain;
		this.nationality = nationality;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDomain() {
		return domain.getId();
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
