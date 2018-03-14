package com.project.udacity.popularmovies;

import android.content.ClipData;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mehseti on 21.2.2018.
 */

public class Movie implements Parcelable
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
    public Movie(Parcel in)
    {
        this.originalTitle = in.readString();
        this.posterPath = in.readString();
        this.overview = in.readString();
        this.voteAverage = in.readDouble();
        this.releaseDate = in.readString();
    }
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(originalTitle);
        dest.writeString(posterPath);
        dest.writeString(overview);
        dest.writeDouble(voteAverage);
        dest.writeString(releaseDate);
    }
    public static final Parcelable.Creator CREATOR  = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
