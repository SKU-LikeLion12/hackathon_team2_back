package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.BookDTO;
import com.example.simple_project_back.domain.Book;
import com.example.simple_project_back.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @Operation(summary = "예약하기", description = "사용자가 특정 매장을 예약 가능", tags = {"Member"})
    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody BookDTO.BookRequest request) {

        try{
            if(bookService.addBook(request) == 1){
                return ResponseEntity.status(HttpStatus.CREATED).body("success");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
    }

    @Operation(summary = "예약정보 확인", description = "일반사용자,사장님 사용자 모두 예약내용 확인 가능", tags = {"Member", "Owner"})
    @PostMapping("/book/myPage")
    public List<BookDTO.BookResponseCommon> getMyPage(@RequestBody BookDTO.BookRequestIsOwner request){
        List<BookDTO.BookResponseCommon> response = new ArrayList<>();
        try{
            for(Book b : bookService.getBook(request) ){
                response.add(new BookDTO.BookResponseCommon(b));
            }
            return response;
        }catch (Exception e){
            return  null;
        }
    }

    @Operation(summary = "예약정보 확인(수정)", description = "사장님 사용자가 예약내용 확인 후 답변 가능", tags = {"Owner"})
    @PutMapping("/book/isBook")
    public ResponseEntity<String> isBookRequest( @RequestBody BookDTO.isBookRequest request){
        if( bookService.isBook(request) == 1){
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
    }


}


