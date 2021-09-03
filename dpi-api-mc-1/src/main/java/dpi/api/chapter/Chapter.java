package dpi.api.chapter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import dpi.api.book.Book;
import dpi.api.book.BookService;


@Entity
public class Chapter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
//	private int parent_chapter_id;
	@ManyToOne
    @JoinColumn(name="book_id", nullable=false)
	private Book book;
	
	
	
	public Chapter() {
		super();
	}
	
	public Chapter(int id, String name, Book book) {
		super();
		this.id = id;
		this.name = name;
		this.book = book;
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
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	//	public int getBook_id() {
//		return book_id;
//	}
//	public void setBook_id(int book_id) {
//		this.book_id = book_id;
//	}
//	public int getParent_chapter_id() {
//		return parent_chapter_id;
//	}
//	public void setParent_chapter_id(int parent_chapter_id) {
//		this.parent_chapter_id = parent_chapter_id;
//	}
}
