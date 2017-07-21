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

public class SeasonRealmProxy extends com.example.bajob.movieshatch.Pojo.Season
    implements RealmObjectProxy, SeasonRealmProxyInterface {

    static final class SeasonColumnInfo extends ColumnInfo
        implements Cloneable {

        public long airDateIndex;
        public long episodeCountIndex;
        public long idIndex;
        public long posterPathIndex;
        public long seasonNumberIndex;

        SeasonColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.airDateIndex = getValidColumnIndex(path, table, "Season", "airDate");
            indicesMap.put("airDate", this.airDateIndex);
            this.episodeCountIndex = getValidColumnIndex(path, table, "Season", "episodeCount");
            indicesMap.put("episodeCount", this.episodeCountIndex);
            this.idIndex = getValidColumnIndex(path, table, "Season", "id");
            indicesMap.put("id", this.idIndex);
            this.posterPathIndex = getValidColumnIndex(path, table, "Season", "posterPath");
            indicesMap.put("posterPath", this.posterPathIndex);
            this.seasonNumberIndex = getValidColumnIndex(path, table, "Season", "seasonNumber");
            indicesMap.put("seasonNumber", this.seasonNumberIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final SeasonColumnInfo otherInfo = (SeasonColumnInfo) other;
            this.airDateIndex = otherInfo.airDateIndex;
            this.episodeCountIndex = otherInfo.episodeCountIndex;
            this.idIndex = otherInfo.idIndex;
            this.posterPathIndex = otherInfo.posterPathIndex;
            this.seasonNumberIndex = otherInfo.seasonNumberIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final SeasonColumnInfo clone() {
            return (SeasonColumnInfo) super.clone();
        }

    }
    private SeasonColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.Season> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("airDate");
        fieldNames.add("episodeCount");
        fieldNames.add("id");
        fieldNames.add("posterPath");
        fieldNames.add("seasonNumber");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SeasonRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SeasonColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.Season>(com.example.bajob.movieshatch.Pojo.Season.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$airDate() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.airDateIndex);
    }

    public void realmSet$airDate(String value) {
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
                row.getTable().setNull(columnInfo.airDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.airDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.airDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.airDateIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$episodeCount() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.episodeCountIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.episodeCountIndex);
    }

    public void realmSet$episodeCount(Integer value) {
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
                row.getTable().setNull(columnInfo.episodeCountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.episodeCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.episodeCountIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.episodeCountIndex, value);
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
    public Integer realmGet$seasonNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.seasonNumberIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.seasonNumberIndex);
    }

    public void realmSet$seasonNumber(Integer value) {
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
                row.getTable().setNull(columnInfo.seasonNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.seasonNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.seasonNumberIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.seasonNumberIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Season")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Season");
            realmObjectSchema.add(new Property("airDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("episodeCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("posterPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("seasonNumber", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Season");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Season")) {
            Table table = sharedRealm.getTable("class_Season");
            table.addColumn(RealmFieldType.STRING, "airDate", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "episodeCount", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "posterPath", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "seasonNumber", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_Season");
    }

    public static SeasonColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Season")) {
            Table table = sharedRealm.getTable("class_Season");
            final long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final SeasonColumnInfo columnInfo = new SeasonColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.idIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
                }
            }

            if (!columnTypes.containsKey("airDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'airDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("airDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'airDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.airDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'airDate' is required. Either set @Required to field 'airDate' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("episodeCount")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'episodeCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("episodeCount") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'episodeCount' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.episodeCountIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'episodeCount' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'episodeCount' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("posterPath")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'posterPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("posterPath") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'posterPath' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.posterPathIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'posterPath' is required. Either set @Required to field 'posterPath' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("seasonNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'seasonNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("seasonNumber") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'seasonNumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.seasonNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'seasonNumber' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'seasonNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Season' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Season";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.Season createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bajob.movieshatch.Pojo.Season obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.Season.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.Season.class), false, Collections.<String> emptyList());
                    obj = new io.realm.SeasonRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.SeasonRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.Season.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.SeasonRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.Season.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("airDate")) {
            if (json.isNull("airDate")) {
                ((SeasonRealmProxyInterface) obj).realmSet$airDate(null);
            } else {
                ((SeasonRealmProxyInterface) obj).realmSet$airDate((String) json.getString("airDate"));
            }
        }
        if (json.has("episodeCount")) {
            if (json.isNull("episodeCount")) {
                ((SeasonRealmProxyInterface) obj).realmSet$episodeCount(null);
            } else {
                ((SeasonRealmProxyInterface) obj).realmSet$episodeCount((int) json.getInt("episodeCount"));
            }
        }
        if (json.has("posterPath")) {
            if (json.isNull("posterPath")) {
                ((SeasonRealmProxyInterface) obj).realmSet$posterPath(null);
            } else {
                ((SeasonRealmProxyInterface) obj).realmSet$posterPath((String) json.getString("posterPath"));
            }
        }
        if (json.has("seasonNumber")) {
            if (json.isNull("seasonNumber")) {
                ((SeasonRealmProxyInterface) obj).realmSet$seasonNumber(null);
            } else {
                ((SeasonRealmProxyInterface) obj).realmSet$seasonNumber((int) json.getInt("seasonNumber"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.Season createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.bajob.movieshatch.Pojo.Season obj = new com.example.bajob.movieshatch.Pojo.Season();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("airDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SeasonRealmProxyInterface) obj).realmSet$airDate(null);
                } else {
                    ((SeasonRealmProxyInterface) obj).realmSet$airDate((String) reader.nextString());
                }
            } else if (name.equals("episodeCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SeasonRealmProxyInterface) obj).realmSet$episodeCount(null);
                } else {
                    ((SeasonRealmProxyInterface) obj).realmSet$episodeCount((int) reader.nextInt());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SeasonRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((SeasonRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("posterPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SeasonRealmProxyInterface) obj).realmSet$posterPath(null);
                } else {
                    ((SeasonRealmProxyInterface) obj).realmSet$posterPath((String) reader.nextString());
                }
            } else if (name.equals("seasonNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SeasonRealmProxyInterface) obj).realmSet$seasonNumber(null);
                } else {
                    ((SeasonRealmProxyInterface) obj).realmSet$seasonNumber((int) reader.nextInt());
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

    public static com.example.bajob.movieshatch.Pojo.Season copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.Season object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.Season) cachedRealmObject;
        } else {
            com.example.bajob.movieshatch.Pojo.Season realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.Season.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((SeasonRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.Season.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.SeasonRealmProxy();
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

    public static com.example.bajob.movieshatch.Pojo.Season copy(Realm realm, com.example.bajob.movieshatch.Pojo.Season newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.Season) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.Season realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.Season.class, ((SeasonRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SeasonRealmProxyInterface) realmObject).realmSet$airDate(((SeasonRealmProxyInterface) newObject).realmGet$airDate());
            ((SeasonRealmProxyInterface) realmObject).realmSet$episodeCount(((SeasonRealmProxyInterface) newObject).realmGet$episodeCount());
            ((SeasonRealmProxyInterface) realmObject).realmSet$posterPath(((SeasonRealmProxyInterface) newObject).realmGet$posterPath());
            ((SeasonRealmProxyInterface) realmObject).realmSet$seasonNumber(((SeasonRealmProxyInterface) newObject).realmGet$seasonNumber());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.Season object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.Season.class);
        long tableNativePtr = table.getNativeTablePointer();
        SeasonColumnInfo columnInfo = (SeasonColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.Season.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((SeasonRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SeasonRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((SeasonRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$airDate = ((SeasonRealmProxyInterface)object).realmGet$airDate();
        if (realmGet$airDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.airDateIndex, rowIndex, realmGet$airDate, false);
        }
        Number realmGet$episodeCount = ((SeasonRealmProxyInterface)object).realmGet$episodeCount();
        if (realmGet$episodeCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.episodeCountIndex, rowIndex, realmGet$episodeCount.longValue(), false);
        }
        String realmGet$posterPath = ((SeasonRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        }
        Number realmGet$seasonNumber = ((SeasonRealmProxyInterface)object).realmGet$seasonNumber();
        if (realmGet$seasonNumber != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.seasonNumberIndex, rowIndex, realmGet$seasonNumber.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.Season.class);
        long tableNativePtr = table.getNativeTablePointer();
        SeasonColumnInfo columnInfo = (SeasonColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.Season.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.Season object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.Season) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((SeasonRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SeasonRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((SeasonRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$airDate = ((SeasonRealmProxyInterface)object).realmGet$airDate();
                if (realmGet$airDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.airDateIndex, rowIndex, realmGet$airDate, false);
                }
                Number realmGet$episodeCount = ((SeasonRealmProxyInterface)object).realmGet$episodeCount();
                if (realmGet$episodeCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.episodeCountIndex, rowIndex, realmGet$episodeCount.longValue(), false);
                }
                String realmGet$posterPath = ((SeasonRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                }
                Number realmGet$seasonNumber = ((SeasonRealmProxyInterface)object).realmGet$seasonNumber();
                if (realmGet$seasonNumber != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.seasonNumberIndex, rowIndex, realmGet$seasonNumber.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.Season object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.Season.class);
        long tableNativePtr = table.getNativeTablePointer();
        SeasonColumnInfo columnInfo = (SeasonColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.Season.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((SeasonRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SeasonRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((SeasonRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$airDate = ((SeasonRealmProxyInterface)object).realmGet$airDate();
        if (realmGet$airDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.airDateIndex, rowIndex, realmGet$airDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.airDateIndex, rowIndex, false);
        }
        Number realmGet$episodeCount = ((SeasonRealmProxyInterface)object).realmGet$episodeCount();
        if (realmGet$episodeCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.episodeCountIndex, rowIndex, realmGet$episodeCount.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.episodeCountIndex, rowIndex, false);
        }
        String realmGet$posterPath = ((SeasonRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
        }
        Number realmGet$seasonNumber = ((SeasonRealmProxyInterface)object).realmGet$seasonNumber();
        if (realmGet$seasonNumber != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.seasonNumberIndex, rowIndex, realmGet$seasonNumber.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.seasonNumberIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.Season.class);
        long tableNativePtr = table.getNativeTablePointer();
        SeasonColumnInfo columnInfo = (SeasonColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.Season.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.Season object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.Season) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((SeasonRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SeasonRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((SeasonRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$airDate = ((SeasonRealmProxyInterface)object).realmGet$airDate();
                if (realmGet$airDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.airDateIndex, rowIndex, realmGet$airDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.airDateIndex, rowIndex, false);
                }
                Number realmGet$episodeCount = ((SeasonRealmProxyInterface)object).realmGet$episodeCount();
                if (realmGet$episodeCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.episodeCountIndex, rowIndex, realmGet$episodeCount.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.episodeCountIndex, rowIndex, false);
                }
                String realmGet$posterPath = ((SeasonRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
                }
                Number realmGet$seasonNumber = ((SeasonRealmProxyInterface)object).realmGet$seasonNumber();
                if (realmGet$seasonNumber != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.seasonNumberIndex, rowIndex, realmGet$seasonNumber.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.seasonNumberIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.Season createDetachedCopy(com.example.bajob.movieshatch.Pojo.Season realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.Season unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.Season)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.Season)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.Season();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((SeasonRealmProxyInterface) unmanagedObject).realmSet$airDate(((SeasonRealmProxyInterface) realmObject).realmGet$airDate());
        ((SeasonRealmProxyInterface) unmanagedObject).realmSet$episodeCount(((SeasonRealmProxyInterface) realmObject).realmGet$episodeCount());
        ((SeasonRealmProxyInterface) unmanagedObject).realmSet$id(((SeasonRealmProxyInterface) realmObject).realmGet$id());
        ((SeasonRealmProxyInterface) unmanagedObject).realmSet$posterPath(((SeasonRealmProxyInterface) realmObject).realmGet$posterPath());
        ((SeasonRealmProxyInterface) unmanagedObject).realmSet$seasonNumber(((SeasonRealmProxyInterface) realmObject).realmGet$seasonNumber());
        return unmanagedObject;
    }

    static com.example.bajob.movieshatch.Pojo.Season update(Realm realm, com.example.bajob.movieshatch.Pojo.Season realmObject, com.example.bajob.movieshatch.Pojo.Season newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((SeasonRealmProxyInterface) realmObject).realmSet$airDate(((SeasonRealmProxyInterface) newObject).realmGet$airDate());
        ((SeasonRealmProxyInterface) realmObject).realmSet$episodeCount(((SeasonRealmProxyInterface) newObject).realmGet$episodeCount());
        ((SeasonRealmProxyInterface) realmObject).realmSet$posterPath(((SeasonRealmProxyInterface) newObject).realmGet$posterPath());
        ((SeasonRealmProxyInterface) realmObject).realmSet$seasonNumber(((SeasonRealmProxyInterface) newObject).realmGet$seasonNumber());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Season = [");
        stringBuilder.append("{airDate:");
        stringBuilder.append(realmGet$airDate() != null ? realmGet$airDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{episodeCount:");
        stringBuilder.append(realmGet$episodeCount() != null ? realmGet$episodeCount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{posterPath:");
        stringBuilder.append(realmGet$posterPath() != null ? realmGet$posterPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{seasonNumber:");
        stringBuilder.append(realmGet$seasonNumber() != null ? realmGet$seasonNumber() : "null");
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
        SeasonRealmProxy aSeason = (SeasonRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSeason.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSeason.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSeason.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
