package com.example.bajob.movieshatch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.MovieInfo;
import com.example.bajob.movieshatch.Pojo.SpokenLanguage;
import com.example.bajob.movieshatch.Pojo.TopRatedMovies;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Realm realmUi;
    private RealmResults<TopRatedMovies> topRatedMovies;
    private Subscription subscription;
    private RealmChangeListener<RealmResults<TopRatedMovies>> trmChangeListener = new RealmChangeListener<RealmResults<TopRatedMovies>>() {
        @Override
        public void onChange(RealmResults<TopRatedMovies> element) {
            //update UI here
            if (element.size() > 0)
                ((TdbMoviesAdapter) adapter).setMovieInfoList(element.get(0).getResults());
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupRecyclerView();
        initRealm();
        loadData();
    }

    private void initRealm() {
        realmUi = Realm.getDefaultInstance();
        topRatedMovies = realmUi.where(TopRatedMovies.class).equalTo("page", 1).findAllAsync();
        topRatedMovies.addChangeListener(trmChangeListener);
    }

    @Override
    protected void onDestroy() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
        realmUi.close();
        super.onDestroy();
    }

    private void loadData() {
        //TODO
        //extract observable to local variable
        subscription = ((MoviesHatchApp) getApplication()).getApiService().getTopRateedMovies(null, null, null)
                .zipWith(((MoviesHatchApp) getApplication()).getApiService().getImageConfiguration(), this::getFullPosterPath)
                .map(this::writeToRealm)
                .observeOn(AndroidSchedulers.mainThread())
                .map(this::readFromRealm)
                .subscribe(topRatedMovies -> ((TdbMoviesAdapter) adapter).setMovieInfoList(topRatedMovies.getResults()),
                        throwable -> Log.e(TAG, "onError: ", throwable)
                );
    }

    @NonNull
    private TopRatedMovies getFullPosterPath(TopRatedMovies topRatedMovies, ImageConfiguration imageConfiguration) {
        for (int i = 0; i < topRatedMovies.getResults().size(); i++) {
            MovieInfo info = topRatedMovies.getResults().get(i);
            String posterPath = info.getPosterPath();
            String baseUrl = imageConfiguration.getImages().getBaseUrl();
            String posterSize = imageConfiguration.getImages().getPosterSizes().get(1).getValue();
            String finalValue = baseUrl + posterSize + posterPath;
            info.setPosterPath(finalValue);
        }
        return topRatedMovies;
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new TdbMoviesAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private Integer writeToRealm(final TopRatedMovies movies) {
        final Realm currentThreadRealm = Realm.getDefaultInstance();
        currentThreadRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(movies);
            }
        });
        currentThreadRealm.close();
        return movies.getPage();

    }

    private TopRatedMovies readFromRealm(final Integer integer) {
        TopRatedMovies topRatedMovies;
        topRatedMovies = realmUi.where(TopRatedMovies.class).equalTo("page", integer).findFirst();
        return topRatedMovies;

    }

     /* SpokenLanguage spokenLanguage = new SpokenLanguage();
        spokenLanguage.setIso6391("de");
        spokenLanguage.setName("nemacki");
        Gson gson = new Gson();
        String json=gson.toJson(spokenLanguage);
        Log.d(TAG, "Created object is: "+spokenLanguage.toString());
        Log.d(TAG, "Created json is: "+json);*/
}
