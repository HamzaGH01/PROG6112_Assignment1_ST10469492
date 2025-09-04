/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog6112.bookstoreinv_a1secb;

/**
 *
 * @author ST10469492 Hamza Goolam Hoosen
 */
public class Book {
    private String title;
    private String author;
    private double price;
    private int stockLevel;

    public Book(String title, String author, double price, int stockLevel) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stockLevel = stockLevel;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.err.println("Price cannot be negative. Setting to 0.");
            this.price = 0;
        }
    }

    public void updateStock(int amount) {
        if (this.stockLevel + amount >= 0) {
            this.stockLevel += amount;
        } else {
            System.err.println("Cannot reduce stock below zero. Current stock: " + this.stockLevel);
        }
    }

    @Override
    public String toString() {
        return String.format("%-25s %-20s $%-10.2f %-10d", title, author, price, stockLevel);
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/