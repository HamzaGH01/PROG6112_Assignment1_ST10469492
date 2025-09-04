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

public class BookTest {

    private Book testBook;

    void setUp() {
        testBook = new Book("Test Title", "Test Author", 10.50, 5);
    }

    @Test
    void testBookConstructor() {
        assertNotNull(testBook, "Book object should not be null after construction");
        assertEquals("Test Title", testBook.getTitle(), "Title should match constructor argument");
        assertEquals("Test Author", testBook.getAuthor(), "Author should match constructor argument");
        assertEquals(10.50, testBook.getPrice(), 0.001, "Price should match constructor argument");
        assertEquals(5, testBook.getStockLevel(), "Stock level should match constructor argument");
    }

    @Test
    void testSetPrice() {
        testBook.setPrice(12.99);
        assertEquals(12.99, testBook.getPrice(), 0.001, "Price should be updated correctly");

        testBook.setPrice(-5.00);
        assertEquals(0.00, testBook.getPrice(), 0.001, "Price should be set to 0 for negative input");
    }

    @Test
    void testUpdateStock_Increment() {
        testBook.updateStock(3);
        assertEquals(8, testBook.getStockLevel(), "Stock should increment by 3");
    }

    @Test
    void testUpdateStock_Decrement() {
        testBook.updateStock(-2);
        assertEquals(3, testBook.getStockLevel(), "Stock should decrement by 2");
    }

    @Test
    void testUpdateStock_PreventNegative() {
        testBook.updateStock(-10);
        assertEquals(5, testBook.getStockLevel(), "Stock should not go below zero");
    }

    @Test
    void testGetters() {
        assertEquals("Test Title", testBook.getTitle());
        assertEquals("Test Author", testBook.getAuthor());
        assertEquals(10.50, testBook.getPrice(), 0.001);
        assertEquals(5, testBook.getStockLevel());
    }

    @Test
    void testSetters() {
        testBook.setTitle("New Title");
        assertEquals("New Title", testBook.getTitle());
        testBook.setAuthor("New Author");
        assertEquals("New Author", testBook.getAuthor());
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/