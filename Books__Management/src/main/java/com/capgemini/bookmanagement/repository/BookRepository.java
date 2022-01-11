package com.capgemini.bookmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bookmanagement.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
