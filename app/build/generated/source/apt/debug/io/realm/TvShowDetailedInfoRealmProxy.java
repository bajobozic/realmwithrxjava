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

public class TvShowDetailedInfoRealmProxy extends com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo
    implements RealmObjectProxy, TvShowDetailedInfoRealmProxyInterface {

    static final class TvShowDetailedInfoColumnInfo extends ColumnInfo
        implements Cloneable {

        public long backdropPathIndex;
        public long createdByIndex;
        public long episodeRunTimeIndex;
        public long firstAirDateIndex;
        public long genresIndex;
        public long homepageIndex;
        public long idIndex;
        public long inProductionIndex;
        public long languagesIndex;
        public long lastAirDateIndex;
        public long nameIndex;
        public long networksIndex;
        public long numberOfEpisodesIndex;
        public long numberOfSeasonsIndex;
        public long originCountryIndex;
        public long originalLanguageIndex;
        public long originalNameIndex;
        public long overviewIndex;
        public long popularityIndex;
        public long posterPathIndex;
        public long productionCompaniesIndex;
        public long seasonsIndex;
        public long statusIndex;
        public long typeIndex;
        public long voteAverageIndex;
        public long voteCountIndex;

        TvShowDetailedInfoColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(26);
            this.backdropPathIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "backdropPath");
            indicesMap.put("backdropPath", this.backdropPathIndex);
            this.createdByIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "createdBy");
            indicesMap.put("createdBy", this.createdByIndex);
            this.episodeRunTimeIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "episodeRunTime");
            indicesMap.put("episodeRunTime", this.episodeRunTimeIndex);
            this.firstAirDateIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "firstAirDate");
            indicesMap.put("firstAirDate", this.firstAirDateIndex);
            this.genresIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "genres");
            indicesMap.put("genres", this.genresIndex);
            this.homepageIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "homepage");
            indicesMap.put("homepage", this.homepageIndex);
            this.idIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "id");
            indicesMap.put("id", this.idIndex);
            this.inProductionIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "inProduction");
            indicesMap.put("inProduction", this.inProductionIndex);
            this.languagesIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "languages");
            indicesMap.put("languages", this.languagesIndex);
            this.lastAirDateIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "lastAirDate");
            indicesMap.put("lastAirDate", this.lastAirDateIndex);
            this.nameIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "name");
            indicesMap.put("name", this.nameIndex);
            this.networksIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "networks");
            indicesMap.put("networks", this.networksIndex);
            this.numberOfEpisodesIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "numberOfEpisodes");
            indicesMap.put("numberOfEpisodes", this.numberOfEpisodesIndex);
            this.numberOfSeasonsIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "numberOfSeasons");
            indicesMap.put("numberOfSeasons", this.numberOfSeasonsIndex);
            this.originCountryIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "originCountry");
            indicesMap.put("originCountry", this.originCountryIndex);
            this.originalLanguageIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "originalLanguage");
            indicesMap.put("originalLanguage", this.originalLanguageIndex);
            this.originalNameIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "originalName");
            indicesMap.put("originalName", this.originalNameIndex);
            this.overviewIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "overview");
            indicesMap.put("overview", this.overviewIndex);
            this.popularityIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "popularity");
            indicesMap.put("popularity", this.popularityIndex);
            this.posterPathIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "posterPath");
            indicesMap.put("posterPath", this.posterPathIndex);
            this.productionCompaniesIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "productionCompanies");
            indicesMap.put("productionCompanies", this.productionCompaniesIndex);
            this.seasonsIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "seasons");
            indicesMap.put("seasons", this.seasonsIndex);
            this.statusIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "status");
            indicesMap.put("status", this.statusIndex);
            this.typeIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "type");
            indicesMap.put("type", this.typeIndex);
            this.voteAverageIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "voteAverage");
            indicesMap.put("voteAverage", this.voteAverageIndex);
            this.voteCountIndex = getValidColumnIndex(path, table, "TvShowDetailedInfo", "voteCount");
            indicesMap.put("voteCount", this.voteCountIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final TvShowDetailedInfoColumnInfo otherInfo = (TvShowDetailedInfoColumnInfo) other;
            this.backdropPathIndex = otherInfo.backdropPathIndex;
            this.createdByIndex = otherInfo.createdByIndex;
            this.episodeRunTimeIndex = otherInfo.episodeRunTimeIndex;
            this.firstAirDateIndex = otherInfo.firstAirDateIndex;
            this.genresIndex = otherInfo.genresIndex;
            this.homepageIndex = otherInfo.homepageIndex;
            this.idIndex = otherInfo.idIndex;
            this.inProductionIndex = otherInfo.inProductionIndex;
            this.languagesIndex = otherInfo.languagesIndex;
            this.lastAirDateIndex = otherInfo.lastAirDateIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.networksIndex = otherInfo.networksIndex;
            this.numberOfEpisodesIndex = otherInfo.numberOfEpisodesIndex;
            this.numberOfSeasonsIndex = otherInfo.numberOfSeasonsIndex;
            this.originCountryIndex = otherInfo.originCountryIndex;
            this.originalLanguageIndex = otherInfo.originalLanguageIndex;
            this.originalNameIndex = otherInfo.originalNameIndex;
            this.overviewIndex = otherInfo.overviewIndex;
            this.popularityIndex = otherInfo.popularityIndex;
            this.posterPathIndex = otherInfo.posterPathIndex;
            this.productionCompaniesIndex = otherInfo.productionCompaniesIndex;
            this.seasonsIndex = otherInfo.seasonsIndex;
            this.statusIndex = otherInfo.statusIndex;
            this.typeIndex = otherInfo.typeIndex;
            this.voteAverageIndex = otherInfo.voteAverageIndex;
            this.voteCountIndex = otherInfo.voteCountIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final TvShowDetailedInfoColumnInfo clone() {
            return (TvShowDetailedInfoColumnInfo) super.clone();
        }

    }
    private TvShowDetailedInfoColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo> proxyState;
    private RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByRealmList;
    private RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresRealmList;
    private RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksRealmList;
    private RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesRealmList;
    private RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("backdropPath");
        fieldNames.add("createdBy");
        fieldNames.add("episodeRunTime");
        fieldNames.add("firstAirDate");
        fieldNames.add("genres");
        fieldNames.add("homepage");
        fieldNames.add("id");
        fieldNames.add("inProduction");
        fieldNames.add("languages");
        fieldNames.add("lastAirDate");
        fieldNames.add("name");
        fieldNames.add("networks");
        fieldNames.add("numberOfEpisodes");
        fieldNames.add("numberOfSeasons");
        fieldNames.add("originCountry");
        fieldNames.add("originalLanguage");
        fieldNames.add("originalName");
        fieldNames.add("overview");
        fieldNames.add("popularity");
        fieldNames.add("posterPath");
        fieldNames.add("productionCompanies");
        fieldNames.add("seasons");
        fieldNames.add("status");
        fieldNames.add("type");
        fieldNames.add("voteAverage");
        fieldNames.add("voteCount");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    TvShowDetailedInfoRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TvShowDetailedInfoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo>(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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

    public RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> realmGet$createdBy() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (createdByRealmList != null) {
            return createdByRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.createdByIndex);
            createdByRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy>(com.example.bajob.movieshatch.Pojo.CreatedBy.class, linkView, proxyState.getRealm$realm());
            return createdByRealmList;
        }
    }

    public void realmSet$createdBy(RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("createdBy")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy>();
                for (com.example.bajob.movieshatch.Pojo.CreatedBy item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.createdByIndex);
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
    public String realmGet$episodeRunTime() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.episodeRunTimeIndex);
    }

    public void realmSet$episodeRunTime(String value) {
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
                row.getTable().setNull(columnInfo.episodeRunTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.episodeRunTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.episodeRunTimeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.episodeRunTimeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$firstAirDate() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.firstAirDateIndex);
    }

    public void realmSet$firstAirDate(String value) {
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
                row.getTable().setNull(columnInfo.firstAirDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.firstAirDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.firstAirDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.firstAirDateIndex, value);
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
    public Boolean realmGet$inProduction() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.inProductionIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.inProductionIndex);
    }

    public void realmSet$inProduction(Boolean value) {
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
                row.getTable().setNull(columnInfo.inProductionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.inProductionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.inProductionIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.inProductionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$languages() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.languagesIndex);
    }

    public void realmSet$languages(String value) {
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
                row.getTable().setNull(columnInfo.languagesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.languagesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.languagesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.languagesIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$lastAirDate() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lastAirDateIndex);
    }

    public void realmSet$lastAirDate(String value) {
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
                row.getTable().setNull(columnInfo.lastAirDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.lastAirDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lastAirDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lastAirDateIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
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
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    public RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> realmGet$networks() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (networksRealmList != null) {
            return networksRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.networksIndex);
            networksRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork>(com.example.bajob.movieshatch.Pojo.TvNetwork.class, linkView, proxyState.getRealm$realm());
            return networksRealmList;
        }
    }

    public void realmSet$networks(RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("networks")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork>();
                for (com.example.bajob.movieshatch.Pojo.TvNetwork item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.networksIndex);
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
    public Integer realmGet$numberOfEpisodes() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.numberOfEpisodesIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.numberOfEpisodesIndex);
    }

    public void realmSet$numberOfEpisodes(Integer value) {
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
                row.getTable().setNull(columnInfo.numberOfEpisodesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.numberOfEpisodesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numberOfEpisodesIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.numberOfEpisodesIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$numberOfSeasons() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.numberOfSeasonsIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.numberOfSeasonsIndex);
    }

    public void realmSet$numberOfSeasons(Integer value) {
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
                row.getTable().setNull(columnInfo.numberOfSeasonsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.numberOfSeasonsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numberOfSeasonsIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.numberOfSeasonsIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$originCountry() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.originCountryIndex);
    }

    public void realmSet$originCountry(String value) {
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
                row.getTable().setNull(columnInfo.originCountryIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.originCountryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.originCountryIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.originCountryIndex, value);
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
    public String realmGet$originalName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.originalNameIndex);
    }

    public void realmSet$originalName(String value) {
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
                row.getTable().setNull(columnInfo.originalNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.originalNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.originalNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.originalNameIndex, value);
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

    public RealmList<com.example.bajob.movieshatch.Pojo.Season> realmGet$seasons() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (seasonsRealmList != null) {
            return seasonsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.seasonsIndex);
            seasonsRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.Season>(com.example.bajob.movieshatch.Pojo.Season.class, linkView, proxyState.getRealm$realm());
            return seasonsRealmList;
        }
    }

    public void realmSet$seasons(RealmList<com.example.bajob.movieshatch.Pojo.Season> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("seasons")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.bajob.movieshatch.Pojo.Season> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.Season>();
                for (com.example.bajob.movieshatch.Pojo.Season item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.seasonsIndex);
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
    public String realmGet$type() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    public void realmSet$type(String value) {
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
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
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
        if (!realmSchema.contains("TvShowDetailedInfo")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("TvShowDetailedInfo");
            realmObjectSchema.add(new Property("backdropPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("CreatedBy")) {
                CreatedByRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("createdBy", RealmFieldType.LIST, realmSchema.get("CreatedBy")));
            realmObjectSchema.add(new Property("episodeRunTime", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("firstAirDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("Genre")) {
                GenreRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("genres", RealmFieldType.LIST, realmSchema.get("Genre")));
            realmObjectSchema.add(new Property("homepage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("inProduction", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("languages", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("lastAirDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("TvNetwork")) {
                TvNetworkRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("networks", RealmFieldType.LIST, realmSchema.get("TvNetwork")));
            realmObjectSchema.add(new Property("numberOfEpisodes", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("numberOfSeasons", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originCountry", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originalLanguage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originalName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("overview", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popularity", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("posterPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("ProductionCompany")) {
                ProductionCompanyRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("productionCompanies", RealmFieldType.LIST, realmSchema.get("ProductionCompany")));
            if (!realmSchema.contains("Season")) {
                SeasonRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("seasons", RealmFieldType.LIST, realmSchema.get("Season")));
            realmObjectSchema.add(new Property("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voteAverage", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voteCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("TvShowDetailedInfo");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_TvShowDetailedInfo")) {
            Table table = sharedRealm.getTable("class_TvShowDetailedInfo");
            table.addColumn(RealmFieldType.STRING, "backdropPath", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_CreatedBy")) {
                CreatedByRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "createdBy", sharedRealm.getTable("class_CreatedBy"));
            table.addColumn(RealmFieldType.STRING, "episodeRunTime", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "firstAirDate", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_Genre")) {
                GenreRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "genres", sharedRealm.getTable("class_Genre"));
            table.addColumn(RealmFieldType.STRING, "homepage", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "inProduction", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "languages", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "lastAirDate", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_TvNetwork")) {
                TvNetworkRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "networks", sharedRealm.getTable("class_TvNetwork"));
            table.addColumn(RealmFieldType.INTEGER, "numberOfEpisodes", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "numberOfSeasons", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originCountry", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originalLanguage", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originalName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "overview", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "popularity", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "posterPath", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_ProductionCompany")) {
                ProductionCompanyRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "productionCompanies", sharedRealm.getTable("class_ProductionCompany"));
            if (!sharedRealm.hasTable("class_Season")) {
                SeasonRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "seasons", sharedRealm.getTable("class_Season"));
            table.addColumn(RealmFieldType.STRING, "status", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "type", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "voteAverage", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "voteCount", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_TvShowDetailedInfo");
    }

    public static TvShowDetailedInfoColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_TvShowDetailedInfo")) {
            Table table = sharedRealm.getTable("class_TvShowDetailedInfo");
            final long columnCount = table.getColumnCount();
            if (columnCount != 26) {
                if (columnCount < 26) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 26 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 26 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 26 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final TvShowDetailedInfoColumnInfo columnInfo = new TvShowDetailedInfoColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.idIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
                }
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
            if (!columnTypes.containsKey("createdBy")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'createdBy'");
            }
            if (columnTypes.get("createdBy") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'CreatedBy' for field 'createdBy'");
            }
            if (!sharedRealm.hasTable("class_CreatedBy")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_CreatedBy' for field 'createdBy'");
            }
            Table table_1 = sharedRealm.getTable("class_CreatedBy");
            if (!table.getLinkTarget(columnInfo.createdByIndex).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'createdBy': '" + table.getLinkTarget(columnInfo.createdByIndex).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            if (!columnTypes.containsKey("episodeRunTime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'episodeRunTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("episodeRunTime") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'episodeRunTime' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.episodeRunTimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'episodeRunTime' is required. Either set @Required to field 'episodeRunTime' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("firstAirDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'firstAirDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("firstAirDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'firstAirDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.firstAirDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'firstAirDate' is required. Either set @Required to field 'firstAirDate' or migrate using RealmObjectSchema.setNullable().");
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
            Table table_4 = sharedRealm.getTable("class_Genre");
            if (!table.getLinkTarget(columnInfo.genresIndex).hasSameSchema(table_4)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'genres': '" + table.getLinkTarget(columnInfo.genresIndex).getName() + "' expected - was '" + table_4.getName() + "'");
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
            if (!columnTypes.containsKey("inProduction")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'inProduction' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("inProduction") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'inProduction' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.inProductionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'inProduction' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'inProduction' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("languages")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'languages' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("languages") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'languages' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.languagesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'languages' is required. Either set @Required to field 'languages' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("lastAirDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'lastAirDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("lastAirDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'lastAirDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.lastAirDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'lastAirDate' is required. Either set @Required to field 'lastAirDate' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("networks")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'networks'");
            }
            if (columnTypes.get("networks") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'TvNetwork' for field 'networks'");
            }
            if (!sharedRealm.hasTable("class_TvNetwork")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_TvNetwork' for field 'networks'");
            }
            Table table_11 = sharedRealm.getTable("class_TvNetwork");
            if (!table.getLinkTarget(columnInfo.networksIndex).hasSameSchema(table_11)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'networks': '" + table.getLinkTarget(columnInfo.networksIndex).getName() + "' expected - was '" + table_11.getName() + "'");
            }
            if (!columnTypes.containsKey("numberOfEpisodes")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numberOfEpisodes' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("numberOfEpisodes") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'numberOfEpisodes' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.numberOfEpisodesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'numberOfEpisodes' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'numberOfEpisodes' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("numberOfSeasons")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numberOfSeasons' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("numberOfSeasons") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'numberOfSeasons' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.numberOfSeasonsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'numberOfSeasons' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'numberOfSeasons' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("originCountry")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originCountry' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("originCountry") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originCountry' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.originCountryIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originCountry' is required. Either set @Required to field 'originCountry' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("originalName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originalName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("originalName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originalName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.originalNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originalName' is required. Either set @Required to field 'originalName' or migrate using RealmObjectSchema.setNullable().");
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
            Table table_20 = sharedRealm.getTable("class_ProductionCompany");
            if (!table.getLinkTarget(columnInfo.productionCompaniesIndex).hasSameSchema(table_20)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'productionCompanies': '" + table.getLinkTarget(columnInfo.productionCompaniesIndex).getName() + "' expected - was '" + table_20.getName() + "'");
            }
            if (!columnTypes.containsKey("seasons")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'seasons'");
            }
            if (columnTypes.get("seasons") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Season' for field 'seasons'");
            }
            if (!sharedRealm.hasTable("class_Season")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Season' for field 'seasons'");
            }
            Table table_21 = sharedRealm.getTable("class_Season");
            if (!table.getLinkTarget(columnInfo.seasonsIndex).hasSameSchema(table_21)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'seasons': '" + table.getLinkTarget(columnInfo.seasonsIndex).getName() + "' expected - was '" + table_21.getName() + "'");
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
            if (!columnTypes.containsKey("type")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("type") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'type' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.typeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'type' is required. Either set @Required to field 'type' or migrate using RealmObjectSchema.setNullable().");
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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'TvShowDetailedInfo' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_TvShowDetailedInfo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(5);
        com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class), false, Collections.<String> emptyList());
                    obj = new io.realm.TvShowDetailedInfoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("createdBy")) {
                excludeFields.add("createdBy");
            }
            if (json.has("genres")) {
                excludeFields.add("genres");
            }
            if (json.has("networks")) {
                excludeFields.add("networks");
            }
            if (json.has("productionCompanies")) {
                excludeFields.add("productionCompanies");
            }
            if (json.has("seasons")) {
                excludeFields.add("seasons");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.TvShowDetailedInfoRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.TvShowDetailedInfoRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("backdropPath")) {
            if (json.isNull("backdropPath")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$backdropPath(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$backdropPath((String) json.getString("backdropPath"));
            }
        }
        if (json.has("createdBy")) {
            if (json.isNull("createdBy")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$createdBy(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$createdBy().clear();
                JSONArray array = json.getJSONArray("createdBy");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.CreatedBy item = CreatedByRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$createdBy().add(item);
                }
            }
        }
        if (json.has("episodeRunTime")) {
            if (json.isNull("episodeRunTime")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$episodeRunTime(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$episodeRunTime((String) json.getString("episodeRunTime"));
            }
        }
        if (json.has("firstAirDate")) {
            if (json.isNull("firstAirDate")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$firstAirDate(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$firstAirDate((String) json.getString("firstAirDate"));
            }
        }
        if (json.has("genres")) {
            if (json.isNull("genres")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$genres(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$genres().clear();
                JSONArray array = json.getJSONArray("genres");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.Genre item = GenreRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$genres().add(item);
                }
            }
        }
        if (json.has("homepage")) {
            if (json.isNull("homepage")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$homepage(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$homepage((String) json.getString("homepage"));
            }
        }
        if (json.has("inProduction")) {
            if (json.isNull("inProduction")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$inProduction(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$inProduction((boolean) json.getBoolean("inProduction"));
            }
        }
        if (json.has("languages")) {
            if (json.isNull("languages")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$languages(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$languages((String) json.getString("languages"));
            }
        }
        if (json.has("lastAirDate")) {
            if (json.isNull("lastAirDate")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$lastAirDate(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$lastAirDate((String) json.getString("lastAirDate"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("networks")) {
            if (json.isNull("networks")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$networks(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$networks().clear();
                JSONArray array = json.getJSONArray("networks");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.TvNetwork item = TvNetworkRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$networks().add(item);
                }
            }
        }
        if (json.has("numberOfEpisodes")) {
            if (json.isNull("numberOfEpisodes")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$numberOfEpisodes(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$numberOfEpisodes((int) json.getInt("numberOfEpisodes"));
            }
        }
        if (json.has("numberOfSeasons")) {
            if (json.isNull("numberOfSeasons")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$numberOfSeasons(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$numberOfSeasons((int) json.getInt("numberOfSeasons"));
            }
        }
        if (json.has("originCountry")) {
            if (json.isNull("originCountry")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originCountry(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originCountry((String) json.getString("originCountry"));
            }
        }
        if (json.has("originalLanguage")) {
            if (json.isNull("originalLanguage")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originalLanguage(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originalLanguage((String) json.getString("originalLanguage"));
            }
        }
        if (json.has("originalName")) {
            if (json.isNull("originalName")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originalName(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originalName((String) json.getString("originalName"));
            }
        }
        if (json.has("overview")) {
            if (json.isNull("overview")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$overview(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$overview((String) json.getString("overview"));
            }
        }
        if (json.has("popularity")) {
            if (json.isNull("popularity")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$popularity(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$popularity((double) json.getDouble("popularity"));
            }
        }
        if (json.has("posterPath")) {
            if (json.isNull("posterPath")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$posterPath(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$posterPath((String) json.getString("posterPath"));
            }
        }
        if (json.has("productionCompanies")) {
            if (json.isNull("productionCompanies")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$productionCompanies(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$productionCompanies().clear();
                JSONArray array = json.getJSONArray("productionCompanies");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.ProductionCompany item = ProductionCompanyRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$productionCompanies().add(item);
                }
            }
        }
        if (json.has("seasons")) {
            if (json.isNull("seasons")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$seasons(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$seasons().clear();
                JSONArray array = json.getJSONArray("seasons");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.Season item = SeasonRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$seasons().add(item);
                }
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$status(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$type(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("voteAverage")) {
            if (json.isNull("voteAverage")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$voteAverage(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$voteAverage((double) json.getDouble("voteAverage"));
            }
        }
        if (json.has("voteCount")) {
            if (json.isNull("voteCount")) {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$voteCount(null);
            } else {
                ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$voteCount((int) json.getInt("voteCount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo obj = new com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("backdropPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$backdropPath(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$backdropPath((String) reader.nextString());
                }
            } else if (name.equals("createdBy")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$createdBy(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$createdBy(new RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.CreatedBy item = CreatedByRealmProxy.createUsingJsonStream(realm, reader);
                        ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$createdBy().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("episodeRunTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$episodeRunTime(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$episodeRunTime((String) reader.nextString());
                }
            } else if (name.equals("firstAirDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$firstAirDate(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$firstAirDate((String) reader.nextString());
                }
            } else if (name.equals("genres")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$genres(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$genres(new RealmList<com.example.bajob.movieshatch.Pojo.Genre>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.Genre item = GenreRealmProxy.createUsingJsonStream(realm, reader);
                        ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$genres().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("homepage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$homepage(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$homepage((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("inProduction")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$inProduction(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$inProduction((boolean) reader.nextBoolean());
                }
            } else if (name.equals("languages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$languages(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$languages((String) reader.nextString());
                }
            } else if (name.equals("lastAirDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$lastAirDate(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$lastAirDate((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("networks")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$networks(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$networks(new RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.TvNetwork item = TvNetworkRealmProxy.createUsingJsonStream(realm, reader);
                        ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$networks().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("numberOfEpisodes")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$numberOfEpisodes(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$numberOfEpisodes((int) reader.nextInt());
                }
            } else if (name.equals("numberOfSeasons")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$numberOfSeasons(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$numberOfSeasons((int) reader.nextInt());
                }
            } else if (name.equals("originCountry")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originCountry(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originCountry((String) reader.nextString());
                }
            } else if (name.equals("originalLanguage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originalLanguage(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originalLanguage((String) reader.nextString());
                }
            } else if (name.equals("originalName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originalName(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$originalName((String) reader.nextString());
                }
            } else if (name.equals("overview")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$overview(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$overview((String) reader.nextString());
                }
            } else if (name.equals("popularity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$popularity(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$popularity((double) reader.nextDouble());
                }
            } else if (name.equals("posterPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$posterPath(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$posterPath((String) reader.nextString());
                }
            } else if (name.equals("productionCompanies")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$productionCompanies(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$productionCompanies(new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.ProductionCompany item = ProductionCompanyRealmProxy.createUsingJsonStream(realm, reader);
                        ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$productionCompanies().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("seasons")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$seasons(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$seasons(new RealmList<com.example.bajob.movieshatch.Pojo.Season>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.Season item = SeasonRealmProxy.createUsingJsonStream(realm, reader);
                        ((TvShowDetailedInfoRealmProxyInterface) obj).realmGet$seasons().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("status")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$status(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$status((String) reader.nextString());
                }
            } else if (name.equals("type")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$type(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$type((String) reader.nextString());
                }
            } else if (name.equals("voteAverage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$voteAverage(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$voteAverage((double) reader.nextDouble());
                }
            } else if (name.equals("voteCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$voteCount(null);
                } else {
                    ((TvShowDetailedInfoRealmProxyInterface) obj).realmSet$voteCount((int) reader.nextInt());
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

    public static com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) cachedRealmObject;
        } else {
            com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.TvShowDetailedInfoRealmProxy();
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

    public static com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo copy(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class, ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$backdropPath(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$backdropPath());

            RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$createdBy();
            if (createdByList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$createdBy();
                for (int i = 0; i < createdByList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.CreatedBy createdByItem = createdByList.get(i);
                    com.example.bajob.movieshatch.Pojo.CreatedBy cachecreatedBy = (com.example.bajob.movieshatch.Pojo.CreatedBy) cache.get(createdByItem);
                    if (cachecreatedBy != null) {
                        createdByRealmList.add(cachecreatedBy);
                    } else {
                        createdByRealmList.add(CreatedByRealmProxy.copyOrUpdate(realm, createdByList.get(i), update, cache));
                    }
                }
            }

            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$episodeRunTime(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$episodeRunTime());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$firstAirDate(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$firstAirDate());

            RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$genres();
            if (genresList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$genres();
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

            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$homepage(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$homepage());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$inProduction(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$inProduction());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$languages(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$languages());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$lastAirDate(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$lastAirDate());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$name(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$name());

            RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$networks();
            if (networksList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$networks();
                for (int i = 0; i < networksList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.TvNetwork networksItem = networksList.get(i);
                    com.example.bajob.movieshatch.Pojo.TvNetwork cachenetworks = (com.example.bajob.movieshatch.Pojo.TvNetwork) cache.get(networksItem);
                    if (cachenetworks != null) {
                        networksRealmList.add(cachenetworks);
                    } else {
                        networksRealmList.add(TvNetworkRealmProxy.copyOrUpdate(realm, networksList.get(i), update, cache));
                    }
                }
            }

            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$numberOfEpisodes(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$numberOfEpisodes());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$numberOfSeasons(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$numberOfSeasons());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$originCountry(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$originCountry());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$originalLanguage(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$originalLanguage());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$originalName(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$originalName());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$overview(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$overview());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$popularity(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$popularity());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$posterPath(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$posterPath());

            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$productionCompanies();
            if (productionCompaniesList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCompanies();
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


            RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$seasons();
            if (seasonsList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$seasons();
                for (int i = 0; i < seasonsList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.Season seasonsItem = seasonsList.get(i);
                    com.example.bajob.movieshatch.Pojo.Season cacheseasons = (com.example.bajob.movieshatch.Pojo.Season) cache.get(seasonsItem);
                    if (cacheseasons != null) {
                        seasonsRealmList.add(cacheseasons);
                    } else {
                        seasonsRealmList.add(SeasonRealmProxy.copyOrUpdate(realm, seasonsList.get(i), update, cache));
                    }
                }
            }

            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$status(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$status());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$type(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$type());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$voteAverage(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$voteAverage());
            ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$voteCount(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$voteCount());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        TvShowDetailedInfoColumnInfo columnInfo = (TvShowDetailedInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$backdropPath = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        }

        RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$createdBy();
        if (createdByList != null) {
            long createdByNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.createdByIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.CreatedBy createdByItem : createdByList) {
                Long cacheItemIndexcreatedBy = cache.get(createdByItem);
                if (cacheItemIndexcreatedBy == null) {
                    cacheItemIndexcreatedBy = CreatedByRealmProxy.insert(realm, createdByItem, cache);
                }
                LinkView.nativeAdd(createdByNativeLinkViewPtr, cacheItemIndexcreatedBy);
            }
        }

        String realmGet$episodeRunTime = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$episodeRunTime();
        if (realmGet$episodeRunTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.episodeRunTimeIndex, rowIndex, realmGet$episodeRunTime, false);
        }
        String realmGet$firstAirDate = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$firstAirDate();
        if (realmGet$firstAirDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, realmGet$firstAirDate, false);
        }

        RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$genres();
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

        String realmGet$homepage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$homepage();
        if (realmGet$homepage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
        }
        Boolean realmGet$inProduction = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$inProduction();
        if (realmGet$inProduction != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.inProductionIndex, rowIndex, realmGet$inProduction, false);
        }
        String realmGet$languages = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$languages();
        if (realmGet$languages != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languagesIndex, rowIndex, realmGet$languages, false);
        }
        String realmGet$lastAirDate = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$lastAirDate();
        if (realmGet$lastAirDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastAirDateIndex, rowIndex, realmGet$lastAirDate, false);
        }
        String realmGet$name = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }

        RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$networks();
        if (networksList != null) {
            long networksNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.networksIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.TvNetwork networksItem : networksList) {
                Long cacheItemIndexnetworks = cache.get(networksItem);
                if (cacheItemIndexnetworks == null) {
                    cacheItemIndexnetworks = TvNetworkRealmProxy.insert(realm, networksItem, cache);
                }
                LinkView.nativeAdd(networksNativeLinkViewPtr, cacheItemIndexnetworks);
            }
        }

        Number realmGet$numberOfEpisodes = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$numberOfEpisodes();
        if (realmGet$numberOfEpisodes != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numberOfEpisodesIndex, rowIndex, realmGet$numberOfEpisodes.longValue(), false);
        }
        Number realmGet$numberOfSeasons = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$numberOfSeasons();
        if (realmGet$numberOfSeasons != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numberOfSeasonsIndex, rowIndex, realmGet$numberOfSeasons.longValue(), false);
        }
        String realmGet$originCountry = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originCountry();
        if (realmGet$originCountry != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
        }
        String realmGet$originalLanguage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        }
        String realmGet$originalName = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originalName();
        if (realmGet$originalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalNameIndex, rowIndex, realmGet$originalName, false);
        }
        String realmGet$overview = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        }
        Double realmGet$popularity = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        }
        String realmGet$posterPath = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        }

        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$productionCompanies();
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


        RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$seasons();
        if (seasonsList != null) {
            long seasonsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.seasonsIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.Season seasonsItem : seasonsList) {
                Long cacheItemIndexseasons = cache.get(seasonsItem);
                if (cacheItemIndexseasons == null) {
                    cacheItemIndexseasons = SeasonRealmProxy.insert(realm, seasonsItem, cache);
                }
                LinkView.nativeAdd(seasonsNativeLinkViewPtr, cacheItemIndexseasons);
            }
        }

        String realmGet$status = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$type = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        Double realmGet$voteAverage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        }
        Number realmGet$voteCount = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        TvShowDetailedInfoColumnInfo columnInfo = (TvShowDetailedInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$backdropPath = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                }

                RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$createdBy();
                if (createdByList != null) {
                    long createdByNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.createdByIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.CreatedBy createdByItem : createdByList) {
                        Long cacheItemIndexcreatedBy = cache.get(createdByItem);
                        if (cacheItemIndexcreatedBy == null) {
                            cacheItemIndexcreatedBy = CreatedByRealmProxy.insert(realm, createdByItem, cache);
                        }
                        LinkView.nativeAdd(createdByNativeLinkViewPtr, cacheItemIndexcreatedBy);
                    }
                }

                String realmGet$episodeRunTime = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$episodeRunTime();
                if (realmGet$episodeRunTime != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.episodeRunTimeIndex, rowIndex, realmGet$episodeRunTime, false);
                }
                String realmGet$firstAirDate = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$firstAirDate();
                if (realmGet$firstAirDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, realmGet$firstAirDate, false);
                }

                RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$genres();
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

                String realmGet$homepage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$homepage();
                if (realmGet$homepage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
                }
                Boolean realmGet$inProduction = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$inProduction();
                if (realmGet$inProduction != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.inProductionIndex, rowIndex, realmGet$inProduction, false);
                }
                String realmGet$languages = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$languages();
                if (realmGet$languages != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.languagesIndex, rowIndex, realmGet$languages, false);
                }
                String realmGet$lastAirDate = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$lastAirDate();
                if (realmGet$lastAirDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.lastAirDateIndex, rowIndex, realmGet$lastAirDate, false);
                }
                String realmGet$name = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }

                RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$networks();
                if (networksList != null) {
                    long networksNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.networksIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.TvNetwork networksItem : networksList) {
                        Long cacheItemIndexnetworks = cache.get(networksItem);
                        if (cacheItemIndexnetworks == null) {
                            cacheItemIndexnetworks = TvNetworkRealmProxy.insert(realm, networksItem, cache);
                        }
                        LinkView.nativeAdd(networksNativeLinkViewPtr, cacheItemIndexnetworks);
                    }
                }

                Number realmGet$numberOfEpisodes = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$numberOfEpisodes();
                if (realmGet$numberOfEpisodes != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numberOfEpisodesIndex, rowIndex, realmGet$numberOfEpisodes.longValue(), false);
                }
                Number realmGet$numberOfSeasons = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$numberOfSeasons();
                if (realmGet$numberOfSeasons != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numberOfSeasonsIndex, rowIndex, realmGet$numberOfSeasons.longValue(), false);
                }
                String realmGet$originCountry = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originCountry();
                if (realmGet$originCountry != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
                }
                String realmGet$originalLanguage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                }
                String realmGet$originalName = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originalName();
                if (realmGet$originalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalNameIndex, rowIndex, realmGet$originalName, false);
                }
                String realmGet$overview = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                }
                Double realmGet$popularity = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                }
                String realmGet$posterPath = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                }

                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$productionCompanies();
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


                RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$seasons();
                if (seasonsList != null) {
                    long seasonsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.seasonsIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.Season seasonsItem : seasonsList) {
                        Long cacheItemIndexseasons = cache.get(seasonsItem);
                        if (cacheItemIndexseasons == null) {
                            cacheItemIndexseasons = SeasonRealmProxy.insert(realm, seasonsItem, cache);
                        }
                        LinkView.nativeAdd(seasonsNativeLinkViewPtr, cacheItemIndexseasons);
                    }
                }

                String realmGet$status = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                }
                String realmGet$type = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
                }
                Double realmGet$voteAverage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                }
                Number realmGet$voteCount = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        TvShowDetailedInfoColumnInfo columnInfo = (TvShowDetailedInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$backdropPath = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
        }

        long createdByNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.createdByIndex, rowIndex);
        LinkView.nativeClear(createdByNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$createdBy();
        if (createdByList != null) {
            for (com.example.bajob.movieshatch.Pojo.CreatedBy createdByItem : createdByList) {
                Long cacheItemIndexcreatedBy = cache.get(createdByItem);
                if (cacheItemIndexcreatedBy == null) {
                    cacheItemIndexcreatedBy = CreatedByRealmProxy.insertOrUpdate(realm, createdByItem, cache);
                }
                LinkView.nativeAdd(createdByNativeLinkViewPtr, cacheItemIndexcreatedBy);
            }
        }

        String realmGet$episodeRunTime = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$episodeRunTime();
        if (realmGet$episodeRunTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.episodeRunTimeIndex, rowIndex, realmGet$episodeRunTime, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.episodeRunTimeIndex, rowIndex, false);
        }
        String realmGet$firstAirDate = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$firstAirDate();
        if (realmGet$firstAirDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, realmGet$firstAirDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, false);
        }

        long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
        LinkView.nativeClear(genresNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$genres();
        if (genresList != null) {
            for (com.example.bajob.movieshatch.Pojo.Genre genresItem : genresList) {
                Long cacheItemIndexgenres = cache.get(genresItem);
                if (cacheItemIndexgenres == null) {
                    cacheItemIndexgenres = GenreRealmProxy.insertOrUpdate(realm, genresItem, cache);
                }
                LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
            }
        }

        String realmGet$homepage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$homepage();
        if (realmGet$homepage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.homepageIndex, rowIndex, false);
        }
        Boolean realmGet$inProduction = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$inProduction();
        if (realmGet$inProduction != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.inProductionIndex, rowIndex, realmGet$inProduction, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.inProductionIndex, rowIndex, false);
        }
        String realmGet$languages = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$languages();
        if (realmGet$languages != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languagesIndex, rowIndex, realmGet$languages, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.languagesIndex, rowIndex, false);
        }
        String realmGet$lastAirDate = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$lastAirDate();
        if (realmGet$lastAirDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastAirDateIndex, rowIndex, realmGet$lastAirDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lastAirDateIndex, rowIndex, false);
        }
        String realmGet$name = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }

        long networksNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.networksIndex, rowIndex);
        LinkView.nativeClear(networksNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$networks();
        if (networksList != null) {
            for (com.example.bajob.movieshatch.Pojo.TvNetwork networksItem : networksList) {
                Long cacheItemIndexnetworks = cache.get(networksItem);
                if (cacheItemIndexnetworks == null) {
                    cacheItemIndexnetworks = TvNetworkRealmProxy.insertOrUpdate(realm, networksItem, cache);
                }
                LinkView.nativeAdd(networksNativeLinkViewPtr, cacheItemIndexnetworks);
            }
        }

        Number realmGet$numberOfEpisodes = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$numberOfEpisodes();
        if (realmGet$numberOfEpisodes != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numberOfEpisodesIndex, rowIndex, realmGet$numberOfEpisodes.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numberOfEpisodesIndex, rowIndex, false);
        }
        Number realmGet$numberOfSeasons = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$numberOfSeasons();
        if (realmGet$numberOfSeasons != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numberOfSeasonsIndex, rowIndex, realmGet$numberOfSeasons.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numberOfSeasonsIndex, rowIndex, false);
        }
        String realmGet$originCountry = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originCountry();
        if (realmGet$originCountry != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originCountryIndex, rowIndex, false);
        }
        String realmGet$originalLanguage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
        }
        String realmGet$originalName = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originalName();
        if (realmGet$originalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalNameIndex, rowIndex, realmGet$originalName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalNameIndex, rowIndex, false);
        }
        String realmGet$overview = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
        }
        Double realmGet$popularity = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
        }
        String realmGet$posterPath = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
        }

        long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
        LinkView.nativeClear(productionCompaniesNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$productionCompanies();
        if (productionCompaniesList != null) {
            for (com.example.bajob.movieshatch.Pojo.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                if (cacheItemIndexproductionCompanies == null) {
                    cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insertOrUpdate(realm, productionCompaniesItem, cache);
                }
                LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
            }
        }


        long seasonsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.seasonsIndex, rowIndex);
        LinkView.nativeClear(seasonsNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$seasons();
        if (seasonsList != null) {
            for (com.example.bajob.movieshatch.Pojo.Season seasonsItem : seasonsList) {
                Long cacheItemIndexseasons = cache.get(seasonsItem);
                if (cacheItemIndexseasons == null) {
                    cacheItemIndexseasons = SeasonRealmProxy.insertOrUpdate(realm, seasonsItem, cache);
                }
                LinkView.nativeAdd(seasonsNativeLinkViewPtr, cacheItemIndexseasons);
            }
        }

        String realmGet$status = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$type = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        Double realmGet$voteAverage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
        }
        Number realmGet$voteCount = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        TvShowDetailedInfoColumnInfo columnInfo = (TvShowDetailedInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((TvShowDetailedInfoRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$backdropPath = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
                }

                long createdByNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.createdByIndex, rowIndex);
                LinkView.nativeClear(createdByNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$createdBy();
                if (createdByList != null) {
                    for (com.example.bajob.movieshatch.Pojo.CreatedBy createdByItem : createdByList) {
                        Long cacheItemIndexcreatedBy = cache.get(createdByItem);
                        if (cacheItemIndexcreatedBy == null) {
                            cacheItemIndexcreatedBy = CreatedByRealmProxy.insertOrUpdate(realm, createdByItem, cache);
                        }
                        LinkView.nativeAdd(createdByNativeLinkViewPtr, cacheItemIndexcreatedBy);
                    }
                }

                String realmGet$episodeRunTime = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$episodeRunTime();
                if (realmGet$episodeRunTime != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.episodeRunTimeIndex, rowIndex, realmGet$episodeRunTime, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.episodeRunTimeIndex, rowIndex, false);
                }
                String realmGet$firstAirDate = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$firstAirDate();
                if (realmGet$firstAirDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, realmGet$firstAirDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, false);
                }

                long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
                LinkView.nativeClear(genresNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$genres();
                if (genresList != null) {
                    for (com.example.bajob.movieshatch.Pojo.Genre genresItem : genresList) {
                        Long cacheItemIndexgenres = cache.get(genresItem);
                        if (cacheItemIndexgenres == null) {
                            cacheItemIndexgenres = GenreRealmProxy.insertOrUpdate(realm, genresItem, cache);
                        }
                        LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
                    }
                }

                String realmGet$homepage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$homepage();
                if (realmGet$homepage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.homepageIndex, rowIndex, false);
                }
                Boolean realmGet$inProduction = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$inProduction();
                if (realmGet$inProduction != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.inProductionIndex, rowIndex, realmGet$inProduction, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.inProductionIndex, rowIndex, false);
                }
                String realmGet$languages = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$languages();
                if (realmGet$languages != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.languagesIndex, rowIndex, realmGet$languages, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.languagesIndex, rowIndex, false);
                }
                String realmGet$lastAirDate = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$lastAirDate();
                if (realmGet$lastAirDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.lastAirDateIndex, rowIndex, realmGet$lastAirDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.lastAirDateIndex, rowIndex, false);
                }
                String realmGet$name = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }

                long networksNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.networksIndex, rowIndex);
                LinkView.nativeClear(networksNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$networks();
                if (networksList != null) {
                    for (com.example.bajob.movieshatch.Pojo.TvNetwork networksItem : networksList) {
                        Long cacheItemIndexnetworks = cache.get(networksItem);
                        if (cacheItemIndexnetworks == null) {
                            cacheItemIndexnetworks = TvNetworkRealmProxy.insertOrUpdate(realm, networksItem, cache);
                        }
                        LinkView.nativeAdd(networksNativeLinkViewPtr, cacheItemIndexnetworks);
                    }
                }

                Number realmGet$numberOfEpisodes = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$numberOfEpisodes();
                if (realmGet$numberOfEpisodes != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numberOfEpisodesIndex, rowIndex, realmGet$numberOfEpisodes.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numberOfEpisodesIndex, rowIndex, false);
                }
                Number realmGet$numberOfSeasons = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$numberOfSeasons();
                if (realmGet$numberOfSeasons != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numberOfSeasonsIndex, rowIndex, realmGet$numberOfSeasons.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numberOfSeasonsIndex, rowIndex, false);
                }
                String realmGet$originCountry = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originCountry();
                if (realmGet$originCountry != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originCountryIndex, rowIndex, false);
                }
                String realmGet$originalLanguage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
                }
                String realmGet$originalName = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$originalName();
                if (realmGet$originalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalNameIndex, rowIndex, realmGet$originalName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalNameIndex, rowIndex, false);
                }
                String realmGet$overview = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
                }
                Double realmGet$popularity = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
                }
                String realmGet$posterPath = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
                }

                long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
                LinkView.nativeClear(productionCompaniesNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$productionCompanies();
                if (productionCompaniesList != null) {
                    for (com.example.bajob.movieshatch.Pojo.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                        Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                        if (cacheItemIndexproductionCompanies == null) {
                            cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insertOrUpdate(realm, productionCompaniesItem, cache);
                        }
                        LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
                    }
                }


                long seasonsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.seasonsIndex, rowIndex);
                LinkView.nativeClear(seasonsNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsList = ((TvShowDetailedInfoRealmProxyInterface) object).realmGet$seasons();
                if (seasonsList != null) {
                    for (com.example.bajob.movieshatch.Pojo.Season seasonsItem : seasonsList) {
                        Long cacheItemIndexseasons = cache.get(seasonsItem);
                        if (cacheItemIndexseasons == null) {
                            cacheItemIndexseasons = SeasonRealmProxy.insertOrUpdate(realm, seasonsItem, cache);
                        }
                        LinkView.nativeAdd(seasonsNativeLinkViewPtr, cacheItemIndexseasons);
                    }
                }

                String realmGet$status = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
                }
                String realmGet$type = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
                }
                Double realmGet$voteAverage = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
                }
                Number realmGet$voteCount = ((TvShowDetailedInfoRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo createDetachedCopy(com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$backdropPath(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$backdropPath());

        // Deep copy of createdBy
        if (currentDepth == maxDepth) {
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$createdBy(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> managedcreatedByList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$createdBy();
            RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> unmanagedcreatedByList = new RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy>();
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$createdBy(unmanagedcreatedByList);
            int nextDepth = currentDepth + 1;
            int size = managedcreatedByList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.CreatedBy item = CreatedByRealmProxy.createDetachedCopy(managedcreatedByList.get(i), nextDepth, maxDepth, cache);
                unmanagedcreatedByList.add(item);
            }
        }
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$episodeRunTime(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$episodeRunTime());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$firstAirDate(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$firstAirDate());

        // Deep copy of genres
        if (currentDepth == maxDepth) {
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$genres(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.Genre> managedgenresList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$genres();
            RealmList<com.example.bajob.movieshatch.Pojo.Genre> unmanagedgenresList = new RealmList<com.example.bajob.movieshatch.Pojo.Genre>();
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$genres(unmanagedgenresList);
            int nextDepth = currentDepth + 1;
            int size = managedgenresList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.Genre item = GenreRealmProxy.createDetachedCopy(managedgenresList.get(i), nextDepth, maxDepth, cache);
                unmanagedgenresList.add(item);
            }
        }
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$homepage(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$homepage());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$id(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$id());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$inProduction(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$inProduction());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$languages(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$languages());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$lastAirDate(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$lastAirDate());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$name(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$name());

        // Deep copy of networks
        if (currentDepth == maxDepth) {
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$networks(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> managednetworksList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$networks();
            RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> unmanagednetworksList = new RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork>();
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$networks(unmanagednetworksList);
            int nextDepth = currentDepth + 1;
            int size = managednetworksList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.TvNetwork item = TvNetworkRealmProxy.createDetachedCopy(managednetworksList.get(i), nextDepth, maxDepth, cache);
                unmanagednetworksList.add(item);
            }
        }
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$numberOfEpisodes(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$numberOfEpisodes());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$numberOfSeasons(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$numberOfSeasons());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$originCountry(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$originCountry());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$originalLanguage(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$originalLanguage());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$originalName(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$originalName());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$overview(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$overview());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$popularity(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$popularity());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$posterPath(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$posterPath());

        // Deep copy of productionCompanies
        if (currentDepth == maxDepth) {
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$productionCompanies(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> managedproductionCompaniesList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCompanies();
            RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> unmanagedproductionCompaniesList = new RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany>();
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$productionCompanies(unmanagedproductionCompaniesList);
            int nextDepth = currentDepth + 1;
            int size = managedproductionCompaniesList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.ProductionCompany item = ProductionCompanyRealmProxy.createDetachedCopy(managedproductionCompaniesList.get(i), nextDepth, maxDepth, cache);
                unmanagedproductionCompaniesList.add(item);
            }
        }

        // Deep copy of seasons
        if (currentDepth == maxDepth) {
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$seasons(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.Season> managedseasonsList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$seasons();
            RealmList<com.example.bajob.movieshatch.Pojo.Season> unmanagedseasonsList = new RealmList<com.example.bajob.movieshatch.Pojo.Season>();
            ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$seasons(unmanagedseasonsList);
            int nextDepth = currentDepth + 1;
            int size = managedseasonsList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.Season item = SeasonRealmProxy.createDetachedCopy(managedseasonsList.get(i), nextDepth, maxDepth, cache);
                unmanagedseasonsList.add(item);
            }
        }
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$status(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$status());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$type(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$type());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$voteAverage(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$voteAverage());
        ((TvShowDetailedInfoRealmProxyInterface) unmanagedObject).realmSet$voteCount(((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$voteCount());
        return unmanagedObject;
    }

    static com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo update(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo realmObject, com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$backdropPath(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$backdropPath());
        RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$createdBy();
        RealmList<com.example.bajob.movieshatch.Pojo.CreatedBy> createdByRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$createdBy();
        createdByRealmList.clear();
        if (createdByList != null) {
            for (int i = 0; i < createdByList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.CreatedBy createdByItem = createdByList.get(i);
                com.example.bajob.movieshatch.Pojo.CreatedBy cachecreatedBy = (com.example.bajob.movieshatch.Pojo.CreatedBy) cache.get(createdByItem);
                if (cachecreatedBy != null) {
                    createdByRealmList.add(cachecreatedBy);
                } else {
                    createdByRealmList.add(CreatedByRealmProxy.copyOrUpdate(realm, createdByList.get(i), true, cache));
                }
            }
        }
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$episodeRunTime(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$episodeRunTime());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$firstAirDate(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$firstAirDate());
        RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$genres();
        RealmList<com.example.bajob.movieshatch.Pojo.Genre> genresRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$genres();
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
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$homepage(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$homepage());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$inProduction(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$inProduction());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$languages(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$languages());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$lastAirDate(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$lastAirDate());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$name(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$name());
        RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$networks();
        RealmList<com.example.bajob.movieshatch.Pojo.TvNetwork> networksRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$networks();
        networksRealmList.clear();
        if (networksList != null) {
            for (int i = 0; i < networksList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.TvNetwork networksItem = networksList.get(i);
                com.example.bajob.movieshatch.Pojo.TvNetwork cachenetworks = (com.example.bajob.movieshatch.Pojo.TvNetwork) cache.get(networksItem);
                if (cachenetworks != null) {
                    networksRealmList.add(cachenetworks);
                } else {
                    networksRealmList.add(TvNetworkRealmProxy.copyOrUpdate(realm, networksList.get(i), true, cache));
                }
            }
        }
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$numberOfEpisodes(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$numberOfEpisodes());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$numberOfSeasons(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$numberOfSeasons());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$originCountry(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$originCountry());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$originalLanguage(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$originalLanguage());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$originalName(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$originalName());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$overview(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$overview());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$popularity(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$popularity());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$posterPath(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$posterPath());
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$productionCompanies();
        RealmList<com.example.bajob.movieshatch.Pojo.ProductionCompany> productionCompaniesRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$productionCompanies();
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
        RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsList = ((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$seasons();
        RealmList<com.example.bajob.movieshatch.Pojo.Season> seasonsRealmList = ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmGet$seasons();
        seasonsRealmList.clear();
        if (seasonsList != null) {
            for (int i = 0; i < seasonsList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.Season seasonsItem = seasonsList.get(i);
                com.example.bajob.movieshatch.Pojo.Season cacheseasons = (com.example.bajob.movieshatch.Pojo.Season) cache.get(seasonsItem);
                if (cacheseasons != null) {
                    seasonsRealmList.add(cacheseasons);
                } else {
                    seasonsRealmList.add(SeasonRealmProxy.copyOrUpdate(realm, seasonsList.get(i), true, cache));
                }
            }
        }
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$status(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$status());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$type(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$type());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$voteAverage(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$voteAverage());
        ((TvShowDetailedInfoRealmProxyInterface) realmObject).realmSet$voteCount(((TvShowDetailedInfoRealmProxyInterface) newObject).realmGet$voteCount());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TvShowDetailedInfo = [");
        stringBuilder.append("{backdropPath:");
        stringBuilder.append(realmGet$backdropPath() != null ? realmGet$backdropPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdBy:");
        stringBuilder.append("RealmList<CreatedBy>[").append(realmGet$createdBy().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{episodeRunTime:");
        stringBuilder.append(realmGet$episodeRunTime() != null ? realmGet$episodeRunTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{firstAirDate:");
        stringBuilder.append(realmGet$firstAirDate() != null ? realmGet$firstAirDate() : "null");
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
        stringBuilder.append("{inProduction:");
        stringBuilder.append(realmGet$inProduction() != null ? realmGet$inProduction() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{languages:");
        stringBuilder.append(realmGet$languages() != null ? realmGet$languages() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastAirDate:");
        stringBuilder.append(realmGet$lastAirDate() != null ? realmGet$lastAirDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{networks:");
        stringBuilder.append("RealmList<TvNetwork>[").append(realmGet$networks().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberOfEpisodes:");
        stringBuilder.append(realmGet$numberOfEpisodes() != null ? realmGet$numberOfEpisodes() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberOfSeasons:");
        stringBuilder.append(realmGet$numberOfSeasons() != null ? realmGet$numberOfSeasons() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originCountry:");
        stringBuilder.append(realmGet$originCountry() != null ? realmGet$originCountry() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalLanguage:");
        stringBuilder.append(realmGet$originalLanguage() != null ? realmGet$originalLanguage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalName:");
        stringBuilder.append(realmGet$originalName() != null ? realmGet$originalName() : "null");
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
        stringBuilder.append("{seasons:");
        stringBuilder.append("RealmList<Season>[").append(realmGet$seasons().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
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
        TvShowDetailedInfoRealmProxy aTvShowDetailedInfo = (TvShowDetailedInfoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTvShowDetailedInfo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTvShowDetailedInfo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTvShowDetailedInfo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
