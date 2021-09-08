package dpi.api.field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dpi.api.domain.Domain;

@Entity
@Table(name = "domain_field")
public class Field {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String label;
	@ManyToOne
    @JoinColumn(name="domain_id", nullable=false)
	private Domain domain;
	
	
	
	public Field() {
		super();
	}
	
	public Field(int id, String label, Domain domain) {
		super();
		this.id = id;
		this.label = label;
		this.domain = domain;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	
}
