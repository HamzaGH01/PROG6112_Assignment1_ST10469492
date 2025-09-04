/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.prog6112.bookstoreinv_a1secb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10469492 Hamza Goolam Hoosen
 */

public class FictionBookTest {

    private FictionBook fictionBook;

    @BeforeEach
    void setUp() {
        fictionBook = new FictionBook("Fantasy Quest", "A.N. Author", 18.00, 7, "Fantasy");
    }

    @Test
    void testFictionBookConstructor() {
        assertNotNull(fictionBook, "FictionBook object should not be null");
        assertEquals("Fantasy Quest", fictionBook.getTitle(), "Title should be inherited correctly");
        assertEquals("A.N. Author", fictionBook.getAuthor(), "Author should be inherited correctly");
        assertEquals(18.00, fictionBook.getPrice(), 0.001, "Price should be inherited correctly");
        assertEquals(7, fictionBook.getStockLevel(), "Stock should be inherited correctly");
        assertEquals("Fantasy", fictionBook.getGenre(), "Genre should be set correctly for FictionBook");
    }

    @Test
    void testFictionBookInheritance() {
        fictionBook.updateStock(3);
        assertEquals(10, fictionBook.getStockLevel(), "Inherited updateStock should work");
        fictionBook.setPrice(20.00);
        assertEquals(20.00, fictionBook.getPrice(), 0.001, "Inherited setPrice should work");

        assertEquals("Fantasy", fictionBook.getGenre(), "FictionBook specific getter should work");
    }

    @Test
    void testGetGenre() {
        assertEquals("Fantasy", fictionBook.getGenre());
        assertTrue(fictionBook instanceof Book, "FictionBook should be an instance of Book");
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/