package com.example.bookstoreapi;

import com.example.bookstoreapi.controller.BookController;
import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.mapper.BookMapper;
import com.example.bookstoreapi.entity.Book; // Assuming you have a Book class
import com.example.bookstoreapi.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService; // Mock BookService

    @Mock
    private BookMapper bookMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        // Create some Book objects
        Book book1 = new Book();
        book1.setTitle("Book 1");
        Book book2 = new Book();
        book2.setTitle("Book 2");

        // Create corresponding BookDTO objects
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.setTitle("Book 1");
        BookDTO bookDTO2 = new BookDTO();
        bookDTO2.setTitle("Book 2");

        // Mock the service to return List<Book>
        when(bookService.getAllBooks()).thenReturn(List.of(book1, book2));

        // Mock the mapper to convert List<Book> to List<BookDTO>
        when(bookMapper.toBookDTOList(List.of(book1, book2))).thenReturn(List.of(bookDTO1, bookDTO2));

        List<BookDTO> books = bookController.getAllBooks();

        assertEquals(2, books.size());
        assertEquals("Book 1", books.get(0).getTitle());
        assertEquals("Book 2", books.get(1).getTitle());
    }
}
