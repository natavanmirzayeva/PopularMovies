package com.project.udacity.popularmovies.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mehseti on 21.2.2018.
 */

public interface MoviesApi
{
    @GET("movie/popular/?")
    public Call<MovieResponse> listPopularMovies(@Query("api_key") String keyApi);

    @GET("movie/top_rated/?")
    public Call<MovieResponse> listTopRatedMovies(@Query("api_key") String keyApi);
}
