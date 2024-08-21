package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.exception.BookNotFoundException;
import com.example.bookstoreapi.mapper.BookMapper;
import com.example.bookstoreapi.service.BookService; // Ensure this import is present
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService; // Ensure BookService is properly injected

    @Autowired
    private BookMapper bookMapper;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookMapper.toBookDTOList(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public EntityModel<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        BookDTO bookDTO = bookMapper.toBookDTO(book);
        EntityModel<BookDTO> resource = EntityModel.of(bookDTO);
        resource.add(linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel());
        return resource;
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        book = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Custom-Header", "Book Created")
                .body(bookMapper.toBookDTO(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO updatedBookDTO) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        book.setTitle(updatedBookDTO.getTitle());
        book.setAuthor(updatedBookDTO.getAuthor());
        book.setPrice(updatedBookDTO.getPrice());
        book.setIsbn(updatedBookDTO.getIsbn());
        book = bookService.saveBook(book);
        return new ResponseEntity<>(bookMapper.toBookDTO(book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        return bookMapper.toBookDTOList(bookService.searchBooks(title, author));
    }
}
