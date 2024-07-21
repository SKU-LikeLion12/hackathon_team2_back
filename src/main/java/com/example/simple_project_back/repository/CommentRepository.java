package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Comment;
import com.example.simple_project_back.domain.Wellness;

import java.util.List;

public interface CommentRepository {

    List<Comment> findAllById(Wellness wellness);
}
