/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog6112.bookstoreinv_a1secb;

/**
 *
 * @author ST10469492 Hamza Goolam Hoosen
 */
public class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook(String title, String author, double price, int stockLevel, String subject) {
        super(title, author, price, stockLevel);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-15s (Non-Fiction)", subject);
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/