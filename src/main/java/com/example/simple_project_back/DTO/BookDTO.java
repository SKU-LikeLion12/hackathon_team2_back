package com.example.simple_project_back.DTO;

import com.example.simple_project_back.domain.Book;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        private String checkIn;
        private int isBook;

        public BookResponseCommon(Book book){
            this.bookId = book.getId();
            this.title = book.getWellness().getTitle();
            // LocalDateTime을 "yyyy-MM-dd HH:mm" 형식으로 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            this.checkIn = book.getCheckIn().format(formatter);
            this.isBook = book.getIsBook();
        }
    }



    @Data
    public static class BookResponseById{
        private Long bookId;
        private String title;
        private String nickName;
        private LocalDateTime checkIn;
        private String eleMail;
        private String content;
        private int isBook;

        public BookResponseById(Book book){
            this.bookId = book.getId();
            this.title = book.getWellness().getTitle();
            this.nickName = book.getMember().getNickName();
            this.checkIn = book.getCheckIn();
            this.eleMail = book.getMember().getEMail();
            this.content = book.getContent();
            this.isBook = book.getIsBook();
        }
    }

}
