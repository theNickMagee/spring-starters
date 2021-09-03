package dpi.api.page;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dpi.api.chapter.Chapter;


@Entity
public class Page {
	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	private int book_id;
//	private int chapter_id;
	private int page_number;
	
	@ManyToOne
	@JoinColumn(name = "chapter_id")
	private Chapter chapter;
	
	public Page() {
		super();
	}

	public Page(int id, int book_id, Chapter chapter, int page_number) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.chapter = chapter;
		this.page_number = page_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public Chapter getChapter() {
		return this.chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public int getPage_number() {
		return page_number;
	}

	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}
	
}
