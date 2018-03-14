package com.project.udacity.popularmovies;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.project.udacity.popularmovies.data.MoviesApi;
import com.project.udacity.popularmovies.ui.DetailScreenActivity;
import com.project.udacity.popularmovies.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.project.udacity.popularmovies.data.MovieResponse;

/**
 * Created by mehseti on 21.2.2018.
 */

public class JsonParse
{
    static List<Movie> movies = new ArrayList<>();
    static OkHttpClient httpClient;
    static Call<MovieResponse> call;

    @SuppressLint("StringFormatInvalid")
    public static void parseJson(final RecyclerView recyclerView, final MainActivity mainActivity, String movieType)
    {
        httpClient = new OkHttpClient.Builder().build();
        Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl(ApiVariables.moviePopular)
                        .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit =  builder.client(httpClient).build();
        MoviesApi moviesApi =  retrofit.create(MoviesApi.class);
        if(movieType.equals(mainActivity.getApplicationContext().getResources().getString(R.string.popular)))
        {
            call = moviesApi.listPopularMovies(ApiVariables.apiKey);
            mainActivity.getSupportActionBar().setTitle(R.string.popular_movies);
        }
        else if(movieType.equals(mainActivity.getApplicationContext().getResources().getString(R.string.top_rated)))
        {
            call = moviesApi.listTopRatedMovies(ApiVariables.apiKey);
            mainActivity.getSupportActionBar().setTitle(R.string.top_rated_movies);
        }
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response)
            {
                Log.d("Movies", response.body().getMovies().toString());
                movies = response.body().getMovies();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.movie_list_item, mainActivity.getApplicationContext(), new MoviesAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Movie movie) {
                        Intent intent = new Intent(mainActivity.getApplicationContext(),DetailScreenActivity.class);
                        intent.putExtra("movie",movie);
                        mainActivity.getApplicationContext().startActivity(intent);
                    }
                }));
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t)
            {}
        });
    }
}
