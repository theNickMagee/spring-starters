package dpi.api.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import dpi.api.book.Book;
import dpi.api.field.Field;

@Entity
public class Domain {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String webaddress;

	@ManyToMany
	@JoinTable(
			  name = "domain_field_relation", 
		      inverseJoinColumns = @JoinColumn(name = "field_id"), 
			  joinColumns = @JoinColumn(name = "domain_id"))
    private Set<Field> fields = new HashSet<>();
	
	
	
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
	


}