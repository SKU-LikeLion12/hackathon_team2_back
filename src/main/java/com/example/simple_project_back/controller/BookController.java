package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.BookDTO;
import com.example.simple_project_back.domain.Book;
import com.example.simple_project_back.service.BookService;
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


    @GetMapping("/book/myPage")
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

    @PutMapping("/book/isBook")
    public ResponseEntity<String> isBookRequest( @RequestBody BookDTO.isBookRequest request){
        if( bookService.isBook(request) == 1){
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
    }


}


