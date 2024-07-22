package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Comment;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Wellness;

import java.util.List;

public interface CommentRepository {

    // 해당 상세 페이지에 댓글가져오기
    List<Comment> findAllById(Wellness wellness);
    
    // 댓글 작성 로직 ( 성공 1, 실패 0 )
    int addComment (Comment comment);
}
