package com.example.simple_project_back.service;


import com.example.simple_project_back.domain.Comment;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final WellnessService wellnessService;


    public List<Comment> getComment(Long wellnessId) {
        Wellness wellness = wellnessService.getWellnessById(wellnessId);
        if (wellness == null) {
            // 웰니스 없으면 오류
            return null;
        }
        return commentRepository.findAllById(wellness);
    }


}
