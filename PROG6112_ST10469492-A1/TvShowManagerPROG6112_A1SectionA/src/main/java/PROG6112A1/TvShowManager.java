/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG6112A1;

import java.util.ArrayList;
import java.util.Scanner; // Only Scanner is directly needed for input

/**
 *
 * @author ST10469492 Hamza Goolam Hoosen
 */


import java.util.ArrayList;
import java.util.Scanner;

public class TvShowManager {
    private ArrayList<TvShow> tvShowList;
    private Scanner scanner;

    public TvShowManager() {
        tvShowList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public boolean addTvShow(TvShow tvShow) {
        if (findTvShowById(tvShow.getTvShowId()) == null) {
            tvShowList.add(tvShow);
            return true;
        }
        return false;
    }

    public TvShow findTvShowById(String tvShowId) {
        for (TvShow tvShow : tvShowList) {
            if (tvShow.getTvShowId().equals(tvShowId)) {
                return tvShow;
            }
        }
        return null;
    }

    public boolean updateTvShow(String tvShowId, String newName, String newAgeRestriction, String newNumberOfEpisodes) {
        TvShow tvShowToUpdate = findTvShowById(tvShowId);
        if (tvShowToUpdate != null) {
            tvShowToUpdate.setTvShowName(newName);
            tvShowToUpdate.setTvShowAgeRestriction(newAgeRestriction);
            tvShowToUpdate.setTvShowNumberOfEpisodes(newNumberOfEpisodes);
            return true;
        }
        return false;
    }

    public boolean deleteTvShow(String tvShowId) {
        TvShow tvShowToDelete = findTvShowById(tvShowId);
        if (tvShowToDelete != null) {
            tvShowList.remove(tvShowToDelete);
            return true;
        }
        return false;
    }

    public boolean validateAgeRestriction(String age) {
        try {
            int ageInt = Integer.parseInt(age);
            return ageInt >= 2 && ageInt <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void CaptureTvShow() {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("*********************");

        String tvShowId;
        while (true) {
            System.out.print("Enter the series id: ");
            tvShowId = scanner.nextLine();
            if (findTvShowById(tvShowId) == null) {
                break;
            } else {
                System.out.println("Error: Series with ID " + tvShowId + " already exists. Please enter a unique ID.");
            }
        }

        System.out.print("Enter the series name: ");
        String tvShowName = scanner.nextLine();

        String tvShowAgeRestriction;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            tvShowAgeRestriction = scanner.nextLine();
            if (validateAgeRestriction(tvShowAgeRestriction)) {
                break;
            } else {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }
        }

        System.out.print("Enter the number of episodes for " + tvShowName + ": ");
        String tvShowNumberOfEpisodes = scanner.nextLine();

        TvShow newTvShow = new TvShow(tvShowId, tvShowName, tvShowAgeRestriction, tvShowNumberOfEpisodes);
        addTvShow(newTvShow);
        System.out.println("Series processed successfully!!!");
        System.out.println("------------------------------------");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        scanner.nextLine();
    }

    public void SearchTvShow() {
        System.out.println("\nSEARCH FOR A SERIES");
        System.out.println("*******************");
        System.out.print("Enter the series id to search: ");
        String searchId = scanner.nextLine();

        TvShow foundTvShow = findTvShowById(searchId);
        if (foundTvShow != null) {
            System.out.println("------------------------------------");
            System.out.println(foundTvShow);
            System.out.println("------------------------------------");
        } else {
            System.out.println("Series with Series Id: " + searchId + " was not found!");
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
        scanner.nextLine();
    }

    public void UpdateTvShow() {
        System.out.println("\nUPDATE SERIES");
        System.out.println("***************");
        System.out.print("Enter the series id to update: ");
        String updateId = scanner.nextLine();

        TvShow tvShowToUpdate = findTvShowById(updateId);
        if (tvShowToUpdate != null) {
            System.out.print("Enter the new series name (" + tvShowToUpdate.getTvShowName() + "): ");
            String newName = scanner.nextLine();
            if (newName.isEmpty()) newName = tvShowToUpdate.getTvShowName();

            String newAgeRestriction;
            while (true) {
                System.out.print("Enter the new age restriction (" + tvShowToUpdate.getTvShowAgeRestriction() + "): ");
                newAgeRestriction = scanner.nextLine();
                if (newAgeRestriction.isEmpty() || validateAgeRestriction(newAgeRestriction)) {
                    if (newAgeRestriction.isEmpty()) newAgeRestriction = tvShowToUpdate.getTvShowAgeRestriction();
                    break;
                } else {
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            }

            System.out.print("Enter the new number of episodes (" + tvShowToUpdate.getTvShowNumberOfEpisodes() + "): ");
            String newNumberOfEpisodes = scanner.nextLine();
            if (newNumberOfEpisodes.isEmpty()) newNumberOfEpisodes = tvShowToUpdate.getTvShowNumberOfEpisodes();

            if (updateTvShow(updateId, newName, newAgeRestriction, newNumberOfEpisodes)) {
                System.out.println("Series updated successfully!");
            } else {
                System.out.println("Failed to update series.");
            }
        } else {
            System.out.println("Series with Series Id: " + updateId + " was not found!");
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
        scanner.nextLine();
    }

    public void DeleteTvShow() {
        System.out.println("\nDELETE SERIES");
        System.out.println("*************");
        System.out.print("Enter the series id to delete: ");
        String deleteId = scanner.nextLine();

        TvShow tvShowToDelete = findTvShowById(deleteId);
        if (tvShowToDelete != null) {
            System.out.print("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete. ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                if (deleteTvShow(deleteId)) {
                    System.out.println("------------------------------------");
                    System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
                    System.out.println("------------------------------------");
                } else {
                    System.out.println("Failed to delete series.");
                }
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series with Series Id: " + deleteId + " was not found!");
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
        scanner.nextLine();
    }

    public void TvShowReport() {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update series age restriction");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit Application.");
        System.out.println("5");
        System.out.println("Series report - 2025");
        System.out.println("*********************");
        if (tvShowList.isEmpty()) {
            System.out.println("No series captured yet.");
        } else {
            int tvShowCount = 1;
            for (TvShow tvShow : tvShowList) {
                System.out.println("Series " + tvShowCount++);
                System.out.println("------------------------------------");
                System.out.println(tvShow);
                System.out.println("------------------------------------");
            }
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
        scanner.nextLine();
    }

    public void ExitApplication() {
        System.out.println("Exiting Application. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}


/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/

