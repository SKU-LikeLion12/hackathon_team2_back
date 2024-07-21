package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Comment;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Wellness;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaCommentRepository implements CommentRepository{
    private final EntityManager em;

    @Override
    public List<Comment> findAllById(Wellness wellness ) {

        return em.createQuery("select c from Comment c where c.wellness = :w", Comment.class)
                .setParameter("w", wellness).getResultList();

    }


    @Override
    public int addComment(Comment comment) {
        try{
            em.persist(comment);
            return 1;

        }catch (Exception e){
            return 0;
        }

    }
}
