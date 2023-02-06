package com.example.cinemacgp;

import com.example.cinemacgp.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieServices {
    @GET("v1/f97fdccd-c441-48e7-851f-3439b2188866")
    Call<List<Movie>> getAllMovie();
}
