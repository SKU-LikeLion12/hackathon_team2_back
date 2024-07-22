package com.example.simple_project_back.service;


import com.example.simple_project_back.DTO.BookDTO;
import com.example.simple_project_back.domain.Book;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final MemberService memberService;
    private final WellnessService wellnessService;



    @Transactional
    public int addBook(BookDTO.BookRequest request) {
        Member member = memberService.tokenToMember(request.getToken());
        Wellness wellness = wellnessService.getWellnessById(request.getWellnessId());
        LocalDateTime checkin = LocalDateTime.of(
                request.getYear(),
                request.getMonth(),
                request.getDay(),
                request.getHour(),
                request.getMinute()
        );

        return bookRepository.addBook( new Book(
                member,
                wellness,
                request.getContent(),
                request.getHeadCnt(),
                checkin,
                LocalDateTime.now()
                )
        );

    }

    public List<Book> getBook(BookDTO.BookRequestIsOwner request) {
        Member member = memberService.tokenToMember(request.getToken());
        if (request.getIsOwner() == 0){
            return bookRepository.findAllById(member);
        }else if(request.getIsOwner() == 1){
            return bookRepository.findAllByOwnerId(member.getWellness());
        }

        return null;
    }

    @Transactional
    public int isBook(BookDTO.isBookRequest request) {
        try {
            Member member = memberService.tokenToMember(request.getToken());
            return bookRepository.updateIsBook(request.getBookId() , request.getIsBook());
        }catch (Exception e){
            return 0;
        }


    }




}
