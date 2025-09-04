/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG6112A1;

import java.util.Scanner;
/**
 *
 * @author ST10469492 Hamza Goolam Hoosen
 */

public class Main {

    private static TvShowManager tvShowManager = new TvShowManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeScreen();
    }

    private static void displayWelcomeScreen() {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            displayMainMenu();
        } else {
            tvShowManager.ExitApplication();
        }
    }

    private static void displayMainMenu() {
        int choice = -1;
        while (choice != 6) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        tvShowManager.CaptureTvShow();
                        break;
                    case 2:
                        tvShowManager.SearchTvShow();
                        break;
                    case 3:
                        tvShowManager.UpdateTvShow();
                        break;
                    case 4:
                        tvShowManager.DeleteTvShow();
                        break;
                    case 5:
                        tvShowManager.TvShowReport();
                        break;
                    case 6:
                        tvShowManager.ExitApplication();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/