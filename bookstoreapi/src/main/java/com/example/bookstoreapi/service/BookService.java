package com.example.bookstoreapi.service;

import com.example.bookstoreapi.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // Return a copy to avoid external modifications
    }

    public Book getBookById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    public Book saveBook(Book book) {
        if (book.getId() == null) {
            book.setId((long) (books.size() + 1));
        }
        books.removeIf(b -> b.getId().equals(book.getId())); // Replace if exists
        books.add(book);
        return book;
    }

    public void deleteBook(Long id) {
        books.removeIf(b -> b.getId().equals(id));
    }

    public List<Book> searchBooks(String title, String author) {
        return books.stream()
                .filter(b -> (title == null || b.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || b.getAuthor().equalsIgnoreCase(author)))
                .collect(Collectors.toList());
    }
}
