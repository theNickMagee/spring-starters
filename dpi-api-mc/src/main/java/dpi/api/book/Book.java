package dpi.api.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String title;
		private String composer;
		private String performer;
		private String price;
		private String domain;
		private boolean active;
		private String author;
		private String voice_actor;
		private String jsonfile;
		private String created_by;
		private String updated_by;
		private java.sql.Date when_created;
		private java.sql.Date when_updated;

		
		public Book() {
			
		}

		public Book(Long id, String title, String composer, String performer, String price, String domain,
				boolean active) {
			super();
			this.id = id;
			this.title = title;
			this.composer = composer;
			this.performer = performer;
			this.price = price;
			this.domain = domain;
			this.active = active;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public boolean getActive() {
			return active;
		}

		public void setActive(boolean active) {
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

		public String getJsonfile() {
			return jsonfile;
		}

		public void setJsonfile(String jsonfile) {
			this.jsonfile = jsonfile;
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