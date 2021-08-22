package com.jurib.debugex;

/**
 * 잡지 정보를 나타내는 클래스
 */

public class Magazine extends Book {
	/**
	 * 발행년도
	 */
	private int year;
	/**
	 * 발행월
	 */
	private int month;
	
	/** 기본 생성자 */
	public Magazine() {
	}
	/** 잡지 정보 모두를 받아 생성하는 생성자 */
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month,int quantity) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}
	/**
	 * 발행년도를 반환한다.
	 * @return 발행년도
	 */
	public int getYear() {
		return year;
	}
	/**
	 * 발행년도를 저장한다.
	 * @param year : 발행년도
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * 발행월을 반환한다.
	 * @return 발행월
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * 발행월을 저장한다.
	 * @param month : 발행월
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * 잡지정보를 문자열로 반환하다.
	 * @return 잡지 정보
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		builder.append(year + "\t| ");
		builder.append(month);
		return builder.toString();
	}
}
