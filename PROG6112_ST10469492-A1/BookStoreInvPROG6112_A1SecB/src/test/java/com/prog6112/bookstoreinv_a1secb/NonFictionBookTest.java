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


public class NonFictionBookTest {

    private NonFictionBook nonFictionBook;

    @BeforeEach
    void setUp() {
        nonFictionBook = new NonFictionBook("World History", "Historian Guy", 25.50, 12, "History");
    }

    @Test
    void testNonFictionBookConstructor() {
        assertNotNull(nonFictionBook, "NonFictionBook object should not be null");
        assertEquals("World History", nonFictionBook.getTitle(), "Title should be inherited correctly");
        assertEquals("Historian Guy", nonFictionBook.getAuthor(), "Author should be inherited correctly");
        assertEquals(25.50, nonFictionBook.getPrice(), 0.001, "Price should be inherited correctly");
        assertEquals(12, nonFictionBook.getStockLevel(), "Stock should be inherited correctly");
        assertEquals("History", nonFictionBook.getSubject(), "Subject should be set correctly for NonFictionBook");
    }

    @Test
    void testNonFictionBookInheritance() {
        nonFictionBook.updateStock(-5);
        assertEquals(7, nonFictionBook.getStockLevel(), "Inherited updateStock should work");
        nonFictionBook.setPrice(29.99);
        assertEquals(29.99, nonFictionBook.getPrice(), 0.001, "Inherited setPrice should work");
        assertEquals("History", nonFictionBook.getSubject(), "NonFictionBook specific getter should work");
    }

    @Test
    void testGetSubject() {
        assertEquals("History", nonFictionBook.getSubject());
        assertTrue(nonFictionBook instanceof Book, "NonFictionBook should be an instance of Book");
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/