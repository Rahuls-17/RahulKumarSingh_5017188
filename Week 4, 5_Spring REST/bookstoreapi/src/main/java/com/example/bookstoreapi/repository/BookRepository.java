package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
