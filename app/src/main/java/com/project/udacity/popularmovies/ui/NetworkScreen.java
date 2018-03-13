package com.project.udacity.popularmovies.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.project.udacity.popularmovies.R;

/**
 * Created by mehseti on 7.3.2018.
 */

public class NetworkScreen extends android.support.v4.app.Fragment
{

    public static NetworkScreen newInstance() {
        Bundle args = new Bundle();
        NetworkScreen fragment = new NetworkScreen();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.networkscreen,container,false);
        return v;
    }
}
