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

public class MovieInfoRealmProxy extends com.example.bajob.movieshatch.Pojo.MovieInfo
    implements RealmObjectProxy, MovieInfoRealmProxyInterface {

    static final class MovieInfoColumnInfo extends ColumnInfo
        implements Cloneable {

        public long posterPathIndex;
        public long adultIndex;
        public long overviewIndex;
        public long releaseDateIndex;
        public long genreIdsIndex;
        public long idIndex;
        public long originalTitleIndex;
        public long originalLanguageIndex;
        public long titleIndex;
        public long backdropPathIndex;
        public long popularityIndex;
        public long voteCountIndex;
        public long videoIndex;
        public long voteAverageIndex;

        MovieInfoColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(14);
            this.posterPathIndex = getValidColumnIndex(path, table, "MovieInfo", "posterPath");
            indicesMap.put("posterPath", this.posterPathIndex);
            this.adultIndex = getValidColumnIndex(path, table, "MovieInfo", "adult");
            indicesMap.put("adult", this.adultIndex);
            this.overviewIndex = getValidColumnIndex(path, table, "MovieInfo", "overview");
            indicesMap.put("overview", this.overviewIndex);
            this.releaseDateIndex = getValidColumnIndex(path, table, "MovieInfo", "releaseDate");
            indicesMap.put("releaseDate", this.releaseDateIndex);
            this.genreIdsIndex = getValidColumnIndex(path, table, "MovieInfo", "genreIds");
            indicesMap.put("genreIds", this.genreIdsIndex);
            this.idIndex = getValidColumnIndex(path, table, "MovieInfo", "id");
            indicesMap.put("id", this.idIndex);
            this.originalTitleIndex = getValidColumnIndex(path, table, "MovieInfo", "originalTitle");
            indicesMap.put("originalTitle", this.originalTitleIndex);
            this.originalLanguageIndex = getValidColumnIndex(path, table, "MovieInfo", "originalLanguage");
            indicesMap.put("originalLanguage", this.originalLanguageIndex);
            this.titleIndex = getValidColumnIndex(path, table, "MovieInfo", "title");
            indicesMap.put("title", this.titleIndex);
            this.backdropPathIndex = getValidColumnIndex(path, table, "MovieInfo", "backdropPath");
            indicesMap.put("backdropPath", this.backdropPathIndex);
            this.popularityIndex = getValidColumnIndex(path, table, "MovieInfo", "popularity");
            indicesMap.put("popularity", this.popularityIndex);
            this.voteCountIndex = getValidColumnIndex(path, table, "MovieInfo", "voteCount");
            indicesMap.put("voteCount", this.voteCountIndex);
            this.videoIndex = getValidColumnIndex(path, table, "MovieInfo", "video");
            indicesMap.put("video", this.videoIndex);
            this.voteAverageIndex = getValidColumnIndex(path, table, "MovieInfo", "voteAverage");
            indicesMap.put("voteAverage", this.voteAverageIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final MovieInfoColumnInfo otherInfo = (MovieInfoColumnInfo) other;
            this.posterPathIndex = otherInfo.posterPathIndex;
            this.adultIndex = otherInfo.adultIndex;
            this.overviewIndex = otherInfo.overviewIndex;
            this.releaseDateIndex = otherInfo.releaseDateIndex;
            this.genreIdsIndex = otherInfo.genreIdsIndex;
            this.idIndex = otherInfo.idIndex;
            this.originalTitleIndex = otherInfo.originalTitleIndex;
            this.originalLanguageIndex = otherInfo.originalLanguageIndex;
            this.titleIndex = otherInfo.titleIndex;
            this.backdropPathIndex = otherInfo.backdropPathIndex;
            this.popularityIndex = otherInfo.popularityIndex;
            this.voteCountIndex = otherInfo.voteCountIndex;
            this.videoIndex = otherInfo.videoIndex;
            this.voteAverageIndex = otherInfo.voteAverageIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final MovieInfoColumnInfo clone() {
            return (MovieInfoColumnInfo) super.clone();
        }

    }
    private MovieInfoColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.MovieInfo> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("posterPath");
        fieldNames.add("adult");
        fieldNames.add("overview");
        fieldNames.add("releaseDate");
        fieldNames.add("genreIds");
        fieldNames.add("id");
        fieldNames.add("originalTitle");
        fieldNames.add("originalLanguage");
        fieldNames.add("title");
        fieldNames.add("backdropPath");
        fieldNames.add("popularity");
        fieldNames.add("voteCount");
        fieldNames.add("video");
        fieldNames.add("voteAverage");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MovieInfoRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MovieInfoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.MovieInfo>(com.example.bajob.movieshatch.Pojo.MovieInfo.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
    public String realmGet$genreIds() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genreIdsIndex);
    }

    public void realmSet$genreIds(String value) {
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
                row.getTable().setNull(columnInfo.genreIdsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.genreIdsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genreIdsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genreIdsIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("MovieInfo")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("MovieInfo");
            realmObjectSchema.add(new Property("posterPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("adult", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("overview", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("releaseDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("genreIds", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originalTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originalLanguage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("backdropPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popularity", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voteCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("video", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voteAverage", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("MovieInfo");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_MovieInfo")) {
            Table table = sharedRealm.getTable("class_MovieInfo");
            table.addColumn(RealmFieldType.STRING, "posterPath", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "adult", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "overview", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "releaseDate", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "genreIds", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originalTitle", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originalLanguage", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "title", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "backdropPath", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "popularity", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "voteCount", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "video", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "voteAverage", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_MovieInfo");
    }

    public static MovieInfoColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_MovieInfo")) {
            Table table = sharedRealm.getTable("class_MovieInfo");
            final long columnCount = table.getColumnCount();
            if (columnCount != 14) {
                if (columnCount < 14) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 14 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 14 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 14 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final MovieInfoColumnInfo columnInfo = new MovieInfoColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.idIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
                }
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
            if (!columnTypes.containsKey("adult")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'adult' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("adult") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'adult' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.adultIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'adult' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'adult' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("releaseDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'releaseDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("releaseDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'releaseDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.releaseDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'releaseDate' is required. Either set @Required to field 'releaseDate' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("genreIds")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'genreIds' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("genreIds") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'genreIds' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.genreIdsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'genreIds' is required. Either set @Required to field 'genreIds' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("originalTitle")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originalTitle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("originalTitle") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originalTitle' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.originalTitleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originalTitle' is required. Either set @Required to field 'originalTitle' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("title")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("title") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'title' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.titleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("popularity")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popularity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popularity") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'popularity' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popularityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'popularity' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'popularity' or migrate using RealmObjectSchema.setNullable().");
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
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MovieInfo' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_MovieInfo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.MovieInfo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bajob.movieshatch.Pojo.MovieInfo obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieInfo.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MovieInfoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.MovieInfoRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.MovieInfo.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MovieInfoRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.MovieInfo.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("posterPath")) {
            if (json.isNull("posterPath")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$posterPath(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$posterPath((String) json.getString("posterPath"));
            }
        }
        if (json.has("adult")) {
            if (json.isNull("adult")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$adult(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$adult((boolean) json.getBoolean("adult"));
            }
        }
        if (json.has("overview")) {
            if (json.isNull("overview")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$overview(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$overview((String) json.getString("overview"));
            }
        }
        if (json.has("releaseDate")) {
            if (json.isNull("releaseDate")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$releaseDate(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$releaseDate((String) json.getString("releaseDate"));
            }
        }
        if (json.has("genreIds")) {
            if (json.isNull("genreIds")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$genreIds(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$genreIds((String) json.getString("genreIds"));
            }
        }
        if (json.has("originalTitle")) {
            if (json.isNull("originalTitle")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$originalTitle(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$originalTitle((String) json.getString("originalTitle"));
            }
        }
        if (json.has("originalLanguage")) {
            if (json.isNull("originalLanguage")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$originalLanguage(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$originalLanguage((String) json.getString("originalLanguage"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("backdropPath")) {
            if (json.isNull("backdropPath")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$backdropPath(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$backdropPath((String) json.getString("backdropPath"));
            }
        }
        if (json.has("popularity")) {
            if (json.isNull("popularity")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$popularity(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$popularity((double) json.getDouble("popularity"));
            }
        }
        if (json.has("voteCount")) {
            if (json.isNull("voteCount")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$voteCount(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$voteCount((int) json.getInt("voteCount"));
            }
        }
        if (json.has("video")) {
            if (json.isNull("video")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$video(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$video((boolean) json.getBoolean("video"));
            }
        }
        if (json.has("voteAverage")) {
            if (json.isNull("voteAverage")) {
                ((MovieInfoRealmProxyInterface) obj).realmSet$voteAverage(null);
            } else {
                ((MovieInfoRealmProxyInterface) obj).realmSet$voteAverage((double) json.getDouble("voteAverage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.MovieInfo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.bajob.movieshatch.Pojo.MovieInfo obj = new com.example.bajob.movieshatch.Pojo.MovieInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("posterPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$posterPath(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$posterPath((String) reader.nextString());
                }
            } else if (name.equals("adult")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$adult(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$adult((boolean) reader.nextBoolean());
                }
            } else if (name.equals("overview")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$overview(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$overview((String) reader.nextString());
                }
            } else if (name.equals("releaseDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$releaseDate(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$releaseDate((String) reader.nextString());
                }
            } else if (name.equals("genreIds")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$genreIds(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$genreIds((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("originalTitle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$originalTitle(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$originalTitle((String) reader.nextString());
                }
            } else if (name.equals("originalLanguage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$originalLanguage(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$originalLanguage((String) reader.nextString());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("backdropPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$backdropPath(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$backdropPath((String) reader.nextString());
                }
            } else if (name.equals("popularity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$popularity(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$popularity((double) reader.nextDouble());
                }
            } else if (name.equals("voteCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$voteCount(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$voteCount((int) reader.nextInt());
                }
            } else if (name.equals("video")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$video(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$video((boolean) reader.nextBoolean());
                }
            } else if (name.equals("voteAverage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieInfoRealmProxyInterface) obj).realmSet$voteAverage(null);
                } else {
                    ((MovieInfoRealmProxyInterface) obj).realmSet$voteAverage((double) reader.nextDouble());
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

    public static com.example.bajob.movieshatch.Pojo.MovieInfo copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.MovieInfo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.MovieInfo) cachedRealmObject;
        } else {
            com.example.bajob.movieshatch.Pojo.MovieInfo realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((MovieInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieInfo.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MovieInfoRealmProxy();
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

    public static com.example.bajob.movieshatch.Pojo.MovieInfo copy(Realm realm, com.example.bajob.movieshatch.Pojo.MovieInfo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.MovieInfo) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.MovieInfo realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.MovieInfo.class, ((MovieInfoRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$posterPath(((MovieInfoRealmProxyInterface) newObject).realmGet$posterPath());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$adult(((MovieInfoRealmProxyInterface) newObject).realmGet$adult());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$overview(((MovieInfoRealmProxyInterface) newObject).realmGet$overview());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$releaseDate(((MovieInfoRealmProxyInterface) newObject).realmGet$releaseDate());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$genreIds(((MovieInfoRealmProxyInterface) newObject).realmGet$genreIds());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$originalTitle(((MovieInfoRealmProxyInterface) newObject).realmGet$originalTitle());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$originalLanguage(((MovieInfoRealmProxyInterface) newObject).realmGet$originalLanguage());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$title(((MovieInfoRealmProxyInterface) newObject).realmGet$title());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$backdropPath(((MovieInfoRealmProxyInterface) newObject).realmGet$backdropPath());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$popularity(((MovieInfoRealmProxyInterface) newObject).realmGet$popularity());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$voteCount(((MovieInfoRealmProxyInterface) newObject).realmGet$voteCount());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$video(((MovieInfoRealmProxyInterface) newObject).realmGet$video());
            ((MovieInfoRealmProxyInterface) realmObject).realmSet$voteAverage(((MovieInfoRealmProxyInterface) newObject).realmGet$voteAverage());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.MovieInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        MovieInfoColumnInfo columnInfo = (MovieInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MovieInfoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieInfoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MovieInfoRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$posterPath = ((MovieInfoRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        }
        Boolean realmGet$adult = ((MovieInfoRealmProxyInterface)object).realmGet$adult();
        if (realmGet$adult != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
        }
        String realmGet$overview = ((MovieInfoRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        }
        String realmGet$releaseDate = ((MovieInfoRealmProxyInterface)object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
        }
        String realmGet$genreIds = ((MovieInfoRealmProxyInterface)object).realmGet$genreIds();
        if (realmGet$genreIds != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, realmGet$genreIds, false);
        }
        String realmGet$originalTitle = ((MovieInfoRealmProxyInterface)object).realmGet$originalTitle();
        if (realmGet$originalTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
        }
        String realmGet$originalLanguage = ((MovieInfoRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        }
        String realmGet$title = ((MovieInfoRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$backdropPath = ((MovieInfoRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        }
        Double realmGet$popularity = ((MovieInfoRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        }
        Number realmGet$voteCount = ((MovieInfoRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        }
        Boolean realmGet$video = ((MovieInfoRealmProxyInterface)object).realmGet$video();
        if (realmGet$video != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
        }
        Double realmGet$voteAverage = ((MovieInfoRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        MovieInfoColumnInfo columnInfo = (MovieInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.MovieInfo object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.MovieInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MovieInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieInfoRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MovieInfoRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$posterPath = ((MovieInfoRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                }
                Boolean realmGet$adult = ((MovieInfoRealmProxyInterface)object).realmGet$adult();
                if (realmGet$adult != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
                }
                String realmGet$overview = ((MovieInfoRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                }
                String realmGet$releaseDate = ((MovieInfoRealmProxyInterface)object).realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
                }
                String realmGet$genreIds = ((MovieInfoRealmProxyInterface)object).realmGet$genreIds();
                if (realmGet$genreIds != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, realmGet$genreIds, false);
                }
                String realmGet$originalTitle = ((MovieInfoRealmProxyInterface)object).realmGet$originalTitle();
                if (realmGet$originalTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
                }
                String realmGet$originalLanguage = ((MovieInfoRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                }
                String realmGet$title = ((MovieInfoRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$backdropPath = ((MovieInfoRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                }
                Double realmGet$popularity = ((MovieInfoRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                }
                Number realmGet$voteCount = ((MovieInfoRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                }
                Boolean realmGet$video = ((MovieInfoRealmProxyInterface)object).realmGet$video();
                if (realmGet$video != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
                }
                Double realmGet$voteAverage = ((MovieInfoRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.MovieInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        MovieInfoColumnInfo columnInfo = (MovieInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MovieInfoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieInfoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MovieInfoRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$posterPath = ((MovieInfoRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
        }
        Boolean realmGet$adult = ((MovieInfoRealmProxyInterface)object).realmGet$adult();
        if (realmGet$adult != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.adultIndex, rowIndex, false);
        }
        String realmGet$overview = ((MovieInfoRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
        }
        String realmGet$releaseDate = ((MovieInfoRealmProxyInterface)object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, false);
        }
        String realmGet$genreIds = ((MovieInfoRealmProxyInterface)object).realmGet$genreIds();
        if (realmGet$genreIds != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, realmGet$genreIds, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, false);
        }
        String realmGet$originalTitle = ((MovieInfoRealmProxyInterface)object).realmGet$originalTitle();
        if (realmGet$originalTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, false);
        }
        String realmGet$originalLanguage = ((MovieInfoRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
        }
        String realmGet$title = ((MovieInfoRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$backdropPath = ((MovieInfoRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
        }
        Double realmGet$popularity = ((MovieInfoRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
        }
        Number realmGet$voteCount = ((MovieInfoRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
        }
        Boolean realmGet$video = ((MovieInfoRealmProxyInterface)object).realmGet$video();
        if (realmGet$video != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoIndex, rowIndex, false);
        }
        Double realmGet$voteAverage = ((MovieInfoRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        MovieInfoColumnInfo columnInfo = (MovieInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.MovieInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.MovieInfo object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.MovieInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MovieInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieInfoRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MovieInfoRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$posterPath = ((MovieInfoRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
                }
                Boolean realmGet$adult = ((MovieInfoRealmProxyInterface)object).realmGet$adult();
                if (realmGet$adult != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.adultIndex, rowIndex, false);
                }
                String realmGet$overview = ((MovieInfoRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
                }
                String realmGet$releaseDate = ((MovieInfoRealmProxyInterface)object).realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, false);
                }
                String realmGet$genreIds = ((MovieInfoRealmProxyInterface)object).realmGet$genreIds();
                if (realmGet$genreIds != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, realmGet$genreIds, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, false);
                }
                String realmGet$originalTitle = ((MovieInfoRealmProxyInterface)object).realmGet$originalTitle();
                if (realmGet$originalTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, false);
                }
                String realmGet$originalLanguage = ((MovieInfoRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
                }
                String realmGet$title = ((MovieInfoRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$backdropPath = ((MovieInfoRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
                }
                Double realmGet$popularity = ((MovieInfoRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
                }
                Number realmGet$voteCount = ((MovieInfoRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
                }
                Boolean realmGet$video = ((MovieInfoRealmProxyInterface)object).realmGet$video();
                if (realmGet$video != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.videoIndex, rowIndex, false);
                }
                Double realmGet$voteAverage = ((MovieInfoRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.MovieInfo createDetachedCopy(com.example.bajob.movieshatch.Pojo.MovieInfo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.MovieInfo unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.MovieInfo)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.MovieInfo)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.MovieInfo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$posterPath(((MovieInfoRealmProxyInterface) realmObject).realmGet$posterPath());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$adult(((MovieInfoRealmProxyInterface) realmObject).realmGet$adult());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$overview(((MovieInfoRealmProxyInterface) realmObject).realmGet$overview());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$releaseDate(((MovieInfoRealmProxyInterface) realmObject).realmGet$releaseDate());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$genreIds(((MovieInfoRealmProxyInterface) realmObject).realmGet$genreIds());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$id(((MovieInfoRealmProxyInterface) realmObject).realmGet$id());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$originalTitle(((MovieInfoRealmProxyInterface) realmObject).realmGet$originalTitle());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$originalLanguage(((MovieInfoRealmProxyInterface) realmObject).realmGet$originalLanguage());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$title(((MovieInfoRealmProxyInterface) realmObject).realmGet$title());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$backdropPath(((MovieInfoRealmProxyInterface) realmObject).realmGet$backdropPath());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$popularity(((MovieInfoRealmProxyInterface) realmObject).realmGet$popularity());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$voteCount(((MovieInfoRealmProxyInterface) realmObject).realmGet$voteCount());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$video(((MovieInfoRealmProxyInterface) realmObject).realmGet$video());
        ((MovieInfoRealmProxyInterface) unmanagedObject).realmSet$voteAverage(((MovieInfoRealmProxyInterface) realmObject).realmGet$voteAverage());
        return unmanagedObject;
    }

    static com.example.bajob.movieshatch.Pojo.MovieInfo update(Realm realm, com.example.bajob.movieshatch.Pojo.MovieInfo realmObject, com.example.bajob.movieshatch.Pojo.MovieInfo newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$posterPath(((MovieInfoRealmProxyInterface) newObject).realmGet$posterPath());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$adult(((MovieInfoRealmProxyInterface) newObject).realmGet$adult());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$overview(((MovieInfoRealmProxyInterface) newObject).realmGet$overview());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$releaseDate(((MovieInfoRealmProxyInterface) newObject).realmGet$releaseDate());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$genreIds(((MovieInfoRealmProxyInterface) newObject).realmGet$genreIds());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$originalTitle(((MovieInfoRealmProxyInterface) newObject).realmGet$originalTitle());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$originalLanguage(((MovieInfoRealmProxyInterface) newObject).realmGet$originalLanguage());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$title(((MovieInfoRealmProxyInterface) newObject).realmGet$title());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$backdropPath(((MovieInfoRealmProxyInterface) newObject).realmGet$backdropPath());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$popularity(((MovieInfoRealmProxyInterface) newObject).realmGet$popularity());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$voteCount(((MovieInfoRealmProxyInterface) newObject).realmGet$voteCount());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$video(((MovieInfoRealmProxyInterface) newObject).realmGet$video());
        ((MovieInfoRealmProxyInterface) realmObject).realmSet$voteAverage(((MovieInfoRealmProxyInterface) newObject).realmGet$voteAverage());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MovieInfo = [");
        stringBuilder.append("{posterPath:");
        stringBuilder.append(realmGet$posterPath() != null ? realmGet$posterPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{adult:");
        stringBuilder.append(realmGet$adult() != null ? realmGet$adult() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{overview:");
        stringBuilder.append(realmGet$overview() != null ? realmGet$overview() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{releaseDate:");
        stringBuilder.append(realmGet$releaseDate() != null ? realmGet$releaseDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{genreIds:");
        stringBuilder.append(realmGet$genreIds() != null ? realmGet$genreIds() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalTitle:");
        stringBuilder.append(realmGet$originalTitle() != null ? realmGet$originalTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalLanguage:");
        stringBuilder.append(realmGet$originalLanguage() != null ? realmGet$originalLanguage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{backdropPath:");
        stringBuilder.append(realmGet$backdropPath() != null ? realmGet$backdropPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popularity:");
        stringBuilder.append(realmGet$popularity() != null ? realmGet$popularity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{voteCount:");
        stringBuilder.append(realmGet$voteCount() != null ? realmGet$voteCount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{video:");
        stringBuilder.append(realmGet$video() != null ? realmGet$video() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{voteAverage:");
        stringBuilder.append(realmGet$voteAverage() != null ? realmGet$voteAverage() : "null");
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
        MovieInfoRealmProxy aMovieInfo = (MovieInfoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMovieInfo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovieInfo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMovieInfo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
