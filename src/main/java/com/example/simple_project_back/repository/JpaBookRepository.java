package com.example.simple_project_back.repository;


import com.example.simple_project_back.domain.Book;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Wellness;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaBookRepository implements BookRepository {
    private final EntityManager em;

    @Override
    public int addBook(Book book) {
        try{
            em.persist(book);
            return 1;
        }catch(Exception e){
            return 0;
        }
    }


    @Override
    public List<Book> findAllById(Member member) {
        return em.createQuery("select b from Book b where b.member = :member", Book.class )
                .setParameter("member", member)
                .getResultList();
    }

    @Override
    public List<Book> findAllByOwnerId(Wellness wellness) {
        return em.createQuery("select b from Book b where b.wellness = :wellness", Book.class )
                .setParameter("wellness", wellness)
                .getResultList();
    }

    @Override
    public int updateIsBook(Long id, int isBook) {
        try{
            em.createQuery("update Book b set isBook = :isBook where id = :id")
                    .setParameter("isBook", isBook)
                    .setParameter("id", id)
                    .executeUpdate();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }


    @Override
    public Book findAllById(Long id) {
        try{
            return em.createQuery("select b from Book b where b.id = :id", Book.class)
                    .setParameter("id",id)
                    .getSingleResult();

        }catch(NoResultException e){
            return null;

        }
    }
}
