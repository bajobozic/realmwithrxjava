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

public class CreatedByRealmProxy extends com.example.bajob.movieshatch.Pojo.CreatedBy
    implements RealmObjectProxy, CreatedByRealmProxyInterface {

    static final class CreatedByColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long nameIndex;
        public long profilePathIndex;

        CreatedByColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(3);
            this.idIndex = getValidColumnIndex(path, table, "CreatedBy", "id");
            indicesMap.put("id", this.idIndex);
            this.nameIndex = getValidColumnIndex(path, table, "CreatedBy", "name");
            indicesMap.put("name", this.nameIndex);
            this.profilePathIndex = getValidColumnIndex(path, table, "CreatedBy", "profilePath");
            indicesMap.put("profilePath", this.profilePathIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CreatedByColumnInfo otherInfo = (CreatedByColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.profilePathIndex = otherInfo.profilePathIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CreatedByColumnInfo clone() {
            return (CreatedByColumnInfo) super.clone();
        }

    }
    private CreatedByColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.CreatedBy> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("profilePath");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CreatedByRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CreatedByColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.CreatedBy>(com.example.bajob.movieshatch.Pojo.CreatedBy.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
    public String realmGet$profilePath() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.profilePathIndex);
    }

    public void realmSet$profilePath(String value) {
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
                row.getTable().setNull(columnInfo.profilePathIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.profilePathIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.profilePathIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.profilePathIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CreatedBy")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CreatedBy");
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("profilePath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("CreatedBy");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CreatedBy")) {
            Table table = sharedRealm.getTable("class_CreatedBy");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "profilePath", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_CreatedBy");
    }

    public static CreatedByColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CreatedBy")) {
            Table table = sharedRealm.getTable("class_CreatedBy");
            final long columnCount = table.getColumnCount();
            if (columnCount != 3) {
                if (columnCount < 3) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CreatedByColumnInfo columnInfo = new CreatedByColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.idIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
                }
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
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("profilePath")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'profilePath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("profilePath") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'profilePath' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.profilePathIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'profilePath' is required. Either set @Required to field 'profilePath' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CreatedBy' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CreatedBy";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.CreatedBy createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bajob.movieshatch.Pojo.CreatedBy obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.CreatedBy.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CreatedByRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.CreatedByRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.CreatedBy.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CreatedByRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.CreatedBy.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((CreatedByRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((CreatedByRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("profilePath")) {
            if (json.isNull("profilePath")) {
                ((CreatedByRealmProxyInterface) obj).realmSet$profilePath(null);
            } else {
                ((CreatedByRealmProxyInterface) obj).realmSet$profilePath((String) json.getString("profilePath"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.CreatedBy createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.bajob.movieshatch.Pojo.CreatedBy obj = new com.example.bajob.movieshatch.Pojo.CreatedBy();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CreatedByRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((CreatedByRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CreatedByRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((CreatedByRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("profilePath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CreatedByRealmProxyInterface) obj).realmSet$profilePath(null);
                } else {
                    ((CreatedByRealmProxyInterface) obj).realmSet$profilePath((String) reader.nextString());
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

    public static com.example.bajob.movieshatch.Pojo.CreatedBy copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.CreatedBy object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.CreatedBy) cachedRealmObject;
        } else {
            com.example.bajob.movieshatch.Pojo.CreatedBy realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((CreatedByRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.CreatedBy.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CreatedByRealmProxy();
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

    public static com.example.bajob.movieshatch.Pojo.CreatedBy copy(Realm realm, com.example.bajob.movieshatch.Pojo.CreatedBy newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.CreatedBy) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.CreatedBy realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.CreatedBy.class, ((CreatedByRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CreatedByRealmProxyInterface) realmObject).realmSet$name(((CreatedByRealmProxyInterface) newObject).realmGet$name());
            ((CreatedByRealmProxyInterface) realmObject).realmSet$profilePath(((CreatedByRealmProxyInterface) newObject).realmGet$profilePath());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.CreatedBy object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        long tableNativePtr = table.getNativeTablePointer();
        CreatedByColumnInfo columnInfo = (CreatedByColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CreatedByRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CreatedByRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CreatedByRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((CreatedByRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$profilePath = ((CreatedByRealmProxyInterface)object).realmGet$profilePath();
        if (realmGet$profilePath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.profilePathIndex, rowIndex, realmGet$profilePath, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        long tableNativePtr = table.getNativeTablePointer();
        CreatedByColumnInfo columnInfo = (CreatedByColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.CreatedBy object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.CreatedBy) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CreatedByRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CreatedByRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CreatedByRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((CreatedByRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$profilePath = ((CreatedByRealmProxyInterface)object).realmGet$profilePath();
                if (realmGet$profilePath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.profilePathIndex, rowIndex, realmGet$profilePath, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.CreatedBy object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        long tableNativePtr = table.getNativeTablePointer();
        CreatedByColumnInfo columnInfo = (CreatedByColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((CreatedByRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CreatedByRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((CreatedByRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((CreatedByRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$profilePath = ((CreatedByRealmProxyInterface)object).realmGet$profilePath();
        if (realmGet$profilePath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.profilePathIndex, rowIndex, realmGet$profilePath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.profilePathIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        long tableNativePtr = table.getNativeTablePointer();
        CreatedByColumnInfo columnInfo = (CreatedByColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.CreatedBy.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.CreatedBy object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.CreatedBy) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((CreatedByRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CreatedByRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((CreatedByRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((CreatedByRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$profilePath = ((CreatedByRealmProxyInterface)object).realmGet$profilePath();
                if (realmGet$profilePath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.profilePathIndex, rowIndex, realmGet$profilePath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.profilePathIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.CreatedBy createDetachedCopy(com.example.bajob.movieshatch.Pojo.CreatedBy realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.CreatedBy unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.CreatedBy)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.CreatedBy)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.CreatedBy();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((CreatedByRealmProxyInterface) unmanagedObject).realmSet$id(((CreatedByRealmProxyInterface) realmObject).realmGet$id());
        ((CreatedByRealmProxyInterface) unmanagedObject).realmSet$name(((CreatedByRealmProxyInterface) realmObject).realmGet$name());
        ((CreatedByRealmProxyInterface) unmanagedObject).realmSet$profilePath(((CreatedByRealmProxyInterface) realmObject).realmGet$profilePath());
        return unmanagedObject;
    }

    static com.example.bajob.movieshatch.Pojo.CreatedBy update(Realm realm, com.example.bajob.movieshatch.Pojo.CreatedBy realmObject, com.example.bajob.movieshatch.Pojo.CreatedBy newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CreatedByRealmProxyInterface) realmObject).realmSet$name(((CreatedByRealmProxyInterface) newObject).realmGet$name());
        ((CreatedByRealmProxyInterface) realmObject).realmSet$profilePath(((CreatedByRealmProxyInterface) newObject).realmGet$profilePath());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CreatedBy = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profilePath:");
        stringBuilder.append(realmGet$profilePath() != null ? realmGet$profilePath() : "null");
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
        CreatedByRealmProxy aCreatedBy = (CreatedByRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCreatedBy.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCreatedBy.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCreatedBy.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
