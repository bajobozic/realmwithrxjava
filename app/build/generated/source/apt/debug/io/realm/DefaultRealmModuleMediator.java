package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.Genre.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.TvNetwork.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.Season.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.ProductionCompany.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        modelClasses.add(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return io.realm.TopRatedSearchTvShowsRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return io.realm.ProductionCountryRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return io.realm.GenreRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return io.realm.TopRatedTvShowsRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return io.realm.TvShowInfoRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return io.realm.TvNetworkRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return io.realm.MovieInfoRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return io.realm.MovieDetailedInfoRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return io.realm.SeasonRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return io.realm.TvShowDetailedInfoRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return io.realm.TopRatedMoviesRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return io.realm.CreatedByRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return io.realm.SpokenLanguageRealmProxy.initTable(sharedRealm);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return io.realm.TopRatedSearchTvShowsRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return io.realm.ProductionCountryRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return io.realm.GenreRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return io.realm.TopRatedTvShowsRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return io.realm.TvShowInfoRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return io.realm.TvNetworkRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return io.realm.MovieInfoRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return io.realm.MovieDetailedInfoRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return io.realm.SeasonRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return io.realm.TvShowDetailedInfoRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return io.realm.TopRatedMoviesRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return io.realm.CreatedByRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return io.realm.SpokenLanguageRealmProxy.createRealmObjectSchema(realmSchema);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return io.realm.TopRatedSearchTvShowsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return io.realm.ProductionCountryRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return io.realm.GenreRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return io.realm.TopRatedTvShowsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return io.realm.TvShowInfoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return io.realm.TvNetworkRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return io.realm.MovieInfoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return io.realm.MovieDetailedInfoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return io.realm.SeasonRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return io.realm.TvShowDetailedInfoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return io.realm.TopRatedMoviesRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return io.realm.CreatedByRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return io.realm.SpokenLanguageRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return io.realm.TopRatedSearchTvShowsRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return io.realm.ProductionCountryRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return io.realm.GenreRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return io.realm.TopRatedTvShowsRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return io.realm.TvShowInfoRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return io.realm.TvNetworkRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return io.realm.MovieInfoRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return io.realm.MovieDetailedInfoRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return io.realm.SeasonRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return io.realm.TvShowDetailedInfoRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return io.realm.TopRatedMoviesRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return io.realm.CreatedByRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return io.realm.SpokenLanguageRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return io.realm.TopRatedSearchTvShowsRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return io.realm.ProductionCountryRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return io.realm.GenreRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return io.realm.TopRatedTvShowsRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return io.realm.TvShowInfoRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return io.realm.TvNetworkRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return io.realm.MovieInfoRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return io.realm.MovieDetailedInfoRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return io.realm.SeasonRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return io.realm.TvShowDetailedInfoRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return io.realm.TopRatedMoviesRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return io.realm.CreatedByRealmProxy.getTableName();
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return io.realm.SpokenLanguageRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
                return clazz.cast(new io.realm.TopRatedSearchTvShowsRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
                return clazz.cast(new io.realm.ProductionCountryRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
                return clazz.cast(new io.realm.GenreRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
                return clazz.cast(new io.realm.TopRatedTvShowsRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
                return clazz.cast(new io.realm.TvShowInfoRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
                return clazz.cast(new io.realm.TvNetworkRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
                return clazz.cast(new io.realm.MovieInfoRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
                return clazz.cast(new io.realm.MovieDetailedInfoRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
                return clazz.cast(new io.realm.SeasonRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
                return clazz.cast(new io.realm.TvShowDetailedInfoRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
                return clazz.cast(new io.realm.ProductionCompanyRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
                return clazz.cast(new io.realm.TopRatedMoviesRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
                return clazz.cast(new io.realm.CreatedByRealmProxy());
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
                return clazz.cast(new io.realm.SpokenLanguageRealmProxy());
            } else {
                throw getMissingProxyClassException(clazz);
            }
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return clazz.cast(io.realm.TopRatedSearchTvShowsRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return clazz.cast(io.realm.ProductionCountryRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.ProductionCountry) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return clazz.cast(io.realm.GenreRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.Genre) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return clazz.cast(io.realm.TopRatedTvShowsRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return clazz.cast(io.realm.TvShowInfoRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvShowInfo) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return clazz.cast(io.realm.TvNetworkRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvNetwork) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return clazz.cast(io.realm.MovieInfoRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.MovieInfo) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return clazz.cast(io.realm.MovieDetailedInfoRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return clazz.cast(io.realm.SeasonRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.Season) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return clazz.cast(io.realm.TvShowDetailedInfoRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return clazz.cast(io.realm.ProductionCompanyRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.ProductionCompany) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return clazz.cast(io.realm.TopRatedMoviesRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedMovies) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return clazz.cast(io.realm.CreatedByRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.CreatedBy) obj, update, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return clazz.cast(io.realm.SpokenLanguageRealmProxy.copyOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.SpokenLanguage) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            io.realm.TopRatedSearchTvShowsRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            io.realm.ProductionCountryRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.ProductionCountry) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            io.realm.GenreRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.Genre) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            io.realm.TopRatedTvShowsRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            io.realm.TvShowInfoRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TvShowInfo) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            io.realm.TvNetworkRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TvNetwork) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            io.realm.MovieInfoRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.MovieInfo) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            io.realm.MovieDetailedInfoRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            io.realm.SeasonRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.Season) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            io.realm.TvShowDetailedInfoRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            io.realm.ProductionCompanyRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.ProductionCompany) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            io.realm.TopRatedMoviesRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TopRatedMovies) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            io.realm.CreatedByRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.CreatedBy) object, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            io.realm.SpokenLanguageRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.SpokenLanguage) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
                io.realm.TopRatedSearchTvShowsRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
                io.realm.ProductionCountryRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.ProductionCountry) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
                io.realm.GenreRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.Genre) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
                io.realm.TopRatedTvShowsRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
                io.realm.TvShowInfoRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TvShowInfo) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
                io.realm.TvNetworkRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TvNetwork) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
                io.realm.MovieInfoRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.MovieInfo) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
                io.realm.MovieDetailedInfoRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
                io.realm.SeasonRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.Season) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
                io.realm.TvShowDetailedInfoRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
                io.realm.ProductionCompanyRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.ProductionCompany) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
                io.realm.TopRatedMoviesRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.TopRatedMovies) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
                io.realm.CreatedByRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.CreatedBy) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
                io.realm.SpokenLanguageRealmProxy.insert(realm, (com.example.bajob.movieshatch.Pojo.SpokenLanguage) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
                    io.realm.TopRatedSearchTvShowsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
                    io.realm.ProductionCountryRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
                    io.realm.GenreRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
                    io.realm.TopRatedTvShowsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
                    io.realm.TvShowInfoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
                    io.realm.TvNetworkRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
                    io.realm.MovieInfoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
                    io.realm.MovieDetailedInfoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
                    io.realm.SeasonRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
                    io.realm.TvShowDetailedInfoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
                    io.realm.ProductionCompanyRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
                    io.realm.TopRatedMoviesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
                    io.realm.CreatedByRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
                    io.realm.SpokenLanguageRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            io.realm.TopRatedSearchTvShowsRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            io.realm.ProductionCountryRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.ProductionCountry) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            io.realm.GenreRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.Genre) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            io.realm.TopRatedTvShowsRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            io.realm.TvShowInfoRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvShowInfo) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            io.realm.TvNetworkRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvNetwork) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            io.realm.MovieInfoRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.MovieInfo) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            io.realm.MovieDetailedInfoRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            io.realm.SeasonRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.Season) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            io.realm.TvShowDetailedInfoRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            io.realm.ProductionCompanyRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.ProductionCompany) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            io.realm.TopRatedMoviesRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedMovies) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            io.realm.CreatedByRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.CreatedBy) obj, cache);
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            io.realm.SpokenLanguageRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.SpokenLanguage) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
                io.realm.TopRatedSearchTvShowsRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
                io.realm.ProductionCountryRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.ProductionCountry) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
                io.realm.GenreRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.Genre) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
                io.realm.TopRatedTvShowsRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
                io.realm.TvShowInfoRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvShowInfo) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
                io.realm.TvNetworkRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvNetwork) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
                io.realm.MovieInfoRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.MovieInfo) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
                io.realm.MovieDetailedInfoRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
                io.realm.SeasonRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.Season) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
                io.realm.TvShowDetailedInfoRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
                io.realm.ProductionCompanyRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.ProductionCompany) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
                io.realm.TopRatedMoviesRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.TopRatedMovies) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
                io.realm.CreatedByRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.CreatedBy) object, cache);
            } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
                io.realm.SpokenLanguageRealmProxy.insertOrUpdate(realm, (com.example.bajob.movieshatch.Pojo.SpokenLanguage) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
                    io.realm.TopRatedSearchTvShowsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
                    io.realm.ProductionCountryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
                    io.realm.GenreRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
                    io.realm.TopRatedTvShowsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
                    io.realm.TvShowInfoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
                    io.realm.TvNetworkRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
                    io.realm.MovieInfoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
                    io.realm.MovieDetailedInfoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
                    io.realm.SeasonRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
                    io.realm.TvShowDetailedInfoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
                    io.realm.ProductionCompanyRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
                    io.realm.TopRatedMoviesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
                    io.realm.CreatedByRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
                    io.realm.SpokenLanguageRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return clazz.cast(io.realm.TopRatedSearchTvShowsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return clazz.cast(io.realm.ProductionCountryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return clazz.cast(io.realm.GenreRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return clazz.cast(io.realm.TopRatedTvShowsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return clazz.cast(io.realm.TvShowInfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return clazz.cast(io.realm.TvNetworkRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return clazz.cast(io.realm.MovieInfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return clazz.cast(io.realm.MovieDetailedInfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return clazz.cast(io.realm.SeasonRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return clazz.cast(io.realm.TvShowDetailedInfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return clazz.cast(io.realm.ProductionCompanyRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return clazz.cast(io.realm.TopRatedMoviesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return clazz.cast(io.realm.CreatedByRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return clazz.cast(io.realm.SpokenLanguageRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return clazz.cast(io.realm.TopRatedSearchTvShowsRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return clazz.cast(io.realm.ProductionCountryRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return clazz.cast(io.realm.GenreRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return clazz.cast(io.realm.TopRatedTvShowsRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return clazz.cast(io.realm.TvShowInfoRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return clazz.cast(io.realm.TvNetworkRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return clazz.cast(io.realm.MovieInfoRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return clazz.cast(io.realm.MovieDetailedInfoRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return clazz.cast(io.realm.SeasonRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return clazz.cast(io.realm.TvShowDetailedInfoRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return clazz.cast(io.realm.ProductionCompanyRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return clazz.cast(io.realm.TopRatedMoviesRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return clazz.cast(io.realm.CreatedByRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return clazz.cast(io.realm.SpokenLanguageRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows.class)) {
            return clazz.cast(io.realm.TopRatedSearchTvShowsRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCountry.class)) {
            return clazz.cast(io.realm.ProductionCountryRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.ProductionCountry) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Genre.class)) {
            return clazz.cast(io.realm.GenreRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.Genre) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class)) {
            return clazz.cast(io.realm.TopRatedTvShowsRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.TopRatedTvShows) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowInfo.class)) {
            return clazz.cast(io.realm.TvShowInfoRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.TvShowInfo) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvNetwork.class)) {
            return clazz.cast(io.realm.TvNetworkRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.TvNetwork) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieInfo.class)) {
            return clazz.cast(io.realm.MovieInfoRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.MovieInfo) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class)) {
            return clazz.cast(io.realm.MovieDetailedInfoRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.Season.class)) {
            return clazz.cast(io.realm.SeasonRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.Season) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class)) {
            return clazz.cast(io.realm.TvShowDetailedInfoRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.ProductionCompany.class)) {
            return clazz.cast(io.realm.ProductionCompanyRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.ProductionCompany) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class)) {
            return clazz.cast(io.realm.TopRatedMoviesRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.TopRatedMovies) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.CreatedBy.class)) {
            return clazz.cast(io.realm.CreatedByRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.CreatedBy) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class)) {
            return clazz.cast(io.realm.SpokenLanguageRealmProxy.createDetachedCopy((com.example.bajob.movieshatch.Pojo.SpokenLanguage) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
