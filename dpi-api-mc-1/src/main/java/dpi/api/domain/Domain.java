package dpi.api.domain;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dpi.api.book.Book;
import dpi.api.chapter.Chapter;
import dpi.api.creator.Creator;
import dpi.api.field.Field;

@Entity
@Table(name = "domain")
public class Domain {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String webaddress;

//	@ManyToMany
//	@JoinTable(
//			  name = "domain_field_relation", 
//		      inverseJoinColumns = @JoinColumn(name = "field_id"), 
//			  joinColumns = @JoinColumn(name = "domain_id"))
//    private Set<Field> fields = new HashSet<>();
	
	@OneToMany(mappedBy = "domains")
	private Set<Field> fields;
	
	@OneToMany(mappedBy = "domain")
    private List<Creator> creators;
	
	public Domain() {
		super();
	}




	public Domain(int id, String name, String webaddress) {
		super();
		this.id = id;
		this.name = name;
		this.webaddress = webaddress;
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


	public String getWebaddress() {
		return webaddress;
	}

	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}


	public Set<Field> getFields() {
		return fields;
	}


	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}




	public List<Creator> getCreators() {
		return creators;
	}




	public void setCreators(List<Creator> creators) {
		this.creators = creators;
	}
	


}