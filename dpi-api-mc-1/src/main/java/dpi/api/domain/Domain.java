package dpi.api.domain;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import dpi.api.field.Field;

@Entity
public class Domain {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String webaddress;

	@OneToMany(mappedBy="domain")
    private Set<Field> fields;
	
	
	
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

}