package com.project.udacity.popularmovies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mehseti on 21.2.2018.
 */

public class Movie implements Serializable
{
    @SerializedName("original_title")
    public String originalTitle;
    @SerializedName("poster_path")
    public String posterPath;
    @SerializedName("overview")
    public String overview; // plot synopsis
    @SerializedName("vote_average")
    public double voteAverage; // userRating
    @SerializedName("release_date")
    public String releaseDate;

    public Movie(String originalTitle, String posterPath, String overview, double voteAverage, String releaseDate)
    {
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }
    public Movie(){}
    public String getOriginalTitle() {
        return originalTitle;
    }
    public String getPosterPath() { return posterPath; }
    public String getOverview() {
        return overview;
    }
    public double getVoteAverage() {
        return voteAverage;
    }
    public String getReleaseDate() {
        return releaseDate;
    }

}
