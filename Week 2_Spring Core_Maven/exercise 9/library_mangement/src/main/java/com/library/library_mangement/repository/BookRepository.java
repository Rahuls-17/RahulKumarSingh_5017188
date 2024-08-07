package com.library.library_mangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library_mangement.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
