package dpi.api.field;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dpi.api.domain.Domain;

@Entity
@Table(name = "domain_field")
public class Field {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String sql_label;
	
	@OneToMany(mappedBy = "fields")
	private Set<Domain> domains;

	
	
	public Field() {
		super();
	}

	public Field(int id, String title, String sql_label, Set<Domain> domains) {
		super();
		this.id = id;
		this.title = title;
		this.sql_label = sql_label;
		this.domains = domains;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getSql_label() {
		return sql_label;
	}



	public void setSql_label(String sql_label) {
		this.sql_label = sql_label;
	}



	
	

	
}
