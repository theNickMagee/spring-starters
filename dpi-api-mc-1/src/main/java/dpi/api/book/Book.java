package dpi.api.book;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dpi.api.category.Category;
import dpi.api.chapter.Chapter;

import javax.persistence.JoinColumn;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "chapters"})
public class Book {

		@Id
		@GeneratedValue
	    @Column(name="id")
		private int id;
		private String title;
		private String composer;
		private String performer;
		private String price;
		private String domain;
		private int active;
		private String author;
		private String voice_actor;
		private String created_by;
		private String updated_by;
		private java.sql.Date when_created;
		private java.sql.Date when_updated;

		@OneToMany(mappedBy = "book")
	    private List<Chapter> chapters;
		
		@ManyToMany(targetEntity = Category.class, cascade = CascadeType.PERSIST)
		@JoinTable(name = "category_relation",
        joinColumns = {
                @JoinColumn(name = "book_id", referencedColumnName = "id",
                        nullable = false, updatable = false)},
        inverseJoinColumns = {
                @JoinColumn(name = "category_id", referencedColumnName = "id",
                        nullable = false, updatable = false)})
		private Set<Category> categories = new HashSet<>();
	
		
		public Book() {
			super();
		}
		
		public Book(int id, String title, String composer, String performer, String price, String domain, int active,
				String author, String voice_actor, String created_by, String updated_by, Date when_created,
				Date when_updated) {
			super();
			this.id = id;
			this.title = title;
			this.composer = composer;
			this.performer = performer;
			this.price = price;
			this.domain = domain;
			this.active = active;
			this.author = author;
			this.voice_actor = voice_actor;
			this.created_by = created_by;
			this.updated_by = updated_by;
			this.when_created = when_created;
			this.when_updated = when_updated;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		
		public void addToChapters(Chapter chapter) {
			this.chapters.add(chapter);
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getComposer() {
			return composer;
		}

		public void setComposer(String composer) {
			this.composer = composer;
		}

		public String getPerformer() {
			return performer;
		}

		public void setPerformer(String performer) {
			this.performer = performer;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getDomain() {
			return domain;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public int getActive() {
			return active;
		}

		public void setActive(int active) {
			this.active = active;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getVoice_actor() {
			return voice_actor;
		}

		public void setVoice_actor(String voice_actor) {
			this.voice_actor = voice_actor;
		}


		public String getCreated_by() {
			return created_by;
		}

		public void setCreated_by(String created_by) {
			this.created_by = created_by;
		}

		public String getUpdated_by() {
			return updated_by;
		}

		public void setUpdated_by(String updated_by) {
			this.updated_by = updated_by;
		}

		public java.sql.Date getWhen_created() {
			return when_created;
		}

		public void setWhen_created(java.sql.Date when_created) {
			this.when_created = when_created;
		}

		public java.sql.Date getWhen_updated() {
			return when_updated;
		}

		public void setWhen_updated(java.sql.Date when_updated) {
			this.when_updated = when_updated;
		}

	
		
		
		
	
		
		
}