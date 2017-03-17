package com.example.bajob.movieshatch.Pojo;

import io.realm.RealmList;
import io.realm.RealmModel;

/**
 * Created by bajob on 3/13/2017.
 */

public interface TopRatedInteface extends RealmModel {
    public Integer getPage();

    public void setPage(Integer page);

    public RealmList<TvShowInfo> getResults();

    public void setResults(RealmList<TvShowInfo> results);

    public Integer getTotalResults();

    public void setTotalResults(Integer totalResults);

    public Integer getTotalPages();

    public void setTotalPages(Integer totalPages);
}
