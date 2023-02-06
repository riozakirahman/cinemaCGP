package com.example.cinemacgp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cinemacgp.DetailMovieActivity;
import com.example.cinemacgp.R;
import com.example.cinemacgp.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent,false);




        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(movie.getRating().toString());
        holder.overview.setText(movie.getOverview());
        Glide.with(context).load(movie.getPoster()).into(holder.poster);

        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetailMovieActivity.class);
                i.putExtra("title", movie.getTitle().toString());
                i.putExtra("rating", movie.getRating().toString());
                i.putExtra("overview", movie.getOverview().toString());
                i.putExtra("poster", movie.getPoster().toString());
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title, rating,overview;
        Button book;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.idMovieImg);
            title = itemView.findViewById(R.id.idTVTitle);
            rating = itemView.findViewById(R.id.idTVRate);
            overview = itemView.findViewById(R.id.idTVOverview);
            book = itemView.findViewById(R.id.idBtnBook);
//


        }
    }
}
