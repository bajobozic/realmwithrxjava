package com.example.bajob.movieshatch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Pojo.TvShowInfo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by bajob on 1/19/2017.
 */
public class TdbMoviesAdapter extends android.support.v7.widget.RecyclerView.Adapter<TdbMoviesAdapter.MoviesHolder> {
    private RealmResults<TopRatedTvShows> element;
    private int maxPageResultNum;
    private int cachedListSize;
    private TvShowIdDelegate tvShowIdDelegate;
    public TdbMoviesAdapter(RealmResults<TopRatedTvShows> element,TvShowIdDelegate tvShowIdDelegate) {
        this.element = element;
        this.cachedListSize = 0;
        this.maxPageResultNum = 0;
        this.tvShowIdDelegate = tvShowIdDelegate;
    }

    public void setList(final RealmResults<TopRatedTvShows> element) {
        this.element = element;
        notifyDataSetChanged();
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoviesHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_item, parent, false),this);
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {
        final TvShowInfo listElement = getListElement(position);
        if (listElement != null) {
            final String posterPath = listElement.getPosterPath();
            Picasso.with(holder.itemView.getContext()).load(posterPath)
                    .placeholder(R.drawable.leak_canary_icon)
                    .error(R.drawable.leak_canary_icon)
                    .fit()
                    .centerCrop()
                    .into(holder.imageView);
            holder.textView.setText(listElement.getOriginalName());
            holder.textView1.setText(listElement.getOverview());
        }
    }

    @Override
    public int getItemCount() {
        if (element == null)
            return 0;
        cachedListSize = getListSize();
        return cachedListSize;
    }

    private int getListSize() {
        int size = 0;
        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getResults() != null) {
                int temp = element.get(i).getResults().size();
                size += temp;
                maxPageResultNum = Math.max(maxPageResultNum, temp);
            }
        }
        return size;
    }

    private TvShowInfo getListElement(int position) {
        if (cachedListSize > 0) {
            int currentPage;
            if (position == 0 || maxPageResultNum > position) {
                currentPage = 0;
            } else {
                currentPage = (int) Math.ceil(position / maxPageResultNum);
            }
            return element.get(currentPage).getResults().get(position % maxPageResultNum);
        }

        return null;
    }

    static class MoviesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TdbMoviesAdapter adapter;
        @BindView(R.id.imageView3)
        ImageView imageView;
        @BindView(R.id.textView7)
        TextView textView;
        @BindView(R.id.textView8)
        TextView textView1;

        public MoviesHolder(View itemView,TdbMoviesAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            adapter.tvShowIdDelegate.handleClickPosition(position);
        }

    }

    interface TvShowIdDelegate {
        void handleClickPosition(final int tvShowId);
    }
}

