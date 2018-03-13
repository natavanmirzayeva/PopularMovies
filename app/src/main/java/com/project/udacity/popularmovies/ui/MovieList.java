package com.project.udacity.popularmovies.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.project.udacity.popularmovies.JsonParse;
import com.project.udacity.popularmovies.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mehseti on 13.3.2018.
 */

public class MovieList extends android.support.v4.app.Fragment implements SharedPreferences.OnSharedPreferenceChangeListener
{
    SharedPreferences sharedPreferences;
    @BindView(R.id.movies_recycler_view) RecyclerView recyclerView;
    static Context fContext;

    public static MovieList newInstance(Context context)
    {
        Bundle args = new Bundle();
        MovieList fragment = new MovieList();
        fContext = context;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        ButterKnife.bind(this,view);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        String control = sharedPreferences.getString(getResources().getString(R.string.key),null);
        fillRecyclerView(control);
        return  view;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        String control = sharedPreferences.getString(key,null); // The content of Recycler View depends on the Settings screen,which will change due to shared preferences
        fillRecyclerView(control);
    }

    void fillRecyclerView(String control)
    {
        // Recycler View content is got in JsonParse class
        JsonParse.parseJson(recyclerView, (MainActivity) fContext,control);
        recyclerView.setLayoutManager(new GridLayoutManager(fContext,2));
    }
}
