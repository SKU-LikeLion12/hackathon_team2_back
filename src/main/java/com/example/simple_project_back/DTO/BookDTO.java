package com.example.simple_project_back.DTO;

import com.example.simple_project_back.domain.Book;
import lombok.Data;

import java.time.LocalDateTime;

public class BookDTO {

    @Data
    public static class BookRequest{
        private String token;
        private Long wellnessId;
        private String content;
        private int headCnt;
        private int year;
        private int month;
        private int day;
        private int hour;
        private int minute;
    }

    @Data
    public static class isBookRequest{
        // 주인은 수정 가능
        private String token;
        private Long bookId;
        private int isBook;
    }


    // 일반, 사장 예약보기 요청
    @Data
    public static class BookRequestIsOwner{
        private String token;
        private int isOwner;
    }

    @Data
    public static class BookResponseCommon{
        private Long bookId;
        private String title;
        private LocalDateTime checkIn;
        private int isBook;

        public BookResponseCommon(Book book){
            this.bookId = book.getId();
            this.title = book.getWellness().getTitle();
            this.checkIn = book.getCheckIn();
            this.isBook = book.getIsBook();
        }
    }



    @Data
    public static class BookResponseById{
        private Long bookId;
        private String title;
        private String nickName;
        private LocalDateTime checkIn;
        private String content;
        private int isBook;

        public BookResponseById(Book book){
            this.bookId = book.getId();
            this.title = book.getWellness().getTitle();
            this.nickName = book.getMember().getNickName();
            this.checkIn = book.getCheckIn();
            this.content = book.getContent();
            this.isBook = book.getIsBook();
        }
    }

}
