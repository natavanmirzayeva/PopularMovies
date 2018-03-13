package com.project.udacity.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.project.udacity.popularmovies.ui.DetailScreenActivity;
import com.squareup.picasso.Picasso;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by mehseti on 24.2.2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>
{

    private static List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout moviesLayout;
        ImageView movieImage;

        public MovieViewHolder(View v, final Context context)
        {
            super(v);
            moviesLayout =  v.findViewById(R.id.movie_list);
            movieImage =  v.findViewById(R.id.poster_path);

            //Detail Screen will open, if the movie image poster is clicked
            movieImage.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                    {
                        Movie movie = movies.get(position);
                        Intent intent = new Intent(context,DetailScreenActivity.class);
                        intent.putExtra("movie",movie);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context)
    {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view,parent.getContext());
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position)
    {
        Picasso.with(context).load(ApiVariables.imagePath+movies.get(position).getPosterPath()).into(holder.movieImage);
    }
    @Override
    public int getItemCount()
    {
        return movies.size();
    }
}
