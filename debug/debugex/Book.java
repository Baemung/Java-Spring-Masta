package com.jurib.debugex;

import java.io.Serializable;

/**
 * 도서 정보를 나타내는 클래스
 */

public class Book  implements Serializable,Comparable<Book>{	
	
	/** 고유 번호 */
	private String isbn;		
	/**	제목 */
	private String title;		
	/** 저자 */
	private String author;		
	/** 출판사 */
	private String publisher;	
	/** 가격 */
	private int price;			
	/**	설명 */
	private String desc;		
	/** 재고 수량 */
	private int quantity;
	/** 기본 생성자 */
	public Book() {
	}
	/** 도서 정보를 모두 받아 생성하는 생성자 */
	public Book(String isbn, String title, String author, String publisher, int price, String desc,int quantity){
		// 받은 정보로 객체의 상태를 초기화한다.
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}
	/**
	 * 고유번호를 반환한다.
	 * @return 고유번호
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * 고유번호를 저장한다.
	 * @param isbn : 고유번호
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * 제목을 반환한다.
	 * @return 제목
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 제목을 저장한다.
	 * @param title : 제목
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 저자를 반환한다.
	 * @return 저자
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 저자를 저장한다.
	 * @param author : 저자
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 출판사를 반환한다.
	 * @return 출판사
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * 출판사를 저장한다.
	 * @param publisher : 출판사
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * 가격을 반환한다.
	 * @return 가격
	 */	
	public int getPrice() {
		return price;
	}
	/**
	 * 가격을 저장한다.
	 * @param price : 가격
	 */	
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * 설명을 반환한다.
	 * @return 설명
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 설명을 저장한다.
	 * @param desc : 설명
	 */		
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 재고수량을 반환한다.
	 * @return 재고수량
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * 재고수량을 저장한다.
	 * @param amount : 재고수량
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * 도서의 정보를 문자열로 반환한다
	 * @return 도서정보
	 */
	 public String toString() {
		return isbn + '\t' + "| " + title + "  \t" + "| " + author + '\t' + "| " + publisher + '\t'
				+ "| " + price + '\t' + "| " + desc + '\t'+ "| " + quantity + '\t';
	}
	@Override
	public int compareTo(Book o) {
		return o.isbn.compareTo(this.isbn);
	}
}

