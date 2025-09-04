/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog6112.bookstoreinv_a1secb;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ST10469492 Hamza Goolam Hoosen
 */

public class BookstoreApp {

    private static ArrayList<Book> inventory = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MENU_TITLE = "--- Bookstore Inventory Management ---";

    public static void main(String[] args) {
        inventory.add(new FictionBook("The Hobbit", "J.R.R. Tolkien", 15.99, 10, "Fantasy"));
        inventory.add(new NonFictionBook("Sapiens", "Yuval Noah Harari", 20.50, 5, "History"));
        inventory.add(new FictionBook("Dune", "Frank Herbert", 12.75, 8, "Sci-Fi"));
        inventory.add(new Book("Basic Programming", "John Doe", 30.00, 12));

        runMainMenu();
    }

    private static void runMainMenu() {
        int choice;
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        viewInventory();
                        break;
                    case 3:
                        searchBook();
                        break;
                    case 4:
                        updateBookStock();
                        break;
                    case 5:
                        System.out.println("Exiting Bookstore Application. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void displayMenu() {
        System.out.println("\n" + MENU_TITLE);
        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book by Title/Author");
        System.out.println("4. Update Book Stock Level");
        System.out.println("5. Exit Application");
        System.out.println("------------------------------------");
    }

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        double price = 0;
        while (true) {
            System.out.print("Enter price: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) throw new InputMismatchException();
                break;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Invalid price. Please enter a non-negative number.");
            }
        }

        int stock = 0;
        while (true) {
            System.out.print("Enter stock level: ");
            try {
                stock = Integer.parseInt(scanner.nextLine());
                if (stock < 0) throw new InputMismatchException();
                break;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Invalid stock level. Please enter a non-negative integer.");
            }
        }

        System.out.print("Is this a (F)iction, (N)on-Fiction, or (G)eneric book? (F/N/G): ");
        String type = scanner.nextLine().toUpperCase();

        switch (type) {
            case "F":
                System.out.print("Enter genre (e.g., Fantasy, Sci-Fi): ");
                String genre = scanner.nextLine();
                inventory.add(new FictionBook(title, author, price, stock, genre));
                System.out.println("Fiction Book added successfully!");
                break;
            case "N":
                System.out.print("Enter subject (e.g., History, Science): ");
                String subject = scanner.nextLine();
                inventory.add(new NonFictionBook(title, author, price, stock, subject));
                System.out.println("Non-Fiction Book added successfully!");
                break;
            case "G":
                inventory.add(new Book(title, author, price, stock));
                System.out.println("Generic Book added successfully!");
                break;
            default:
                System.out.println("Invalid book type. Book not added.");
        }
    }

    private static void viewInventory() {
        System.out.println("\n--- Current Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.printf("%-25s %-20s %-11s %-10s %-15s %-15s%n",
                          "Title", "Author", "Price", "Stock", "Type/Genre", "Subject");
        System.out.println("--------------------------------------------------------------------------------------");

        for (Book book : inventory) {
            String typeDetails = "";
            if (book instanceof FictionBook) {
                typeDetails = ((FictionBook) book).getGenre() + " (Fiction)";
            } else if (book instanceof NonFictionBook) {
                typeDetails = ((NonFictionBook) book).getSubject() + " (Non-Fiction)";
            } else {
                typeDetails = "Generic";
            }
            System.out.printf("%-25s %-20s $%-10.2f %-10d %-15s%n",
                              book.getTitle(), book.getAuthor(), book.getPrice(),
                              book.getStockLevel(), typeDetails);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private static void searchBook() {
        System.out.println("\n--- Search Book ---");
        System.out.print("Enter search term (title or author): ");
        String searchTerm = scanner.nextLine().toLowerCase();
        ArrayList<Book> searchResults = new ArrayList<>();

        for (Book book : inventory) {
            if (book.getTitle().toLowerCase().contains(searchTerm) ||
                book.getAuthor().toLowerCase().contains(searchTerm)) {
                searchResults.add(book);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No books found matching '" + searchTerm + "'.");
        } else {
            System.out.println("\n--- Search Results ---");
            System.out.printf("%-25s %-20s $%-10s %-10s %-15s %-15s%n",
                              "Title", "Author", "Price", "Stock", "Type/Genre", "Subject");
            System.out.println("--------------------------------------------------------------------------------------");
            for (Book book : searchResults) {
                String typeDetails = "";
                if (book instanceof FictionBook) {
                    typeDetails = ((FictionBook) book).getGenre() + " (Fiction)";
                } else if (book instanceof NonFictionBook) {
                    typeDetails = ((NonFictionBook) book).getSubject() + " (Non-Fiction)";
                } else {
                    typeDetails = "Generic";
                }
                 System.out.printf("%-25s %-20s $%-10.2f %-10d %-15s%n",
                              book.getTitle(), book.getAuthor(), book.getPrice(),
                              book.getStockLevel(), typeDetails);
            }
             System.out.println("--------------------------------------------------------------------------------------");
        }
    }

    private static void updateBookStock() {
        System.out.println("\n--- Update Book Stock ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty. Cannot update stock.");
            return;
        }

        System.out.print("Enter the title of the book to update stock: ");
        String titleToUpdate = scanner.nextLine();
        Book foundBook = null;

        for (Book book : inventory) {
            if (book.getTitle().equalsIgnoreCase(titleToUpdate)) {
                foundBook = book;
                break;
            }
        }

        if (foundBook == null) {
            System.out.println("Book with title '" + titleToUpdate + "' not found.");
            return;
        }

        System.out.println("Found book: " + foundBook.getTitle() + " (Current Stock: " + foundBook.getStockLevel() + ")");
        int amount = 0;
        while (true) {
            System.out.print("Enter amount to add/remove (e.g., 5 to add, -2 to remove): ");
            try {
                amount = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter an integer.");
            }
        }

        foundBook.updateStock(amount);
        System.out.println("Stock updated successfully. New stock for '" + foundBook.getTitle() + "': " + foundBook.getStockLevel());
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/