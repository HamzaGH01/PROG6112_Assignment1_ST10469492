/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG6112A1;
/**
 *
 * @author ST10469492 Hamza Goolam Hoosen
 */
public class TvShow {
    public String TvShowId;
    public String TvShowName;
    public String TvShowAgeRestriction;
    public String TvShowNumberOfEpisodes;

    public TvShow(String tvShowId, String tvShowName, String tvShowAgeRestriction, String tvShowNumberOfEpisodes) {
        this.TvShowId = tvShowId;
        this.TvShowName = tvShowName;
        this.TvShowAgeRestriction = tvShowAgeRestriction;
        this.TvShowNumberOfEpisodes = tvShowNumberOfEpisodes;
    }

    public String getTvShowId() {
        return TvShowId;
    }

    public void setTvShowId(String tvShowId) {
        TvShowId = tvShowId;
    }

    public String getTvShowName() {
        return TvShowName;
    }

    public void setTvShowName(String tvShowName) {
        TvShowName = tvShowName;
    }

    public String getTvShowAgeRestriction() {
        return TvShowAgeRestriction;
    }

    public void setTvShowAgeRestriction(String tvShowAgeRestriction) {
        TvShowAgeRestriction = tvShowAgeRestriction;
    }

    public String getTvShowNumberOfEpisodes() {
        return TvShowNumberOfEpisodes;
    }

    public void setTvShowNumberOfEpisodes(String tvShowNumberOfEpisodes) {
        TvShowNumberOfEpisodes = tvShowNumberOfEpisodes;
    }

    @Override
    public String toString() {
        return "SERIES ID: " + TvShowId +
               "\nSERIES NAME: " + TvShowName +
               "\nSERIES AGE RESTRICTION: " + TvShowAgeRestriction +
               "\nSERIES NUMBER OF EPISODES: " + TvShowNumberOfEpisodes;
    }
}

/*APA STYLE REFRENCE LIST:
OpenAI. (2024). ChatGPT (GPT-4.5). https://chat.openai.com/
Google. (2024). Gemini (formerly Bard). https://gemini.google.com/
Google. (n.d.). Google Search. Retrieved April 22, 2025, from https://www.google.com/
YouTube. (n.d.). YouTube. Retrieved April 22, 2025, from https://www.youtube.com/
*/