package com.example.bajob.movieshatch.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by bajob on 1/18/2017.
 */
public class TopRatedSearchTvShows extends RealmObject implements TopRatedInteface{
    @SerializedName("page")
    @Expose
    @PrimaryKey
    private Integer page;

    @SerializedName("results")
    @Expose
    private RealmList<TvShowInfo> results = null;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public RealmList<TvShowInfo> getResults() {
        return results;
    }

    public void setResults(RealmList<TvShowInfo> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
