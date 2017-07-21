package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieDetailedInfoRealmProxy extends com.example.bajob.movieshatch.Pojo.MovieDetailedInfo
    implements RealmObjectProxy, MovieDetailedInfoRealmProxyInterface {

    static final class MovieDetailedInfoColumnInfo extends ColumnInfo
        implements Cloneable {

        public long adultIndex;
        public long backdropPathIndex;
        public long budgetIndex;
        public long genresIndex;
        public long homepageIndex;
        public long idIndex;
        public long imdbIdIndex;
        public long originalLanguageIndex;
        public long originalTitleIndex;
        public long overviewIndex;
        public long popularityIndex;
        public long posterPathIndex;
        public long productionCompaniesIndex;
        public long productionCountriesIndex;
        public long releaseDateIndex;
        public long revenueIndex;
        public long runtimeIndex;
        public long spokenLanguagesIndex;
        public long statusIndex;
        public long taglineIndex;
        public long titleIndex;
        public long videoIndex;
        public long voteAverageIndex;
        public long voteCountIndex;

        MovieDetailedInfoColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(24);
            this.adultIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "adult");
            indicesMap.put("adult", this.adultIndex);
            this.backdropPathIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "backdropPath");
            indicesMap.put("backdropPath", this.backdropPathIndex);
            this.budgetIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "budget");
            indicesMap.put("budget", this.budgetIndex);
            this.genresIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "genres");
            indicesMap.put("genres", this.genresIndex);
            this.homepageIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "homepage");
            indicesMap.put("homepage", this.homepageIndex);
            this.idIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "id");
            indicesMap.put("id", this.idIndex);
            this.imdbIdIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "imdbId");
            indicesMap.put("imdbId", this.imdbIdIndex);
            this.originalLanguageIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "originalLanguage");
            indicesMap.put("originalLanguage", this.originalLanguageIndex);
            this.originalTitleIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "originalTitle");
            indicesMap.put("originalTitle", this.originalTitleIndex);
            this.overviewIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "overview");
            indicesMap.put("overview", this.overviewIndex);
            this.popularityIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "popularity");
            indicesMap.put("popularity", this.popularityIndex);
            this.posterPathIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "posterPath");
            indicesMap.put("posterPath", this.posterPathIndex);
            this.productionCompaniesIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "productionCompanies");
            indicesMap.put("productionCompanies", this.productionCompaniesIndex);
            this.productionCountriesIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "productionCountries");
            indicesMap.put("productionCountries", this.productionCountriesIndex);
            this.releaseDateIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "releaseDate");
            indicesMap.put("releaseDate", this.releaseDateIndex);
            this.revenueIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "revenue");
            indicesMap.put("revenue", this.revenueIndex);
            this.runtimeIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "runtime");
            indicesMap.put("runtime", this.runtimeIndex);
            this.spokenLanguagesIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "spokenLanguages");
            indicesMap.put("spokenLanguages", this.spokenLanguagesIndex);
            this.statusIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "status");
            indicesMap.put("status", this.statusIndex);
            this.taglineIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "tagline");
            indicesMap.put("tagline", this.taglineIndex);
            this.titleIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "title");
            indicesMap.put("title", this.titleIndex);
            this.videoIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "video");
            indicesMap.put("video", this.videoIndex);
            this.voteAverageIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "voteAverage");
            indicesMap.put("voteAverage", this.voteAverageIndex);
            this.voteCountIndex = getValidColumnIndex(path, table, "MovieDetailedInfo", "voteCount");
            indicesMap.put("voteCount", this.voteCountIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final MovieDetailedInfoColumnInfo otherInfo = (MovieDetailedInfoColumnInfo) other;
            this.adultIndex = otherInfo.adultIndex;
            this.backdropPathIndex = otherInfo.backdropPathIndex;
            this.budgetIndex = otherInfo.budgetIndex;
            this.genresIndex = otherInfo.genresIndex;
            this.homepageIndex = otherInfo.homepageIndex;
            this.idIndex = otherInfo.idIndex;
            this.imdbIdIndex = otherInfo.imdbIdIndex;
            this.originalLanguageIndex = otherInfo.originalLanguageIndex;
            this.originalTitleIndex = otherInfo.originalTitleIndex;
            this.overviewIndex = otherInfo.overviewIndex;
            this.popularityIndex = otherInfo.popularityIndex;
            this.posterPathIndex = otherInfo.posterPathIndex;
            this.productionCompaniesIndex = otherInfo.productionCompaniesIndex;
            this.productionCountriesIndex = otherInfo.productionCountriesIndex;
            this.releaseDateIndex = otherInfo.releaseDateIndex;
            this.revenueIndex = otherInfo.revenueIndex;
            this.runtimeIndex = otherInfo.runtimeIndex;
            this.spokenLanguagesIndex = otherInfo.spokenLanguagesIndex;
            this.statusIndex = otherInfo.statusIndex;
            this.taglineIndex = otherInfo.taglineIndex;
            this.titleIndex = otherInfo.titleIndex;
            this.videoIndex = otherInfo.videoIndex;
            this.voteAverageIndex = otherInfo.voteAverageIndex;
            this.voteCountIndex = otherInfo.voteCountIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final MovieDetailedInfoColumnInfo clone() {
            return (MovieDetailedInfoColumnInfo) super.clone();
        }

    }
    private MovieDetailedInfoColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.MovieDetailedInfo> proxyState;
    private RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresRealmList;
    private RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesRealmList;
    private RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesRealmList;
    private RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("adult");
        fieldNames.add("backdropPath");
        fieldNames.add("budget");
        fieldNames.add("genres");
        fieldNames.add("homepage");
        fieldNames.add("id");
        fieldNames.add("imdbId");
        fieldNames.add("originalLanguage");
        fieldNames.add("originalTitle");
        fieldNames.add("overview");
        fieldNames.add("popularity");
        fieldNames.add("posterPath");
        fieldNames.add("productionCompanies");
        fieldNames.add("productionCountries");
        fieldNames.add("releaseDate");
        fieldNames.add("revenue");
        fieldNames.add("runtime");
        fieldNames.add("spokenLanguages");
        fieldNames.add("status");
        fieldNames.add("tagline");
        fieldNames.add("title");
        fieldNames.add("video");
        fieldNames.add("voteAverage");
        fieldNames.add("voteCount");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MovieDetailedInfoRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MovieDetailedInfoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.MovieDetailedInfo>(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$adult() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.adultIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.adultIndex);
    }

    public void realmSet$adult(Boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.adultIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.adultIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.adultIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.adultIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$backdropPath() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.backdropPathIndex);
    }

    public void realmSet$backdropPath(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.backdropPathIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.backdropPathIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.backdropPathIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.backdropPathIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$budget() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.budgetIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.budgetIndex);
    }

    public void realmSet$budget(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.budgetIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.budgetIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.budgetIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.budgetIndex, value);
    }

    public RealmList<com.example.bajob.movieshatch.Pojo.Genre> realmGet$genres() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (genresRealmList != null) {
            return genresRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.genresIndex);
            genresRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.Genre>(com.example.bajob.movieshatch.Pojo.Genre.class, linkView, proxyState.getRealm$realm());
            return genresRealmList;
        }
    }

    public void realmSet$genres(RealmList<com.example.bajob.movieshatch.Pojo.Genre> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("genres")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.bajob.movieshatch.Pojo.Genre> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.Genre>();
                for (com.example.bajob.movieshatch.Pojo.Genre item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.genresIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    @SuppressWarnings("cast")
    public String realmGet$homepage() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.homepageIndex);
    }

    public void realmSet$homepage(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.homepageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.homepageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.homepageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.homepageIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    public void realmSet$id(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$imdbId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imdbIdIndex);
    }

    public void realmSet$imdbId(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imdbIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imdbIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imdbIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imdbIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$originalLanguage() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.originalLanguageIndex);
    }

    public void realmSet$originalLanguage(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.originalLanguageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.originalLanguageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.originalLanguageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.originalLanguageIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$originalTitle() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.originalTitleIndex);
    }

    public void realmSet$originalTitle(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.originalTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.originalTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.originalTitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.originalTitleIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$overview() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.overviewIndex);
    }

    public void realmSet$overview(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.overviewIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.overviewIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.overviewIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.overviewIndex, value);
    }

    @SuppressWarnings("cast")
    public Double realmGet$popularity() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.popularityIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.popularityIndex);
    }

    public void realmSet$popularity(Double value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.popularityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.popularityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popularityIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.popularityIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$posterPath() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.posterPathIndex);
    }

    public void realmSet$posterPath(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.posterPathIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.posterPathIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.posterPathIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.posterPathIndex, value);
    }

    public RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> realmGet$productionCompanies() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (productionCompaniesRealmList != null) {
            return productionCompaniesRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.productionCompaniesIndex);
            productionCompaniesRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany>(com.example.bajob.movieshatch.Pojo.ProductionCompany.class, linkView, proxyState.getRealm$realm());
            return productionCompaniesRealmList;
        }
    }

    public void realmSet$productionCompanies(RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("productionCompanies")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany>();
                for (com.example.bajob.movieshatch.Pojo.ProductionCompany item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.productionCompaniesIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> realmGet$productionCountries() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (productionCountriesRealmList != null) {
            return productionCountriesRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.productionCountriesIndex);
            productionCountriesRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry>(com.example.bajob.movieshatch.Pojo.ProductionCountry.class, linkView, proxyState.getRealm$realm());
            return productionCountriesRealmList;
        }
    }

    public void realmSet$productionCountries(RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("productionCountries")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry>();
                for (com.example.bajob.movieshatch.Pojo.ProductionCountry item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.productionCountriesIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    @SuppressWarnings("cast")
    public String realmGet$releaseDate() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.releaseDateIndex);
    }

    public void realmSet$releaseDate(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.releaseDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.releaseDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.releaseDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.releaseDateIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$revenue() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.revenueIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.revenueIndex);
    }

    public void realmSet$revenue(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.revenueIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.revenueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.revenueIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.revenueIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$runtime() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.runtimeIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.runtimeIndex);
    }

    public void realmSet$runtime(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.runtimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.runtimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.runtimeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.runtimeIndex, value);
    }

    public RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> realmGet$spokenLanguages() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (spokenLanguagesRealmList != null) {
            return spokenLanguagesRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.spokenLanguagesIndex);
            spokenLanguagesRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage>(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class, linkView, proxyState.getRealm$realm());
            return spokenLanguagesRealmList;
        }
    }

    public void realmSet$spokenLanguages(RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("spokenLanguages")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage>();
                for (com.example.bajob.movieshatch.Pojo.SpokenLanguage item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.spokenLanguagesIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    @SuppressWarnings("cast")
    public String realmGet$status() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    public void realmSet$status(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$tagline() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.taglineIndex);
    }

    public void realmSet$tagline(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.taglineIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.taglineIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.taglineIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.taglineIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$title() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    public void realmSet$title(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$video() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.videoIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.videoIndex);
    }

    public void realmSet$video(Boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.videoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.videoIndex, value);
    }

    @SuppressWarnings("cast")
    public Double realmGet$voteAverage() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.voteAverageIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.voteAverageIndex);
    }

    public void realmSet$voteAverage(Double value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.voteAverageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.voteAverageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.voteAverageIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.voteAverageIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$voteCount() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.voteCountIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.voteCountIndex);
    }

    public void realmSet$voteCount(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.voteCountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.voteCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.voteCountIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.voteCountIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("MovieDetailedInfo")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("MovieDetailedInfo");
            realmObjectSchema.add(new Property("adult", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("backdropPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("budget", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("Genre")) {
                GenreRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("genres", RealmFieldType.LIST, realmSchema.get("Genre")));
            realmObjectSchema.add(new Property("homepage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("imdbId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originalLanguage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originalTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("overview", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popularity", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("posterPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("ProductionCompany")) {
                ProductionCompanyRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("productionCompanies", RealmFieldType.LIST, realmSchema.get("ProductionCompany")));
            if (!realmSchema.contains("ProductionCountry")) {
                ProductionCountryRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("productionCountries", RealmFieldType.LIST, realmSchema.get("ProductionCountry")));
            realmObjectSchema.add(new Property("releaseDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("revenue", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("runtime", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("SpokenLanguage")) {
                SpokenLanguageRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("spokenLanguages", RealmFieldType.LIST, realmSchema.get("SpokenLanguage")));
            realmObjectSchema.add(new Property("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("tagline", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("video", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voteAverage", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voteCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("MovieDetailedInfo");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_MovieDetailedInfo")) {
            Table table = sharedRealm.getTable("class_MovieDetailedInfo");
            table.addColumn(RealmFieldType.BOOLEAN, "adult", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "backdropPath", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "budget", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_Genre")) {
                GenreRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "genres", sharedRealm.getTable("class_Genre"));
            table.addColumn(RealmFieldType.STRING, "homepage", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "imdbId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originalLanguage", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originalTitle", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "overview", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "popularity", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "posterPath", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_ProductionCompany")) {
                ProductionCompanyRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "productionCompanies", sharedRealm.getTable("class_ProductionCompany"));
            if (!sharedRealm.hasTable("class_ProductionCountry")) {
                ProductionCountryRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "productionCountries", sharedRealm.getTable("class_ProductionCountry"));
            table.addColumn(RealmFieldType.STRING, "releaseDate", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "revenue", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "runtime", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_SpokenLanguage")) {
                SpokenLanguageRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "spokenLanguages", sharedRealm.getTable("class_SpokenLanguage"));
            table.addColumn(RealmFieldType.STRING, "status", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "tagline", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "title", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "video", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "voteAverage", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "voteCount", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_MovieDetailedInfo");
    }

    public static MovieDetailedInfoColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_MovieDetailedInfo")) {
            Table table = sharedRealm.getTable("class_MovieDetailedInfo");
            final long columnCount = table.getColumnCount();
            if (columnCount != 24) {
                if (columnCount < 24) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 24 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 24 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 24 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final MovieDetailedInfoColumnInfo columnInfo = new MovieDetailedInfoColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.idIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
                }
            }

            if (!columnTypes.containsKey("adult")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'adult' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("adult") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'adult' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.adultIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'adult' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'adult' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("backdropPath")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'backdropPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("backdropPath") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'backdropPath' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.backdropPathIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'backdropPath' is required. Either set @Required to field 'backdropPath' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("budget")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'budget' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("budget") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'budget' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.budgetIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'budget' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'budget' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("genres")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'genres'");
            }
            if (columnTypes.get("genres") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Genre' for field 'genres'");
            }
            if (!sharedRealm.hasTable("class_Genre")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Genre' for field 'genres'");
            }
            Table table_3 = sharedRealm.getTable("class_Genre");
            if (!table.getLinkTarget(columnInfo.genresIndex).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'genres': '" + table.getLinkTarget(columnInfo.genresIndex).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            if (!columnTypes.containsKey("homepage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'homepage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("homepage") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'homepage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.homepageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'homepage' is required. Either set @Required to field 'homepage' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'id' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.idIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("imdbId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'imdbId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("imdbId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'imdbId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.imdbIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'imdbId' is required. Either set @Required to field 'imdbId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("originalLanguage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originalLanguage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("originalLanguage") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originalLanguage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.originalLanguageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originalLanguage' is required. Either set @Required to field 'originalLanguage' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("originalTitle")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originalTitle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("originalTitle") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originalTitle' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.originalTitleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originalTitle' is required. Either set @Required to field 'originalTitle' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("overview")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'overview' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("overview") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'overview' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.overviewIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'overview' is required. Either set @Required to field 'overview' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("popularity")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popularity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popularity") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'popularity' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popularityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'popularity' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'popularity' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("posterPath")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'posterPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("posterPath") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'posterPath' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.posterPathIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'posterPath' is required. Either set @Required to field 'posterPath' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("productionCompanies")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productionCompanies'");
            }
            if (columnTypes.get("productionCompanies") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ProductionCompany' for field 'productionCompanies'");
            }
            if (!sharedRealm.hasTable("class_ProductionCompany")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ProductionCompany' for field 'productionCompanies'");
            }
            Table table_12 = sharedRealm.getTable("class_ProductionCompany");
            if (!table.getLinkTarget(columnInfo.productionCompaniesIndex).hasSameSchema(table_12)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'productionCompanies': '" + table.getLinkTarget(columnInfo.productionCompaniesIndex).getName() + "' expected - was '" + table_12.getName() + "'");
            }
            if (!columnTypes.containsKey("productionCountries")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productionCountries'");
            }
            if (columnTypes.get("productionCountries") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ProductionCountry' for field 'productionCountries'");
            }
            if (!sharedRealm.hasTable("class_ProductionCountry")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ProductionCountry' for field 'productionCountries'");
            }
            Table table_13 = sharedRealm.getTable("class_ProductionCountry");
            if (!table.getLinkTarget(columnInfo.productionCountriesIndex).hasSameSchema(table_13)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'productionCountries': '" + table.getLinkTarget(columnInfo.productionCountriesIndex).getName() + "' expected - was '" + table_13.getName() + "'");
            }
            if (!columnTypes.containsKey("releaseDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'releaseDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("releaseDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'releaseDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.releaseDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'releaseDate' is required. Either set @Required to field 'releaseDate' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("revenue")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'revenue' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("revenue") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'revenue' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.revenueIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'revenue' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'revenue' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("runtime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'runtime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("runtime") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'runtime' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.runtimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'runtime' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'runtime' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("spokenLanguages")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'spokenLanguages'");
            }
            if (columnTypes.get("spokenLanguages") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'SpokenLanguage' for field 'spokenLanguages'");
            }
            if (!sharedRealm.hasTable("class_SpokenLanguage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_SpokenLanguage' for field 'spokenLanguages'");
            }
            Table table_17 = sharedRealm.getTable("class_SpokenLanguage");
            if (!table.getLinkTarget(columnInfo.spokenLanguagesIndex).hasSameSchema(table_17)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'spokenLanguages': '" + table.getLinkTarget(columnInfo.spokenLanguagesIndex).getName() + "' expected - was '" + table_17.getName() + "'");
            }
            if (!columnTypes.containsKey("status")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("status") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'status' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.statusIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'status' is required. Either set @Required to field 'status' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("tagline")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'tagline' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("tagline") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'tagline' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.taglineIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'tagline' is required. Either set @Required to field 'tagline' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("title")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("title") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'title' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.titleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("video")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'video' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("video") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'video' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.videoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'video' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'video' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("voteAverage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'voteAverage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("voteAverage") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'voteAverage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.voteAverageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'voteAverage' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'voteAverage' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("voteCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'voteCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("voteCount") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'voteCount' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.voteCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'voteCount' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'voteCount' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MovieDetailedInfo' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_MovieDetailedInfo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.MovieDetailedInfo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(4);
        com.example.bajob.movieshatch.Pojo.MovieDetailedInfo obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MovieDetailedInfoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("genres")) {
                excludeFields.add("genres");
            }
            if (json.has("productionCompanies")) {
                excludeFields.add("productionCompanies");
            }
            if (json.has("productionCountries")) {
                excludeFields.add("productionCountries");
            }
            if (json.has("spokenLanguages")) {
                excludeFields.add("spokenLanguages");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.MovieDetailedInfoRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MovieDetailedInfoRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("adult")) {
            if (json.isNull("adult")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$adult(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$adult((boolean) json.getBoolean("adult"));
            }
        }
        if (json.has("backdropPath")) {
            if (json.isNull("backdropPath")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$backdropPath(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$backdropPath((String) json.getString("backdropPath"));
            }
        }
        if (json.has("budget")) {
            if (json.isNull("budget")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$budget(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$budget((int) json.getInt("budget"));
            }
        }
        if (json.has("genres")) {
            if (json.isNull("genres")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$genres(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$genres().clear();
                JSONArray array = json.getJSONArray("genres");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.Genre item = GenreRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$genres().add(item);
                }
            }
        }
        if (json.has("homepage")) {
            if (json.isNull("homepage")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$homepage(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$homepage((String) json.getString("homepage"));
            }
        }
        if (json.has("imdbId")) {
            if (json.isNull("imdbId")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$imdbId(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$imdbId((String) json.getString("imdbId"));
            }
        }
        if (json.has("originalLanguage")) {
            if (json.isNull("originalLanguage")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$originalLanguage(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$originalLanguage((String) json.getString("originalLanguage"));
            }
        }
        if (json.has("originalTitle")) {
            if (json.isNull("originalTitle")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$originalTitle(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$originalTitle((String) json.getString("originalTitle"));
            }
        }
        if (json.has("overview")) {
            if (json.isNull("overview")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$overview(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$overview((String) json.getString("overview"));
            }
        }
        if (json.has("popularity")) {
            if (json.isNull("popularity")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$popularity(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$popularity((double) json.getDouble("popularity"));
            }
        }
        if (json.has("posterPath")) {
            if (json.isNull("posterPath")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$posterPath(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$posterPath((String) json.getString("posterPath"));
            }
        }
        if (json.has("productionCompanies")) {
            if (json.isNull("productionCompanies")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$productionCompanies(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$productionCompanies().clear();
                JSONArray array = json.getJSONArray("productionCompanies");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.ProductionCompany item = ProductionCompanyRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$productionCompanies().add(item);
                }
            }
        }
        if (json.has("productionCountries")) {
            if (json.isNull("productionCountries")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$productionCountries(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$productionCountries().clear();
                JSONArray array = json.getJSONArray("productionCountries");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.ProductionCountry item = ProductionCountryRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$productionCountries().add(item);
                }
            }
        }
        if (json.has("releaseDate")) {
            if (json.isNull("releaseDate")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$releaseDate(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$releaseDate((String) json.getString("releaseDate"));
            }
        }
        if (json.has("revenue")) {
            if (json.isNull("revenue")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$revenue(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$revenue((int) json.getInt("revenue"));
            }
        }
        if (json.has("runtime")) {
            if (json.isNull("runtime")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$runtime(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$runtime((int) json.getInt("runtime"));
            }
        }
        if (json.has("spokenLanguages")) {
            if (json.isNull("spokenLanguages")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$spokenLanguages(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$spokenLanguages().clear();
                JSONArray array = json.getJSONArray("spokenLanguages");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.SpokenLanguage item = SpokenLanguageRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$spokenLanguages().add(item);
                }
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$status(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("tagline")) {
            if (json.isNull("tagline")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$tagline(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$tagline((String) json.getString("tagline"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("video")) {
            if (json.isNull("video")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$video(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$video((boolean) json.getBoolean("video"));
            }
        }
        if (json.has("voteAverage")) {
            if (json.isNull("voteAverage")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$voteAverage(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$voteAverage((double) json.getDouble("voteAverage"));
            }
        }
        if (json.has("voteCount")) {
            if (json.isNull("voteCount")) {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$voteCount(null);
            } else {
                ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$voteCount((int) json.getInt("voteCount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.MovieDetailedInfo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.bajob.movieshatch.Pojo.MovieDetailedInfo obj = new com.example.bajob.movieshatch.Pojo.MovieDetailedInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("adult")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$adult(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$adult((boolean) reader.nextBoolean());
                }
            } else if (name.equals("backdropPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$backdropPath(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$backdropPath((String) reader.nextString());
                }
            } else if (name.equals("budget")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$budget(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$budget((int) reader.nextInt());
                }
            } else if (name.equals("genres")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$genres(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$genres(new RealmList<com.example.bajob.movieshatch.Pojo.Genre>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.Genre item = GenreRealmProxy.createUsingJsonStream(realm, reader);
                        ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$genres().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("homepage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$homepage(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$homepage((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("imdbId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$imdbId(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$imdbId((String) reader.nextString());
                }
            } else if (name.equals("originalLanguage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$originalLanguage(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$originalLanguage((String) reader.nextString());
                }
            } else if (name.equals("originalTitle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$originalTitle(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$originalTitle((String) reader.nextString());
                }
            } else if (name.equals("overview")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$overview(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$overview((String) reader.nextString());
                }
            } else if (name.equals("popularity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$popularity(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$popularity((double) reader.nextDouble());
                }
            } else if (name.equals("posterPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$posterPath(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$posterPath((String) reader.nextString());
                }
            } else if (name.equals("productionCompanies")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$productionCompanies(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$productionCompanies(new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.ProductionCompany item = ProductionCompanyRealmProxy.createUsingJsonStream(realm, reader);
                        ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$productionCompanies().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("productionCountries")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$productionCountries(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$productionCountries(new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.ProductionCountry item = ProductionCountryRealmProxy.createUsingJsonStream(realm, reader);
                        ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$productionCountries().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("releaseDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$releaseDate(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$releaseDate((String) reader.nextString());
                }
            } else if (name.equals("revenue")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$revenue(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$revenue((int) reader.nextInt());
                }
            } else if (name.equals("runtime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$runtime(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$runtime((int) reader.nextInt());
                }
            } else if (name.equals("spokenLanguages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$spokenLanguages(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$spokenLanguages(new RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.SpokenLanguage item = SpokenLanguageRealmProxy.createUsingJsonStream(realm, reader);
                        ((MovieDetailedInfoRealmProxyInterface) obj).realmGet$spokenLanguages().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("status")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$status(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$status((String) reader.nextString());
                }
            } else if (name.equals("tagline")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$tagline(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$tagline((String) reader.nextString());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("video")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$video(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$video((boolean) reader.nextBoolean());
                }
            } else if (name.equals("voteAverage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$voteAverage(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$voteAverage((double) reader.nextDouble());
                }
            } else if (name.equals("voteCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$voteCount(null);
                } else {
                    ((MovieDetailedInfoRealmProxyInterface) obj).realmSet$voteCount((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.bajob.movieshatch.Pojo.MovieDetailedInfo copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.MovieDetailedInfo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) cachedRealmObject;
        } else {
            com.example.bajob.movieshatch.Pojo.MovieDetailedInfo realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MovieDetailedInfoRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.MovieDetailedInfo copy(Realm realm, com.example.bajob.movieshatch.Pojo.MovieDetailedInfo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.MovieDetailedInfo realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class, ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$adult(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$adult());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$backdropPath(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$backdropPath());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$budget(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$budget());

            RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$genres();
            if (genresList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresRealmList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$genres();
                for (int i = 0; i < genresList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.Genre genresItem = genresList.get(i);
                    com.example.bajob.movieshatch.Pojo.Genre cachegenres = (com.example.bajob.movieshatch.Pojo.Genre) cache.get(genresItem);
                    if (cachegenres != null) {
                        genresRealmList.add(cachegenres);
                    } else {
                        genresRealmList.add(GenreRealmProxy.copyOrUpdate(realm, genresList.get(i), update, cache));
                    }
                }
            }

            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$homepage(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$homepage());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$imdbId(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$imdbId());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$originalLanguage(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$originalLanguage());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$originalTitle(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$originalTitle());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$overview(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$overview());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$popularity(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$popularity());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$posterPath(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$posterPath());

            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$productionCompanies();
            if (productionCompaniesList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesRealmList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCompanies();
                for (int i = 0; i < productionCompaniesList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.ProductionCompany productionCompaniesItem = productionCompaniesList.get(i);
                    com.example.bajob.movieshatch.Pojo.ProductionCompany cacheproductionCompanies = (com.example.bajob.movieshatch.Pojo.ProductionCompany) cache.get(productionCompaniesItem);
                    if (cacheproductionCompanies != null) {
                        productionCompaniesRealmList.add(cacheproductionCompanies);
                    } else {
                        productionCompaniesRealmList.add(ProductionCompanyRealmProxy.copyOrUpdate(realm, productionCompaniesList.get(i), update, cache));
                    }
                }
            }


            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesList = ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$productionCountries();
            if (productionCountriesList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesRealmList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCountries();
                for (int i = 0; i < productionCountriesList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.ProductionCountry productionCountriesItem = productionCountriesList.get(i);
                    com.example.bajob.movieshatch.Pojo.ProductionCountry cacheproductionCountries = (com.example.bajob.movieshatch.Pojo.ProductionCountry) cache.get(productionCountriesItem);
                    if (cacheproductionCountries != null) {
                        productionCountriesRealmList.add(cacheproductionCountries);
                    } else {
                        productionCountriesRealmList.add(ProductionCountryRealmProxy.copyOrUpdate(realm, productionCountriesList.get(i), update, cache));
                    }
                }
            }

            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$releaseDate(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$releaseDate());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$revenue(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$revenue());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$runtime(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$runtime());

            RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesList = ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$spokenLanguages();
            if (spokenLanguagesList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesRealmList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$spokenLanguages();
                for (int i = 0; i < spokenLanguagesList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.SpokenLanguage spokenLanguagesItem = spokenLanguagesList.get(i);
                    com.example.bajob.movieshatch.Pojo.SpokenLanguage cachespokenLanguages = (com.example.bajob.movieshatch.Pojo.SpokenLanguage) cache.get(spokenLanguagesItem);
                    if (cachespokenLanguages != null) {
                        spokenLanguagesRealmList.add(cachespokenLanguages);
                    } else {
                        spokenLanguagesRealmList.add(SpokenLanguageRealmProxy.copyOrUpdate(realm, spokenLanguagesList.get(i), update, cache));
                    }
                }
            }

            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$status(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$status());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$tagline(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$tagline());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$title(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$title());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$video(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$video());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$voteAverage(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$voteAverage());
            ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$voteCount(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$voteCount());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.MovieDetailedInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        MovieDetailedInfoColumnInfo columnInfo = (MovieDetailedInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MovieDetailedInfoRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Boolean realmGet$adult = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$adult();
        if (realmGet$adult != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
        }
        String realmGet$backdropPath = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        }
        Number realmGet$budget = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$budget();
        if (realmGet$budget != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.budgetIndex, rowIndex, realmGet$budget.longValue(), false);
        }

        RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$genres();
        if (genresList != null) {
            long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.Genre genresItem : genresList) {
                Long cacheItemIndexgenres = cache.get(genresItem);
                if (cacheItemIndexgenres == null) {
                    cacheItemIndexgenres = GenreRealmProxy.insert(realm, genresItem, cache);
                }
                LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
            }
        }

        String realmGet$homepage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$homepage();
        if (realmGet$homepage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
        }
        String realmGet$imdbId = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$imdbId();
        if (realmGet$imdbId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, realmGet$imdbId, false);
        }
        String realmGet$originalLanguage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        }
        String realmGet$originalTitle = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$originalTitle();
        if (realmGet$originalTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
        }
        String realmGet$overview = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        }
        Double realmGet$popularity = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        }
        String realmGet$posterPath = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        }

        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$productionCompanies();
        if (productionCompaniesList != null) {
            long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                if (cacheItemIndexproductionCompanies == null) {
                    cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insert(realm, productionCompaniesItem, cache);
                }
                LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
            }
        }


        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$productionCountries();
        if (productionCountriesList != null) {
            long productionCountriesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCountriesIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.ProductionCountry productionCountriesItem : productionCountriesList) {
                Long cacheItemIndexproductionCountries = cache.get(productionCountriesItem);
                if (cacheItemIndexproductionCountries == null) {
                    cacheItemIndexproductionCountries = ProductionCountryRealmProxy.insert(realm, productionCountriesItem, cache);
                }
                LinkView.nativeAdd(productionCountriesNativeLinkViewPtr, cacheItemIndexproductionCountries);
            }
        }

        String realmGet$releaseDate = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
        }
        Number realmGet$revenue = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$revenue();
        if (realmGet$revenue != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.revenueIndex, rowIndex, realmGet$revenue.longValue(), false);
        }
        Number realmGet$runtime = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$runtime();
        if (realmGet$runtime != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.runtimeIndex, rowIndex, realmGet$runtime.longValue(), false);
        }

        RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$spokenLanguages();
        if (spokenLanguagesList != null) {
            long spokenLanguagesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.spokenLanguagesIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.SpokenLanguage spokenLanguagesItem : spokenLanguagesList) {
                Long cacheItemIndexspokenLanguages = cache.get(spokenLanguagesItem);
                if (cacheItemIndexspokenLanguages == null) {
                    cacheItemIndexspokenLanguages = SpokenLanguageRealmProxy.insert(realm, spokenLanguagesItem, cache);
                }
                LinkView.nativeAdd(spokenLanguagesNativeLinkViewPtr, cacheItemIndexspokenLanguages);
            }
        }

        String realmGet$status = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$tagline = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$tagline();
        if (realmGet$tagline != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.taglineIndex, rowIndex, realmGet$tagline, false);
        }
        String realmGet$title = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        Boolean realmGet$video = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$video();
        if (realmGet$video != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
        }
        Double realmGet$voteAverage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        }
        Number realmGet$voteCount = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        MovieDetailedInfoColumnInfo columnInfo = (MovieDetailedInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.MovieDetailedInfo object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MovieDetailedInfoRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Boolean realmGet$adult = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$adult();
                if (realmGet$adult != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
                }
                String realmGet$backdropPath = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                }
                Number realmGet$budget = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$budget();
                if (realmGet$budget != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.budgetIndex, rowIndex, realmGet$budget.longValue(), false);
                }

                RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$genres();
                if (genresList != null) {
                    long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.Genre genresItem : genresList) {
                        Long cacheItemIndexgenres = cache.get(genresItem);
                        if (cacheItemIndexgenres == null) {
                            cacheItemIndexgenres = GenreRealmProxy.insert(realm, genresItem, cache);
                        }
                        LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
                    }
                }

                String realmGet$homepage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$homepage();
                if (realmGet$homepage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
                }
                String realmGet$imdbId = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$imdbId();
                if (realmGet$imdbId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, realmGet$imdbId, false);
                }
                String realmGet$originalLanguage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                }
                String realmGet$originalTitle = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$originalTitle();
                if (realmGet$originalTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
                }
                String realmGet$overview = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                }
                Double realmGet$popularity = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                }
                String realmGet$posterPath = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                }

                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$productionCompanies();
                if (productionCompaniesList != null) {
                    long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                        Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                        if (cacheItemIndexproductionCompanies == null) {
                            cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insert(realm, productionCompaniesItem, cache);
                        }
                        LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
                    }
                }


                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$productionCountries();
                if (productionCountriesList != null) {
                    long productionCountriesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCountriesIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.ProductionCountry productionCountriesItem : productionCountriesList) {
                        Long cacheItemIndexproductionCountries = cache.get(productionCountriesItem);
                        if (cacheItemIndexproductionCountries == null) {
                            cacheItemIndexproductionCountries = ProductionCountryRealmProxy.insert(realm, productionCountriesItem, cache);
                        }
                        LinkView.nativeAdd(productionCountriesNativeLinkViewPtr, cacheItemIndexproductionCountries);
                    }
                }

                String realmGet$releaseDate = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
                }
                Number realmGet$revenue = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$revenue();
                if (realmGet$revenue != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.revenueIndex, rowIndex, realmGet$revenue.longValue(), false);
                }
                Number realmGet$runtime = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$runtime();
                if (realmGet$runtime != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.runtimeIndex, rowIndex, realmGet$runtime.longValue(), false);
                }

                RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$spokenLanguages();
                if (spokenLanguagesList != null) {
                    long spokenLanguagesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.spokenLanguagesIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.SpokenLanguage spokenLanguagesItem : spokenLanguagesList) {
                        Long cacheItemIndexspokenLanguages = cache.get(spokenLanguagesItem);
                        if (cacheItemIndexspokenLanguages == null) {
                            cacheItemIndexspokenLanguages = SpokenLanguageRealmProxy.insert(realm, spokenLanguagesItem, cache);
                        }
                        LinkView.nativeAdd(spokenLanguagesNativeLinkViewPtr, cacheItemIndexspokenLanguages);
                    }
                }

                String realmGet$status = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                }
                String realmGet$tagline = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$tagline();
                if (realmGet$tagline != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.taglineIndex, rowIndex, realmGet$tagline, false);
                }
                String realmGet$title = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                Boolean realmGet$video = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$video();
                if (realmGet$video != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
                }
                Double realmGet$voteAverage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                }
                Number realmGet$voteCount = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.MovieDetailedInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        MovieDetailedInfoColumnInfo columnInfo = (MovieDetailedInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MovieDetailedInfoRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        Boolean realmGet$adult = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$adult();
        if (realmGet$adult != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.adultIndex, rowIndex, false);
        }
        String realmGet$backdropPath = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
        }
        Number realmGet$budget = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$budget();
        if (realmGet$budget != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.budgetIndex, rowIndex, realmGet$budget.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.budgetIndex, rowIndex, false);
        }

        long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
        LinkView.nativeClear(genresNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$genres();
        if (genresList != null) {
            for (com.example.bajob.movieshatch.Pojo.Genre genresItem : genresList) {
                Long cacheItemIndexgenres = cache.get(genresItem);
                if (cacheItemIndexgenres == null) {
                    cacheItemIndexgenres = GenreRealmProxy.insertOrUpdate(realm, genresItem, cache);
                }
                LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
            }
        }

        String realmGet$homepage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$homepage();
        if (realmGet$homepage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.homepageIndex, rowIndex, false);
        }
        String realmGet$imdbId = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$imdbId();
        if (realmGet$imdbId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, realmGet$imdbId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, false);
        }
        String realmGet$originalLanguage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
        }
        String realmGet$originalTitle = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$originalTitle();
        if (realmGet$originalTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, false);
        }
        String realmGet$overview = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
        }
        Double realmGet$popularity = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
        }
        String realmGet$posterPath = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
        }

        long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
        LinkView.nativeClear(productionCompaniesNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$productionCompanies();
        if (productionCompaniesList != null) {
            for (com.example.bajob.movieshatch.Pojo.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                if (cacheItemIndexproductionCompanies == null) {
                    cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insertOrUpdate(realm, productionCompaniesItem, cache);
                }
                LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
            }
        }


        long productionCountriesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCountriesIndex, rowIndex);
        LinkView.nativeClear(productionCountriesNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$productionCountries();
        if (productionCountriesList != null) {
            for (com.example.bajob.movieshatch.Pojo.ProductionCountry productionCountriesItem : productionCountriesList) {
                Long cacheItemIndexproductionCountries = cache.get(productionCountriesItem);
                if (cacheItemIndexproductionCountries == null) {
                    cacheItemIndexproductionCountries = ProductionCountryRealmProxy.insertOrUpdate(realm, productionCountriesItem, cache);
                }
                LinkView.nativeAdd(productionCountriesNativeLinkViewPtr, cacheItemIndexproductionCountries);
            }
        }

        String realmGet$releaseDate = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, false);
        }
        Number realmGet$revenue = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$revenue();
        if (realmGet$revenue != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.revenueIndex, rowIndex, realmGet$revenue.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.revenueIndex, rowIndex, false);
        }
        Number realmGet$runtime = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$runtime();
        if (realmGet$runtime != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.runtimeIndex, rowIndex, realmGet$runtime.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.runtimeIndex, rowIndex, false);
        }

        long spokenLanguagesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.spokenLanguagesIndex, rowIndex);
        LinkView.nativeClear(spokenLanguagesNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$spokenLanguages();
        if (spokenLanguagesList != null) {
            for (com.example.bajob.movieshatch.Pojo.SpokenLanguage spokenLanguagesItem : spokenLanguagesList) {
                Long cacheItemIndexspokenLanguages = cache.get(spokenLanguagesItem);
                if (cacheItemIndexspokenLanguages == null) {
                    cacheItemIndexspokenLanguages = SpokenLanguageRealmProxy.insertOrUpdate(realm, spokenLanguagesItem, cache);
                }
                LinkView.nativeAdd(spokenLanguagesNativeLinkViewPtr, cacheItemIndexspokenLanguages);
            }
        }

        String realmGet$status = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$tagline = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$tagline();
        if (realmGet$tagline != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.taglineIndex, rowIndex, realmGet$tagline, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.taglineIndex, rowIndex, false);
        }
        String realmGet$title = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        Boolean realmGet$video = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$video();
        if (realmGet$video != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoIndex, rowIndex, false);
        }
        Double realmGet$voteAverage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
        }
        Number realmGet$voteCount = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        MovieDetailedInfoColumnInfo columnInfo = (MovieDetailedInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.MovieDetailedInfo object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieDetailedInfoRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MovieDetailedInfoRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                Boolean realmGet$adult = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$adult();
                if (realmGet$adult != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.adultIndex, rowIndex, false);
                }
                String realmGet$backdropPath = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
                }
                Number realmGet$budget = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$budget();
                if (realmGet$budget != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.budgetIndex, rowIndex, realmGet$budget.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.budgetIndex, rowIndex, false);
                }

                long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
                LinkView.nativeClear(genresNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$genres();
                if (genresList != null) {
                    for (com.example.bajob.movieshatch.Pojo.Genre genresItem : genresList) {
                        Long cacheItemIndexgenres = cache.get(genresItem);
                        if (cacheItemIndexgenres == null) {
                            cacheItemIndexgenres = GenreRealmProxy.insertOrUpdate(realm, genresItem, cache);
                        }
                        LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
                    }
                }

                String realmGet$homepage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$homepage();
                if (realmGet$homepage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.homepageIndex, rowIndex, false);
                }
                String realmGet$imdbId = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$imdbId();
                if (realmGet$imdbId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, realmGet$imdbId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, false);
                }
                String realmGet$originalLanguage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
                }
                String realmGet$originalTitle = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$originalTitle();
                if (realmGet$originalTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, false);
                }
                String realmGet$overview = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
                }
                Double realmGet$popularity = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
                }
                String realmGet$posterPath = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
                }

                long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
                LinkView.nativeClear(productionCompaniesNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$productionCompanies();
                if (productionCompaniesList != null) {
                    for (com.example.bajob.movieshatch.Pojo.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                        Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                        if (cacheItemIndexproductionCompanies == null) {
                            cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insertOrUpdate(realm, productionCompaniesItem, cache);
                        }
                        LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
                    }
                }


                long productionCountriesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCountriesIndex, rowIndex);
                LinkView.nativeClear(productionCountriesNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$productionCountries();
                if (productionCountriesList != null) {
                    for (com.example.bajob.movieshatch.Pojo.ProductionCountry productionCountriesItem : productionCountriesList) {
                        Long cacheItemIndexproductionCountries = cache.get(productionCountriesItem);
                        if (cacheItemIndexproductionCountries == null) {
                            cacheItemIndexproductionCountries = ProductionCountryRealmProxy.insertOrUpdate(realm, productionCountriesItem, cache);
                        }
                        LinkView.nativeAdd(productionCountriesNativeLinkViewPtr, cacheItemIndexproductionCountries);
                    }
                }

                String realmGet$releaseDate = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, false);
                }
                Number realmGet$revenue = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$revenue();
                if (realmGet$revenue != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.revenueIndex, rowIndex, realmGet$revenue.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.revenueIndex, rowIndex, false);
                }
                Number realmGet$runtime = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$runtime();
                if (realmGet$runtime != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.runtimeIndex, rowIndex, realmGet$runtime.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.runtimeIndex, rowIndex, false);
                }

                long spokenLanguagesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.spokenLanguagesIndex, rowIndex);
                LinkView.nativeClear(spokenLanguagesNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesList = ((MovieDetailedInfoRealmProxyInterface) object).realmGet$spokenLanguages();
                if (spokenLanguagesList != null) {
                    for (com.example.bajob.movieshatch.Pojo.SpokenLanguage spokenLanguagesItem : spokenLanguagesList) {
                        Long cacheItemIndexspokenLanguages = cache.get(spokenLanguagesItem);
                        if (cacheItemIndexspokenLanguages == null) {
                            cacheItemIndexspokenLanguages = SpokenLanguageRealmProxy.insertOrUpdate(realm, spokenLanguagesItem, cache);
                        }
                        LinkView.nativeAdd(spokenLanguagesNativeLinkViewPtr, cacheItemIndexspokenLanguages);
                    }
                }

                String realmGet$status = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
                }
                String realmGet$tagline = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$tagline();
                if (realmGet$tagline != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.taglineIndex, rowIndex, realmGet$tagline, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.taglineIndex, rowIndex, false);
                }
                String realmGet$title = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                Boolean realmGet$video = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$video();
                if (realmGet$video != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.videoIndex, rowIndex, false);
                }
                Double realmGet$voteAverage = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
                }
                Number realmGet$voteCount = ((MovieDetailedInfoRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.MovieDetailedInfo createDetachedCopy(com.example.bajob.movieshatch.Pojo.MovieDetailedInfo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.MovieDetailedInfo unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.MovieDetailedInfo)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.MovieDetailedInfo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$adult(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$adult());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$backdropPath(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$backdropPath());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$budget(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$budget());

        // Deep copy of genres
        if (currentDepth == maxDepth) {
            ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$genres(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.Genre> managedgenresList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$genres();
            RealmList<com.example.bajob.movieshatch.Pojo.Genre> unmanagedgenresList = new RealmList<com.example.bajob.movieshatch.Pojo.Genre>();
            ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$genres(unmanagedgenresList);
            int nextDepth = currentDepth + 1;
            int size = managedgenresList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.Genre item = GenreRealmProxy.createDetachedCopy(managedgenresList.get(i), nextDepth, maxDepth, cache);
                unmanagedgenresList.add(item);
            }
        }
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$homepage(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$homepage());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$id(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$id());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$imdbId(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$imdbId());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$originalLanguage(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$originalLanguage());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$originalTitle(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$originalTitle());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$overview(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$overview());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$popularity(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$popularity());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$posterPath(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$posterPath());

        // Deep copy of productionCompanies
        if (currentDepth == maxDepth) {
            ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$productionCompanies(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> managedproductionCompaniesList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCompanies();
            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> unmanagedproductionCompaniesList = new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany>();
            ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$productionCompanies(unmanagedproductionCompaniesList);
            int nextDepth = currentDepth + 1;
            int size = managedproductionCompaniesList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.ProductionCompany item = ProductionCompanyRealmProxy.createDetachedCopy(managedproductionCompaniesList.get(i), nextDepth, maxDepth, cache);
                unmanagedproductionCompaniesList.add(item);
            }
        }

        // Deep copy of productionCountries
        if (currentDepth == maxDepth) {
            ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$productionCountries(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> managedproductionCountriesList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCountries();
            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> unmanagedproductionCountriesList = new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry>();
            ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$productionCountries(unmanagedproductionCountriesList);
            int nextDepth = currentDepth + 1;
            int size = managedproductionCountriesList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.ProductionCountry item = ProductionCountryRealmProxy.createDetachedCopy(managedproductionCountriesList.get(i), nextDepth, maxDepth, cache);
                unmanagedproductionCountriesList.add(item);
            }
        }
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$releaseDate(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$releaseDate());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$revenue(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$revenue());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$runtime(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$runtime());

        // Deep copy of spokenLanguages
        if (currentDepth == maxDepth) {
            ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$spokenLanguages(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> managedspokenLanguagesList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$spokenLanguages();
            RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> unmanagedspokenLanguagesList = new RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage>();
            ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$spokenLanguages(unmanagedspokenLanguagesList);
            int nextDepth = currentDepth + 1;
            int size = managedspokenLanguagesList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.SpokenLanguage item = SpokenLanguageRealmProxy.createDetachedCopy(managedspokenLanguagesList.get(i), nextDepth, maxDepth, cache);
                unmanagedspokenLanguagesList.add(item);
            }
        }
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$status(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$status());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$tagline(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$tagline());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$title(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$title());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$video(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$video());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$voteAverage(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$voteAverage());
        ((MovieDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$voteCount(((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$voteCount());
        return unmanagedObject;
    }

    static com.example.bajob.movieshatch.Pojo.MovieDetailedInfo update(Realm realm, com.example.bajob.movieshatch.Pojo.MovieDetailedInfo realmObject, com.example.bajob.movieshatch.Pojo.MovieDetailedInfo newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$adult(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$adult());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$backdropPath(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$backdropPath());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$budget(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$budget());
        RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$genres();
        RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresRealmList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$genres();
        genresRealmList.clear();
        if (genresList != null) {
            for (int i = 0; i < genresList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.Genre genresItem = genresList.get(i);
                com.example.bajob.movieshatch.Pojo.Genre cachegenres = (com.example.bajob.movieshatch.Pojo.Genre) cache.get(genresItem);
                if (cachegenres != null) {
                    genresRealmList.add(cachegenres);
                } else {
                    genresRealmList.add(GenreRealmProxy.copyOrUpdate(realm, genresList.get(i), true, cache));
                }
            }
        }
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$homepage(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$homepage());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$imdbId(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$imdbId());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$originalLanguage(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$originalLanguage());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$originalTitle(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$originalTitle());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$overview(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$overview());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$popularity(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$popularity());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$posterPath(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$posterPath());
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$productionCompanies();
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesRealmList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCompanies();
        productionCompaniesRealmList.clear();
        if (productionCompaniesList != null) {
            for (int i = 0; i < productionCompaniesList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.ProductionCompany productionCompaniesItem = productionCompaniesList.get(i);
                com.example.bajob.movieshatch.Pojo.ProductionCompany cacheproductionCompanies = (com.example.bajob.movieshatch.Pojo.ProductionCompany) cache.get(productionCompaniesItem);
                if (cacheproductionCompanies != null) {
                    productionCompaniesRealmList.add(cacheproductionCompanies);
                } else {
                    productionCompaniesRealmList.add(ProductionCompanyRealmProxy.copyOrUpdate(realm, productionCompaniesList.get(i), true, cache));
                }
            }
        }
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesList = ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$productionCountries();
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCountry> productionCountriesRealmList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCountries();
        productionCountriesRealmList.clear();
        if (productionCountriesList != null) {
            for (int i = 0; i < productionCountriesList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.ProductionCountry productionCountriesItem = productionCountriesList.get(i);
                com.example.bajob.movieshatch.Pojo.ProductionCountry cacheproductionCountries = (com.example.bajob.movieshatch.Pojo.ProductionCountry) cache.get(productionCountriesItem);
                if (cacheproductionCountries != null) {
                    productionCountriesRealmList.add(cacheproductionCountries);
                } else {
                    productionCountriesRealmList.add(ProductionCountryRealmProxy.copyOrUpdate(realm, productionCountriesList.get(i), true, cache));
                }
            }
        }
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$releaseDate(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$releaseDate());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$revenue(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$revenue());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$runtime(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$runtime());
        RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesList = ((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$spokenLanguages();
        RealmList<com.example.bajob.movieshatch.Pojo.SpokenLanguage> spokenLanguagesRealmList = ((MovieDetailedInfoRealmProxyInterface) realmObject).realmGet$spokenLanguages();
        spokenLanguagesRealmList.clear();
        if (spokenLanguagesList != null) {
            for (int i = 0; i < spokenLanguagesList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.SpokenLanguage spokenLanguagesItem = spokenLanguagesList.get(i);
                com.example.bajob.movieshatch.Pojo.SpokenLanguage cachespokenLanguages = (com.example.bajob.movieshatch.Pojo.SpokenLanguage) cache.get(spokenLanguagesItem);
                if (cachespokenLanguages != null) {
                    spokenLanguagesRealmList.add(cachespokenLanguages);
                } else {
                    spokenLanguagesRealmList.add(SpokenLanguageRealmProxy.copyOrUpdate(realm, spokenLanguagesList.get(i), true, cache));
                }
            }
        }
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$status(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$status());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$tagline(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$tagline());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$title(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$title());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$video(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$video());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$voteAverage(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$voteAverage());
        ((MovieDetailedInfoRealmProxyInterface) realmObject).realmSet$voteCount(((MovieDetailedInfoRealmProxyInterface) newObject).realmGet$voteCount());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MovieDetailedInfo = [");
        stringBuilder.append("{adult:");
        stringBuilder.append(realmGet$adult() != null ? realmGet$adult() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{backdropPath:");
        stringBuilder.append(realmGet$backdropPath() != null ? realmGet$backdropPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{budget:");
        stringBuilder.append(realmGet$budget() != null ? realmGet$budget() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{genres:");
        stringBuilder.append("RealmList<Genre>[").append(realmGet$genres().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{homepage:");
        stringBuilder.append(realmGet$homepage() != null ? realmGet$homepage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{imdbId:");
        stringBuilder.append(realmGet$imdbId() != null ? realmGet$imdbId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalLanguage:");
        stringBuilder.append(realmGet$originalLanguage() != null ? realmGet$originalLanguage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalTitle:");
        stringBuilder.append(realmGet$originalTitle() != null ? realmGet$originalTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{overview:");
        stringBuilder.append(realmGet$overview() != null ? realmGet$overview() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popularity:");
        stringBuilder.append(realmGet$popularity() != null ? realmGet$popularity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{posterPath:");
        stringBuilder.append(realmGet$posterPath() != null ? realmGet$posterPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{productionCompanies:");
        stringBuilder.append("RealmList<ProductionCompany>[").append(realmGet$productionCompanies().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{productionCountries:");
        stringBuilder.append("RealmList<ProductionCountry>[").append(realmGet$productionCountries().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{releaseDate:");
        stringBuilder.append(realmGet$releaseDate() != null ? realmGet$releaseDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{revenue:");
        stringBuilder.append(realmGet$revenue() != null ? realmGet$revenue() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{runtime:");
        stringBuilder.append(realmGet$runtime() != null ? realmGet$runtime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{spokenLanguages:");
        stringBuilder.append("RealmList<SpokenLanguage>[").append(realmGet$spokenLanguages().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tagline:");
        stringBuilder.append(realmGet$tagline() != null ? realmGet$tagline() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{video:");
        stringBuilder.append(realmGet$video() != null ? realmGet$video() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{voteAverage:");
        stringBuilder.append(realmGet$voteAverage() != null ? realmGet$voteAverage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{voteCount:");
        stringBuilder.append(realmGet$voteCount() != null ? realmGet$voteCount() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDetailedInfoRealmProxy aMovieDetailedInfo = (MovieDetailedInfoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMovieDetailedInfo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovieDetailedInfo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMovieDetailedInfo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
