package com.example.simple_project_back.DTO;


import com.example.simple_project_back.domain.Comment;
import lombok.Data;

public class CommentDTO {
    @Data
    public static class CommentResponse {

        private String content;
        private String author;
        private String authorId;

        public CommentResponse(Comment comment) {
            this.content = comment.getContent();
            this.author = comment.getMember().getNickName();
            this.authorId = comment.getMember().getUserId();

        }
    }

    @Data
    public static class CommentRequest {
        private String token;
        private Long wellnessId;
        private String content;
    }


}
