/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package PROG6112A1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10469492 Hamza Goolam Hoosen
 */

public class TvShowManagerTest {

    private TvShowManager tvShowManager;

    @BeforeEach
    void setUp() {
        tvShowManager = new TvShowManager();
        tvShowManager.addTvShow(new TvShow("101", "Extreme Sports", "12", "10"));
        tvShowManager.addTvShow(new TvShow("102", "Bargain Hunters", "10", "15"));
    }

    @Test
    void TestSearchTvShow() {
        TvShow foundTvShow = tvShowManager.findTvShowById("101");
        assertNotNull(foundTvShow, "TvShow 101 should be found");
        assertEquals("Extreme Sports", foundTvShow.getTvShowName());
        assertEquals("12", foundTvShow.getTvShowAgeRestriction());
        assertEquals("10", foundTvShow.getTvShowNumberOfEpisodes());
    }

    @Test
    void TestSearchTvShow_NotFound() {
        TvShow foundTvShow = tvShowManager.findTvShowById("999");
        assertNull(foundTvShow, "TvShow 999 should not be found");
    }

    @Test
    void TestUpdateTvShow() {
        boolean updated = tvShowManager.updateTvShow("101", "Extreme Sports 2025", "14", "12");
        assertTrue(updated, "TvShow 101 should be updated");

        TvShow updatedTvShow = tvShowManager.findTvShowById("101");
        assertNotNull(updatedTvShow);
        assertEquals("Extreme Sports 2025", updatedTvShow.getTvShowName());
        assertEquals("14", updatedTvShow.getTvShowAgeRestriction());
        assertEquals("12", updatedTvShow.getTvShowNumberOfEpisodes());
    }

    @Test
    void TestDeleteTvShow() {
        boolean deleted = tvShowManager.deleteTvShow("101");
        assertTrue(deleted, "TvShow 101 should be deleted");
        assertNull(tvShowManager.findTvShowById("101"), "TvShow 101 should no longer exist");
    }

    @Test
    void TestDeleteTvShow_NotFound() {
        boolean deleted = tvShowManager.deleteTvShow("999");
        assertFalse(deleted, "TvShow 999 should not be deleted as it doesn't exist");
    }

    @Test
    void TestAgeRestriction_Valid() {
        assertTrue(tvShowManager.validateAgeRestriction("10"), "Age 10 should be valid");
        assertTrue(tvShowManager.validateAgeRestriction("2"), "Age 2 should be valid");
        assertTrue(tvShowManager.validateAgeRestriction("18"), "Age 18 should be valid");
    }

    @Test
    void TestAgeRestriction_InValid() {
        assertFalse(tvShowManager.validateAgeRestriction("1"), "Age 1 should be invalid (below 2)");
        assertFalse(tvShowManager.validateAgeRestriction("19"), "Age 19 should be invalid (above 18)");
        assertFalse(tvShowManager.validateAgeRestriction("abc"), "Non-numeric age should be invalid");
        assertFalse(tvShowManager.validateAgeRestriction(""), "Empty age should be invalid");
    }

    @Test
    void TestAddTvShow_DuplicateId() {
        TvShow duplicateTvShow = new TvShow("101", "Another Show", "10", "5");
        boolean added = tvShowManager.addTvShow(duplicateTvShow);
        assertFalse(added, "Should not be able to add a TV show with a duplicate ID");
        TvShow originalTvShow = tvShowManager.findTvShowById("101");
        assertEquals("Extreme Sports", originalTvShow.getTvShowName(), "Original TV show data should remain unchanged");
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/