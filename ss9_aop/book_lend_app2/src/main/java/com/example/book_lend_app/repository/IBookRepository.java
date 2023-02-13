package com.example.book_lend_app.repository;

import com.example.book_lend_app.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {

    Page<Book> findBookByNameContaining(String name,Pageable pageable);

}
