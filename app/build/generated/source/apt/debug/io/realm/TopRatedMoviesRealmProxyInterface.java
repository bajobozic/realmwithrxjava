package io.realm;


public interface TopRatedMoviesRealmProxyInterface {
    public Integer realmGet$page();
    public void realmSet$page(Integer value);
    public RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> realmGet$results();
    public void realmSet$results(RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> value);
    public Integer realmGet$totalResults();
    public void realmSet$totalResults(Integer value);
    public Integer realmGet$totalPages();
    public void realmSet$totalPages(Integer value);
}
