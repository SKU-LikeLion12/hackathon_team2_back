package com.example.simple_project_back.controller;

import com.example.simple_project_back.DTO.CommentDTO;
import com.example.simple_project_back.domain.Comment;
import com.example.simple_project_back.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = { "*" })
public class CommentController {
    private final CommentService commentService;
    private final View error;

    @Operation(summary = "각 매장별 댓글 목록", description = "매잘 별 상세 페이지 하단에 댓글", tags = {"HomePage"})
    @GetMapping("/comment/{wellnessId}")
    public List<CommentDTO.CommentResponse> getComment(@PathVariable Long wellnessId) {
        List<CommentDTO.CommentResponse> responses = new ArrayList<>();
        for(Comment c : commentService.getComment(wellnessId)){
            responses.add(new CommentDTO.CommentResponse(c));
        }
        return responses;
    }

    @Operation(summary = "각 매장별 댓글 쓰기", description = "매잘 별 상세 페이지 하단에 댓글작성", tags = {"Member"})
    @PostMapping("/comment/add")
    public ResponseEntity<String> setComment(@RequestBody CommentDTO.CommentRequest request) {
        if(commentService.addComment(request) == 1){
            // 사용자 로그인 여부 토큰 여부 확인??
            return ResponseEntity.status(HttpStatus.CREATED).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
    }

}
