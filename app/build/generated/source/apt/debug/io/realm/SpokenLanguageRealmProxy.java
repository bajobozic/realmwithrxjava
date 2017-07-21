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

public class SpokenLanguageRealmProxy extends com.example.bajob.movieshatch.Pojo.SpokenLanguage
    implements RealmObjectProxy, SpokenLanguageRealmProxyInterface {

    static final class SpokenLanguageColumnInfo extends ColumnInfo
        implements Cloneable {

        public long iso6391Index;
        public long nameIndex;

        SpokenLanguageColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.iso6391Index = getValidColumnIndex(path, table, "SpokenLanguage", "iso6391");
            indicesMap.put("iso6391", this.iso6391Index);
            this.nameIndex = getValidColumnIndex(path, table, "SpokenLanguage", "name");
            indicesMap.put("name", this.nameIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final SpokenLanguageColumnInfo otherInfo = (SpokenLanguageColumnInfo) other;
            this.iso6391Index = otherInfo.iso6391Index;
            this.nameIndex = otherInfo.nameIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final SpokenLanguageColumnInfo clone() {
            return (SpokenLanguageColumnInfo) super.clone();
        }

    }
    private SpokenLanguageColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.SpokenLanguage> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("iso6391");
        fieldNames.add("name");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SpokenLanguageRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SpokenLanguageColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.SpokenLanguage>(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$iso6391() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iso6391Index);
    }

    public void realmSet$iso6391(String value) {
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
                row.getTable().setNull(columnInfo.iso6391Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iso6391Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iso6391Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iso6391Index, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("SpokenLanguage")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("SpokenLanguage");
            realmObjectSchema.add(new Property("iso6391", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("SpokenLanguage");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_SpokenLanguage")) {
            Table table = sharedRealm.getTable("class_SpokenLanguage");
            table.addColumn(RealmFieldType.STRING, "iso6391", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_SpokenLanguage");
    }

    public static SpokenLanguageColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_SpokenLanguage")) {
            Table table = sharedRealm.getTable("class_SpokenLanguage");
            final long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final SpokenLanguageColumnInfo columnInfo = new SpokenLanguageColumnInfo(sharedRealm.getPath(), table);

            if (table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
            }

            if (!columnTypes.containsKey("iso6391")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iso6391' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iso6391") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iso6391' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iso6391Index)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iso6391' is required. Either set @Required to field 'iso6391' or migrate using RealmObjectSchema.setNullable().");
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
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SpokenLanguage' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_SpokenLanguage";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.SpokenLanguage createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bajob.movieshatch.Pojo.SpokenLanguage obj = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class, true, excludeFields);
        if (json.has("iso6391")) {
            if (json.isNull("iso6391")) {
                ((SpokenLanguageRealmProxyInterface) obj).realmSet$iso6391(null);
            } else {
                ((SpokenLanguageRealmProxyInterface) obj).realmSet$iso6391((String) json.getString("iso6391"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((SpokenLanguageRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((SpokenLanguageRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.SpokenLanguage createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.example.bajob.movieshatch.Pojo.SpokenLanguage obj = new com.example.bajob.movieshatch.Pojo.SpokenLanguage();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("iso6391")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SpokenLanguageRealmProxyInterface) obj).realmSet$iso6391(null);
                } else {
                    ((SpokenLanguageRealmProxyInterface) obj).realmSet$iso6391((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SpokenLanguageRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((SpokenLanguageRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.bajob.movieshatch.Pojo.SpokenLanguage copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.SpokenLanguage object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.SpokenLanguage) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.example.bajob.movieshatch.Pojo.SpokenLanguage copy(Realm realm, com.example.bajob.movieshatch.Pojo.SpokenLanguage newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.SpokenLanguage) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.SpokenLanguage realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SpokenLanguageRealmProxyInterface) realmObject).realmSet$iso6391(((SpokenLanguageRealmProxyInterface) newObject).realmGet$iso6391());
            ((SpokenLanguageRealmProxyInterface) realmObject).realmSet$name(((SpokenLanguageRealmProxyInterface) newObject).realmGet$name());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.SpokenLanguage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpokenLanguageColumnInfo columnInfo = (SpokenLanguageColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$iso6391 = ((SpokenLanguageRealmProxyInterface)object).realmGet$iso6391();
        if (realmGet$iso6391 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iso6391Index, rowIndex, realmGet$iso6391, false);
        }
        String realmGet$name = ((SpokenLanguageRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpokenLanguageColumnInfo columnInfo = (SpokenLanguageColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        com.example.bajob.movieshatch.Pojo.SpokenLanguage object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.SpokenLanguage) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$iso6391 = ((SpokenLanguageRealmProxyInterface)object).realmGet$iso6391();
                if (realmGet$iso6391 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iso6391Index, rowIndex, realmGet$iso6391, false);
                }
                String realmGet$name = ((SpokenLanguageRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.SpokenLanguage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpokenLanguageColumnInfo columnInfo = (SpokenLanguageColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$iso6391 = ((SpokenLanguageRealmProxyInterface)object).realmGet$iso6391();
        if (realmGet$iso6391 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iso6391Index, rowIndex, realmGet$iso6391, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iso6391Index, rowIndex, false);
        }
        String realmGet$name = ((SpokenLanguageRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpokenLanguageColumnInfo columnInfo = (SpokenLanguageColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.SpokenLanguage.class);
        com.example.bajob.movieshatch.Pojo.SpokenLanguage object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.SpokenLanguage) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$iso6391 = ((SpokenLanguageRealmProxyInterface)object).realmGet$iso6391();
                if (realmGet$iso6391 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iso6391Index, rowIndex, realmGet$iso6391, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iso6391Index, rowIndex, false);
                }
                String realmGet$name = ((SpokenLanguageRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.SpokenLanguage createDetachedCopy(com.example.bajob.movieshatch.Pojo.SpokenLanguage realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.SpokenLanguage unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.SpokenLanguage)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.SpokenLanguage)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.SpokenLanguage();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((SpokenLanguageRealmProxyInterface) unmanagedObject).realmSet$iso6391(((SpokenLanguageRealmProxyInterface) realmObject).realmGet$iso6391());
        ((SpokenLanguageRealmProxyInterface) unmanagedObject).realmSet$name(((SpokenLanguageRealmProxyInterface) realmObject).realmGet$name());
        return unmanagedObject;
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
        SpokenLanguageRealmProxy aSpokenLanguage = (SpokenLanguageRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSpokenLanguage.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSpokenLanguage.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSpokenLanguage.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
