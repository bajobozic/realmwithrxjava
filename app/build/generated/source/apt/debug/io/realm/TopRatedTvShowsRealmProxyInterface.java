package io.realm;


public interface TopRatedTvShowsRealmProxyInterface {
    public Integer realmGet$page();
    public void realmSet$page(Integer value);
    public RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> realmGet$results();
    public void realmSet$results(RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> value);
    public Integer realmGet$totalResults();
    public void realmSet$totalResults(Integer value);
    public Integer realmGet$totalPages();
    public void realmSet$totalPages(Integer value);
}
