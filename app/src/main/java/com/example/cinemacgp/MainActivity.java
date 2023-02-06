package com.example.cinemacgp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.cinemacgp.adapter.MovieAdapter;
import com.example.cinemacgp.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;;
    private RecyclerView recyclerView;
    private List<Movie> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //retrofit
        MovieServices service = ApiClient.getRetrofitInstance().create(MovieServices.class);
        Call<List<Movie>> call = service.getAllMovie();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, retrofit2.Response<List<Movie>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed to connect", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void generateDataList(List<Movie> movieList) {
        recyclerView = findViewById(R.id.idRvMovie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MovieAdapter adapter = new MovieAdapter(MainActivity.this,movieList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.locationAlpha:
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
                return true;

            case R.id.locationBeta:
                Intent i2 = new Intent(MainActivity.this,MapsActivityBeta.class);
                startActivity(i2);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}