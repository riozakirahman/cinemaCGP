package com.example.cinemacgp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {
    ImageView poster;
    TextView title, rating, overview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        poster = findViewById(R.id.idMovieImg);
        title = findViewById(R.id.idTVTitle);
        rating = findViewById(R.id.idTVRate);
        overview = findViewById(R.id.idTVOverview);

        //get intent
        Intent intent = getIntent();
        String titleI = intent.getExtras().getString("title");
        String ratingI = intent.getExtras().getString("rating");
        String overviewI = intent.getExtras().getString("overview");
        String posterI = intent.getExtras().getString("poster");
        title.setText(titleI);
        rating.setText(ratingI);
        overview.setText(overviewI);
        Glide.with(DetailMovieActivity.this).load(posterI).into(poster);
    }
}