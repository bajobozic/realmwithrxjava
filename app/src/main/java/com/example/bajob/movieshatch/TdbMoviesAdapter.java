package com.example.bajob.movieshatch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Pojo.TvShowInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by bajob on 1/19/2017.
 */
public class TdbMoviesAdapter extends android.support.v7.widget.RecyclerView.Adapter<TdbMoviesAdapter.MoviesHolder> {
    private List<TvShowInfo> movieInfoList = new ArrayList<>();
    //private RealmResults<TopRatedTvShows> element;
    public TdbMoviesAdapter(/*RealmResults<TopRatedTvShows> element*/) {
      /*  this.element=element;
        for (int i = 0; i < this.element.size(); i++) {
            movieInfoList.addAll(this.element.get(i).getResults());
        }*/
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoviesHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {
        final String posterPath = movieInfoList.get(position).getPosterPath();
        Picasso.with(holder.itemView.getContext()).load(posterPath)
                .placeholder(R.drawable.leak_canary_icon)
                .error(R.drawable.leak_canary_icon)
                .fit()
                .centerCrop()
                .into(holder.imageView);
        holder.textView.setText(movieInfoList.get(position).getOriginalName());
        holder.textView1.setText(movieInfoList.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return movieInfoList.size();
    }

    public void setMovieInfoList(final RealmResults<TopRatedTvShows> element,final Integer page) {
        this.movieInfoList.clear();
        for (int i = 0; i < page; i++) {
            this.movieInfoList.addAll(element.get(i).getResults());
        }
        notifyDataSetChanged();
    }

    static class MoviesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView3)
        ImageView imageView;
        @BindView(R.id.textView7)
        TextView textView;
        @BindView(R.id.textView8)
        TextView textView1;

        public MoviesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

