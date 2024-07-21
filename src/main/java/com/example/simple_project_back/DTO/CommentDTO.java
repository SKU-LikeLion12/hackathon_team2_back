package com.example.simple_project_back.DTO;


import com.example.simple_project_back.domain.Comment;
import lombok.Data;

public class CommentDTO {
    @Data
    public static class commentResponse {

        private String content;
        private String author;
        private String authorId;

        public commentResponse(Comment comment) {
            this.content = comment.getContent();
            this.author = comment.getMember().getNickName();
            this.authorId = comment.getMember().getUserId();

        }
    }


}
