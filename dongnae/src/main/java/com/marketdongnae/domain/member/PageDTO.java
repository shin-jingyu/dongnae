package com.marketdongnae.domain.member;

import lombok.Data;

@Data
public class PageDTO {
	private int m_number;
	private String d_type;
	
	// 현재 페이지 번호  
	private int nowpage;

	// 게시물 총 갯수 
	private int count;

	// 출력할 게시물	: 	몇 번 게시물부터 표출인지
	private int displayStart;

	// 표시되는 페이지 번호 중 첫번째 번호	: 5
	private int startPageNum;

	// 표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;
	
	// 모든 페이지 번호 중 마지막 번호	
	private int realEndPageNum;

	// 다음/이전 눌렀을 때 이동될 페이지 번호
	private int prev;	// true 
	private int next;	// false
	
	public void setNowpage(int nowpage) {	// view에서 page 번호 파라미터 받아 set 
		this.nowpage = nowpage ;
	};
	public void setCount(int count) {	// db에서 전체 게시물 수 받아 set 
		this.count = count; 
		dataCalc();
	};
	
	private void dataCalc() {
		startPageNum = nowpage - ( (nowpage-1) %3 ) ;
		endPageNum = (int) Math.ceil( (double)count / 3 );

		if(startPageNum + 2 < endPageNum) {
			endPageNum = startPageNum +2 ;
		}
		realEndPageNum = (int) Math.ceil( (double)count / 3 );
		displayStart = (int) Math.ceil( (nowpage-1) * 3 ) ;
		
		prev = startPageNum - 1 ; 
		next = endPageNum +1 ; 
		}
}
