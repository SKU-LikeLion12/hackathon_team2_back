package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Book;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Wellness;

import java.util.List;

public interface BookRepository {
    // 예약하기 기능
    int addBook(Book book);

    
    // 일반 유저 예약 목록 보기
    List<Book> findAllById(Member member);

    
    // 사장님 유저 예약 목록 보기
    List<Book> findAllByOwnerId(Wellness wellness);
    
    // 사장님 예약 확인
    int updateIsBook(Long id, int isBook);
}
