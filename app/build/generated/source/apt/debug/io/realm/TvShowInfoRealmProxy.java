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

public class TvShowInfoRealmProxy extends com.example.bajob.movieshatch.Pojo.TvShowInfo
    implements RealmObjectProxy, TvShowInfoRealmProxyInterface {

    static final class TvShowInfoColumnInfo extends ColumnInfo
        implements Cloneable {

        public long posterPathIndex;
        public long popularityIndex;
        public long idIndex;
        public long backdropPathIndex;
        public long voteAverageIndex;
        public long overviewIndex;
        public long firstAirDateIndex;
        public long originCountryIndex;
        public long genreIdsIndex;
        public long originalLanguageIndex;
        public long voteCountIndex;
        public long nameIndex;
        public long originalNameIndex;

        TvShowInfoColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(13);
            this.posterPathIndex = getValidColumnIndex(path, table, "TvShowInfo", "posterPath");
            indicesMap.put("posterPath", this.posterPathIndex);
            this.popularityIndex = getValidColumnIndex(path, table, "TvShowInfo", "popularity");
            indicesMap.put("popularity", this.popularityIndex);
            this.idIndex = getValidColumnIndex(path, table, "TvShowInfo", "id");
            indicesMap.put("id", this.idIndex);
            this.backdropPathIndex = getValidColumnIndex(path, table, "TvShowInfo", "backdropPath");
            indicesMap.put("backdropPath", this.backdropPathIndex);
            this.voteAverageIndex = getValidColumnIndex(path, table, "TvShowInfo", "voteAverage");
            indicesMap.put("voteAverage", this.voteAverageIndex);
            this.overviewIndex = getValidColumnIndex(path, table, "TvShowInfo", "overview");
            indicesMap.put("overview", this.overviewIndex);
            this.firstAirDateIndex = getValidColumnIndex(path, table, "TvShowInfo", "firstAirDate");
            indicesMap.put("firstAirDate", this.firstAirDateIndex);
            this.originCountryIndex = getValidColumnIndex(path, table, "TvShowInfo", "originCountry");
            indicesMap.put("originCountry", this.originCountryIndex);
            this.genreIdsIndex = getValidColumnIndex(path, table, "TvShowInfo", "genreIds");
            indicesMap.put("genreIds", this.genreIdsIndex);
            this.originalLanguageIndex = getValidColumnIndex(path, table, "TvShowInfo", "originalLanguage");
            indicesMap.put("originalLanguage", this.originalLanguageIndex);
            this.voteCountIndex = getValidColumnIndex(path, table, "TvShowInfo", "voteCount");
            indicesMap.put("voteCount", this.voteCountIndex);
            this.nameIndex = getValidColumnIndex(path, table, "TvShowInfo", "name");
            indicesMap.put("name", this.nameIndex);
            this.originalNameIndex = getValidColumnIndex(path, table, "TvShowInfo", "originalName");
            indicesMap.put("originalName", this.originalNameIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final TvShowInfoColumnInfo otherInfo = (TvShowInfoColumnInfo) other;
            this.posterPathIndex = otherInfo.posterPathIndex;
            this.popularityIndex = otherInfo.popularityIndex;
            this.idIndex = otherInfo.idIndex;
            this.backdropPathIndex = otherInfo.backdropPathIndex;
            this.voteAverageIndex = otherInfo.voteAverageIndex;
            this.overviewIndex = otherInfo.overviewIndex;
            this.firstAirDateIndex = otherInfo.firstAirDateIndex;
            this.originCountryIndex = otherInfo.originCountryIndex;
            this.genreIdsIndex = otherInfo.genreIdsIndex;
            this.originalLanguageIndex = otherInfo.originalLanguageIndex;
            this.voteCountIndex = otherInfo.voteCountIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.originalNameIndex = otherInfo.originalNameIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final TvShowInfoColumnInfo clone() {
            return (TvShowInfoColumnInfo) super.clone();
        }

    }
    private TvShowInfoColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.TvShowInfo> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("posterPath");
        fieldNames.add("popularity");
        fieldNames.add("id");
        fieldNames.add("backdropPath");
        fieldNames.add("voteAverage");
        fieldNames.add("overview");
        fieldNames.add("firstAirDate");
        fieldNames.add("originCountry");
        fieldNames.add("genreIds");
        fieldNames.add("originalLanguage");
        fieldNames.add("voteCount");
        fieldNames.add("name");
        fieldNames.add("originalName");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    TvShowInfoRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TvShowInfoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.TvShowInfo>(com.example.bajob.movieshatch.Pojo.TvShowInfo.class, this);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("TvShowInfo")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("TvShowInfo");
            realmObjectSchema.add(new Property("posterPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("popularity", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("backdropPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voteAverage", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("overview", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("firstAirDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originCountry", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("genreIds", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originalLanguage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("voteCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("originalName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("TvShowInfo");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_TvShowInfo")) {
            Table table = sharedRealm.getTable("class_TvShowInfo");
            table.addColumn(RealmFieldType.STRING, "posterPath", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "popularity", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "backdropPath", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "voteAverage", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "overview", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "firstAirDate", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originCountry", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "genreIds", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originalLanguage", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "voteCount", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "originalName", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_TvShowInfo");
    }

    public static TvShowInfoColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_TvShowInfo")) {
            Table table = sharedRealm.getTable("class_TvShowInfo");
            final long columnCount = table.getColumnCount();
            if (columnCount != 13) {
                if (columnCount < 13) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 13 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 13 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 13 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final TvShowInfoColumnInfo columnInfo = new TvShowInfoColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("popularity")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popularity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("popularity") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'popularity' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.popularityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'popularity' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'popularity' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("backdropPath")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'backdropPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("backdropPath") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'backdropPath' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.backdropPathIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'backdropPath' is required. Either set @Required to field 'backdropPath' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("overview")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'overview' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("overview") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'overview' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.overviewIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'overview' is required. Either set @Required to field 'overview' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("originCountry")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originCountry' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("originCountry") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originCountry' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.originCountryIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originCountry' is required. Either set @Required to field 'originCountry' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("originalLanguage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originalLanguage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("originalLanguage") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originalLanguage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.originalLanguageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originalLanguage' is required. Either set @Required to field 'originalLanguage' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
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
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'TvShowInfo' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_TvShowInfo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.TvShowInfo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bajob.movieshatch.Pojo.TvShowInfo obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowInfo.class), false, Collections.<String> emptyList());
                    obj = new io.realm.TvShowInfoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.TvShowInfoRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TvShowInfo.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.TvShowInfoRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TvShowInfo.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("posterPath")) {
            if (json.isNull("posterPath")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$posterPath(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$posterPath((String) json.getString("posterPath"));
            }
        }
        if (json.has("popularity")) {
            if (json.isNull("popularity")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$popularity(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$popularity((double) json.getDouble("popularity"));
            }
        }
        if (json.has("backdropPath")) {
            if (json.isNull("backdropPath")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$backdropPath(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$backdropPath((String) json.getString("backdropPath"));
            }
        }
        if (json.has("voteAverage")) {
            if (json.isNull("voteAverage")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$voteAverage(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$voteAverage((double) json.getDouble("voteAverage"));
            }
        }
        if (json.has("overview")) {
            if (json.isNull("overview")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$overview(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$overview((String) json.getString("overview"));
            }
        }
        if (json.has("firstAirDate")) {
            if (json.isNull("firstAirDate")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$firstAirDate(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$firstAirDate((String) json.getString("firstAirDate"));
            }
        }
        if (json.has("originCountry")) {
            if (json.isNull("originCountry")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$originCountry(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$originCountry((String) json.getString("originCountry"));
            }
        }
        if (json.has("genreIds")) {
            if (json.isNull("genreIds")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$genreIds(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$genreIds((String) json.getString("genreIds"));
            }
        }
        if (json.has("originalLanguage")) {
            if (json.isNull("originalLanguage")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$originalLanguage(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$originalLanguage((String) json.getString("originalLanguage"));
            }
        }
        if (json.has("voteCount")) {
            if (json.isNull("voteCount")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$voteCount(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$voteCount((int) json.getInt("voteCount"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("originalName")) {
            if (json.isNull("originalName")) {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$originalName(null);
            } else {
                ((TvShowInfoRealmProxyInterface) obj).realmSet$originalName((String) json.getString("originalName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.TvShowInfo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.bajob.movieshatch.Pojo.TvShowInfo obj = new com.example.bajob.movieshatch.Pojo.TvShowInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("posterPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$posterPath(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$posterPath((String) reader.nextString());
                }
            } else if (name.equals("popularity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$popularity(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$popularity((double) reader.nextDouble());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("backdropPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$backdropPath(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$backdropPath((String) reader.nextString());
                }
            } else if (name.equals("voteAverage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$voteAverage(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$voteAverage((double) reader.nextDouble());
                }
            } else if (name.equals("overview")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$overview(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$overview((String) reader.nextString());
                }
            } else if (name.equals("firstAirDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$firstAirDate(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$firstAirDate((String) reader.nextString());
                }
            } else if (name.equals("originCountry")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$originCountry(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$originCountry((String) reader.nextString());
                }
            } else if (name.equals("genreIds")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$genreIds(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$genreIds((String) reader.nextString());
                }
            } else if (name.equals("originalLanguage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$originalLanguage(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$originalLanguage((String) reader.nextString());
                }
            } else if (name.equals("voteCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$voteCount(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$voteCount((int) reader.nextInt());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("originalName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$originalName(null);
                } else {
                    ((TvShowInfoRealmProxyInterface) obj).realmSet$originalName((String) reader.nextString());
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

    public static com.example.bajob.movieshatch.Pojo.TvShowInfo copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowInfo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.TvShowInfo) cachedRealmObject;
        } else {
            com.example.bajob.movieshatch.Pojo.TvShowInfo realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((TvShowInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowInfo.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.TvShowInfoRealmProxy();
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

    public static com.example.bajob.movieshatch.Pojo.TvShowInfo copy(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowInfo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.TvShowInfo) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.TvShowInfo realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TvShowInfo.class, ((TvShowInfoRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$posterPath(((TvShowInfoRealmProxyInterface) newObject).realmGet$posterPath());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$popularity(((TvShowInfoRealmProxyInterface) newObject).realmGet$popularity());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$backdropPath(((TvShowInfoRealmProxyInterface) newObject).realmGet$backdropPath());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$voteAverage(((TvShowInfoRealmProxyInterface) newObject).realmGet$voteAverage());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$overview(((TvShowInfoRealmProxyInterface) newObject).realmGet$overview());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$firstAirDate(((TvShowInfoRealmProxyInterface) newObject).realmGet$firstAirDate());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$originCountry(((TvShowInfoRealmProxyInterface) newObject).realmGet$originCountry());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$genreIds(((TvShowInfoRealmProxyInterface) newObject).realmGet$genreIds());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$originalLanguage(((TvShowInfoRealmProxyInterface) newObject).realmGet$originalLanguage());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$voteCount(((TvShowInfoRealmProxyInterface) newObject).realmGet$voteCount());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$name(((TvShowInfoRealmProxyInterface) newObject).realmGet$name());
            ((TvShowInfoRealmProxyInterface) realmObject).realmSet$originalName(((TvShowInfoRealmProxyInterface) newObject).realmGet$originalName());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        TvShowInfoColumnInfo columnInfo = (TvShowInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((TvShowInfoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TvShowInfoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((TvShowInfoRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$posterPath = ((TvShowInfoRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        }
        Double realmGet$popularity = ((TvShowInfoRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        }
        String realmGet$backdropPath = ((TvShowInfoRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        }
        Double realmGet$voteAverage = ((TvShowInfoRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        }
        String realmGet$overview = ((TvShowInfoRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        }
        String realmGet$firstAirDate = ((TvShowInfoRealmProxyInterface)object).realmGet$firstAirDate();
        if (realmGet$firstAirDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, realmGet$firstAirDate, false);
        }
        String realmGet$originCountry = ((TvShowInfoRealmProxyInterface)object).realmGet$originCountry();
        if (realmGet$originCountry != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
        }
        String realmGet$genreIds = ((TvShowInfoRealmProxyInterface)object).realmGet$genreIds();
        if (realmGet$genreIds != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, realmGet$genreIds, false);
        }
        String realmGet$originalLanguage = ((TvShowInfoRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        }
        Number realmGet$voteCount = ((TvShowInfoRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        }
        String realmGet$name = ((TvShowInfoRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$originalName = ((TvShowInfoRealmProxyInterface)object).realmGet$originalName();
        if (realmGet$originalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalNameIndex, rowIndex, realmGet$originalName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        TvShowInfoColumnInfo columnInfo = (TvShowInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.TvShowInfo object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.TvShowInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((TvShowInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TvShowInfoRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((TvShowInfoRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$posterPath = ((TvShowInfoRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                }
                Double realmGet$popularity = ((TvShowInfoRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                }
                String realmGet$backdropPath = ((TvShowInfoRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                }
                Double realmGet$voteAverage = ((TvShowInfoRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                }
                String realmGet$overview = ((TvShowInfoRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                }
                String realmGet$firstAirDate = ((TvShowInfoRealmProxyInterface)object).realmGet$firstAirDate();
                if (realmGet$firstAirDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, realmGet$firstAirDate, false);
                }
                String realmGet$originCountry = ((TvShowInfoRealmProxyInterface)object).realmGet$originCountry();
                if (realmGet$originCountry != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
                }
                String realmGet$genreIds = ((TvShowInfoRealmProxyInterface)object).realmGet$genreIds();
                if (realmGet$genreIds != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, realmGet$genreIds, false);
                }
                String realmGet$originalLanguage = ((TvShowInfoRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                }
                Number realmGet$voteCount = ((TvShowInfoRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                }
                String realmGet$name = ((TvShowInfoRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$originalName = ((TvShowInfoRealmProxyInterface)object).realmGet$originalName();
                if (realmGet$originalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalNameIndex, rowIndex, realmGet$originalName, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        TvShowInfoColumnInfo columnInfo = (TvShowInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((TvShowInfoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TvShowInfoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((TvShowInfoRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$posterPath = ((TvShowInfoRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
        }
        Double realmGet$popularity = ((TvShowInfoRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
        }
        String realmGet$backdropPath = ((TvShowInfoRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
        }
        Double realmGet$voteAverage = ((TvShowInfoRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
        }
        String realmGet$overview = ((TvShowInfoRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
        }
        String realmGet$firstAirDate = ((TvShowInfoRealmProxyInterface)object).realmGet$firstAirDate();
        if (realmGet$firstAirDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, realmGet$firstAirDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, false);
        }
        String realmGet$originCountry = ((TvShowInfoRealmProxyInterface)object).realmGet$originCountry();
        if (realmGet$originCountry != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originCountryIndex, rowIndex, false);
        }
        String realmGet$genreIds = ((TvShowInfoRealmProxyInterface)object).realmGet$genreIds();
        if (realmGet$genreIds != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, realmGet$genreIds, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, false);
        }
        String realmGet$originalLanguage = ((TvShowInfoRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
        }
        Number realmGet$voteCount = ((TvShowInfoRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
        }
        String realmGet$name = ((TvShowInfoRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$originalName = ((TvShowInfoRealmProxyInterface)object).realmGet$originalName();
        if (realmGet$originalName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalNameIndex, rowIndex, realmGet$originalName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        long tableNativePtr = table.getNativeTablePointer();
        TvShowInfoColumnInfo columnInfo = (TvShowInfoColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TvShowInfo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.TvShowInfo object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.TvShowInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((TvShowInfoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TvShowInfoRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((TvShowInfoRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$posterPath = ((TvShowInfoRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
                }
                Double realmGet$popularity = ((TvShowInfoRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
                }
                String realmGet$backdropPath = ((TvShowInfoRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
                }
                Double realmGet$voteAverage = ((TvShowInfoRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
                }
                String realmGet$overview = ((TvShowInfoRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
                }
                String realmGet$firstAirDate = ((TvShowInfoRealmProxyInterface)object).realmGet$firstAirDate();
                if (realmGet$firstAirDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, realmGet$firstAirDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.firstAirDateIndex, rowIndex, false);
                }
                String realmGet$originCountry = ((TvShowInfoRealmProxyInterface)object).realmGet$originCountry();
                if (realmGet$originCountry != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originCountryIndex, rowIndex, false);
                }
                String realmGet$genreIds = ((TvShowInfoRealmProxyInterface)object).realmGet$genreIds();
                if (realmGet$genreIds != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, realmGet$genreIds, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.genreIdsIndex, rowIndex, false);
                }
                String realmGet$originalLanguage = ((TvShowInfoRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
                }
                Number realmGet$voteCount = ((TvShowInfoRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
                }
                String realmGet$name = ((TvShowInfoRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$originalName = ((TvShowInfoRealmProxyInterface)object).realmGet$originalName();
                if (realmGet$originalName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalNameIndex, rowIndex, realmGet$originalName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalNameIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.TvShowInfo createDetachedCopy(com.example.bajob.movieshatch.Pojo.TvShowInfo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.TvShowInfo unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.TvShowInfo)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.TvShowInfo)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.TvShowInfo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$posterPath(((TvShowInfoRealmProxyInterface) realmObject).realmGet$posterPath());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$popularity(((TvShowInfoRealmProxyInterface) realmObject).realmGet$popularity());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$id(((TvShowInfoRealmProxyInterface) realmObject).realmGet$id());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$backdropPath(((TvShowInfoRealmProxyInterface) realmObject).realmGet$backdropPath());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$voteAverage(((TvShowInfoRealmProxyInterface) realmObject).realmGet$voteAverage());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$overview(((TvShowInfoRealmProxyInterface) realmObject).realmGet$overview());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$firstAirDate(((TvShowInfoRealmProxyInterface) realmObject).realmGet$firstAirDate());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$originCountry(((TvShowInfoRealmProxyInterface) realmObject).realmGet$originCountry());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$genreIds(((TvShowInfoRealmProxyInterface) realmObject).realmGet$genreIds());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$originalLanguage(((TvShowInfoRealmProxyInterface) realmObject).realmGet$originalLanguage());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$voteCount(((TvShowInfoRealmProxyInterface) realmObject).realmGet$voteCount());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$name(((TvShowInfoRealmProxyInterface) realmObject).realmGet$name());
        ((TvShowInfoRealmProxyInterface) unmanagedObject).realmSet$originalName(((TvShowInfoRealmProxyInterface) realmObject).realmGet$originalName());
        return unmanagedObject;
    }

    static com.example.bajob.movieshatch.Pojo.TvShowInfo update(Realm realm, com.example.bajob.movieshatch.Pojo.TvShowInfo realmObject, com.example.bajob.movieshatch.Pojo.TvShowInfo newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$posterPath(((TvShowInfoRealmProxyInterface) newObject).realmGet$posterPath());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$popularity(((TvShowInfoRealmProxyInterface) newObject).realmGet$popularity());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$backdropPath(((TvShowInfoRealmProxyInterface) newObject).realmGet$backdropPath());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$voteAverage(((TvShowInfoRealmProxyInterface) newObject).realmGet$voteAverage());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$overview(((TvShowInfoRealmProxyInterface) newObject).realmGet$overview());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$firstAirDate(((TvShowInfoRealmProxyInterface) newObject).realmGet$firstAirDate());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$originCountry(((TvShowInfoRealmProxyInterface) newObject).realmGet$originCountry());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$genreIds(((TvShowInfoRealmProxyInterface) newObject).realmGet$genreIds());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$originalLanguage(((TvShowInfoRealmProxyInterface) newObject).realmGet$originalLanguage());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$voteCount(((TvShowInfoRealmProxyInterface) newObject).realmGet$voteCount());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$name(((TvShowInfoRealmProxyInterface) newObject).realmGet$name());
        ((TvShowInfoRealmProxyInterface) realmObject).realmSet$originalName(((TvShowInfoRealmProxyInterface) newObject).realmGet$originalName());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TvShowInfo = [");
        stringBuilder.append("{posterPath:");
        stringBuilder.append(realmGet$posterPath() != null ? realmGet$posterPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popularity:");
        stringBuilder.append(realmGet$popularity() != null ? realmGet$popularity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{backdropPath:");
        stringBuilder.append(realmGet$backdropPath() != null ? realmGet$backdropPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{voteAverage:");
        stringBuilder.append(realmGet$voteAverage() != null ? realmGet$voteAverage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{overview:");
        stringBuilder.append(realmGet$overview() != null ? realmGet$overview() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{firstAirDate:");
        stringBuilder.append(realmGet$firstAirDate() != null ? realmGet$firstAirDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originCountry:");
        stringBuilder.append(realmGet$originCountry() != null ? realmGet$originCountry() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{genreIds:");
        stringBuilder.append(realmGet$genreIds() != null ? realmGet$genreIds() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalLanguage:");
        stringBuilder.append(realmGet$originalLanguage() != null ? realmGet$originalLanguage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{voteCount:");
        stringBuilder.append(realmGet$voteCount() != null ? realmGet$voteCount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalName:");
        stringBuilder.append(realmGet$originalName() != null ? realmGet$originalName() : "null");
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
        TvShowInfoRealmProxy aTvShowInfo = (TvShowInfoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTvShowInfo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTvShowInfo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTvShowInfo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
