package com.project.udacity.popularmovies.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.project.udacity.popularmovies.ApiVariables;
import com.project.udacity.popularmovies.Movie;
import com.project.udacity.popularmovies.R;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailScreenActivity extends AppCompatActivity
{
    @BindView(R.id.poster_path) ImageView posterPath;
    @BindView(R.id.overview) TextView overView;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.user_rating_value) TextView userRating;
    @BindView(R.id.release_date_value) TextView releaseDate;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Movie movie = intent.getParcelableExtra("movie");
        fillDetailScreen(movie);
    }

    void fillDetailScreen(Movie movie)
    {
        overView.setText(movie.getOverview());
        title.setText(movie.getOriginalTitle());
        userRating.setText(String.valueOf(movie.getVoteAverage()));
        releaseDate.setText(movie.getReleaseDate());
        Picasso.with(this).load(ApiVariables.imagePath+movie.getPosterPath()).into(posterPath);
    }
}
