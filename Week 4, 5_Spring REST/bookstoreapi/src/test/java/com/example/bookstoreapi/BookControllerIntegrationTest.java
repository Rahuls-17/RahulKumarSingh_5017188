package com.example.bookstoreapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // If you have a test profile
public class BookControllerIntegrationTest {

    @Test
    void testCreateBook() {
        // Your test logic
    }
}
