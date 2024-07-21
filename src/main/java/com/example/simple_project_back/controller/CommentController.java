package com.example.simple_project_back.controller;

import com.example.simple_project_back.DTO.CommentDTO;
import com.example.simple_project_back.domain.Comment;
import com.example.simple_project_back.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/{}")
    public List<CommentDTO.commentResponse> getComment(@PathVariable Long wellnessId) {
        List<CommentDTO.commentResponse> responses = new ArrayList<>();
        for(Comment c : commentService.getComment(wellnessId)){
            responses.add(new CommentDTO.commentResponse(c));
        }
        return responses;
    }

}
