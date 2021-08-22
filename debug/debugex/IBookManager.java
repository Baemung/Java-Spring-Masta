package com.jurib.debugex;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager {
	/**
	 * 도서를 도서리스트에 추가한다.
	 * @param book : 추가할 도서
	 */
	void add(Book book);
	/**
	 * 고유번호로 해당 도서를 도서리스트에서 삭제한다.
	 * @param isbn : 삭제할 도서의 고유번호
	 */
	void remove(String isbn);
	/**
	 * 등록된 도서리스트를 반환한다.
	 * @return 등록된 전체 도서리스트
	 */
	Book[] getList();
	/**
	 * 고유번호로 해당 도서를 조회한다.
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
	 */
	Book searchByIsbn(String isbn);
	/**
	 * 도서 제목을 포함하고 있는 도서리스트를 반환한다.
	 * @param title : 조회할 도서의 제목
	 * @return
	 */
	Book[] searchByTitle(String title);
	/**
	 * 잡지리스트를 반환한다.
	 * @return 잡지리스트
	 */
	Magazine[] getMagazines();
	/**
	 * 잡지가 아닌 도서리스트를 반환한다. 
	 * @return 잡지가 아닌 도서리스트
	 */
	Book[] getBooks();
	/**
	 * 도서리스트의 가격의 총합을 반환한다.
	 * @return 모든 도서 가격의 총합
	 */
	int getTotalPrice();
	/**
	 * 도서가격의 평균을 반환한다.
	 * @return 모든 도서 가격의 평균
	 */
	double getPriceAvg();
	/**
	 * 고유번호에 해당하는 도서를 수량만큼 판매처리하여 재고를 감소시킨다.
	 * @param isbn : 도서 고유번호
	 * @param quantity : 판매 수량
	 * @throws QuantityException : 재고 수량 부족의 예외 상황
	 * @throws ISBNNotFoundException : 고유번호에 해당하는 도서가 존재하지 않는 예외상황 
	 */
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	/**
	 * 고유번호에 해당하는 도서를 수량만큼 구매 처리하여 재고를 증가시킨다.
	 * @param isbn : 도서 고유번호
	 * @param quantity : 구매 수량
	 * @throws ISBNNotFoundException : 고유번호에 해당하는 도서가 존재하지 않는 예외상황 
	 */
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	/**
	 * 도서리스트를 파일에 저장한다.
	 */
	void saveData();
}