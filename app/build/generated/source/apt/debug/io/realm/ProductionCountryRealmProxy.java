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

public class ProductionCountryRealmProxy extends com.example.bajob.movieshatch.Pojo.ProductionCountry
    implements RealmObjectProxy, ProductionCountryRealmProxyInterface {

    static final class ProductionCountryColumnInfo extends ColumnInfo
        implements Cloneable {

        public long iso31661Index;
        public long nameIndex;

        ProductionCountryColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.iso31661Index = getValidColumnIndex(path, table, "ProductionCountry", "iso31661");
            indicesMap.put("iso31661", this.iso31661Index);
            this.nameIndex = getValidColumnIndex(path, table, "ProductionCountry", "name");
            indicesMap.put("name", this.nameIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ProductionCountryColumnInfo otherInfo = (ProductionCountryColumnInfo) other;
            this.iso31661Index = otherInfo.iso31661Index;
            this.nameIndex = otherInfo.nameIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ProductionCountryColumnInfo clone() {
            return (ProductionCountryColumnInfo) super.clone();
        }

    }
    private ProductionCountryColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.ProductionCountry> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("iso31661");
        fieldNames.add("name");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProductionCountryRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductionCountryColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.ProductionCountry>(com.example.bajob.movieshatch.Pojo.ProductionCountry.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$iso31661() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iso31661Index);
    }

    public void realmSet$iso31661(String value) {
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
                row.getTable().setNull(columnInfo.iso31661Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iso31661Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iso31661Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iso31661Index, value);
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
        if (!realmSchema.contains("ProductionCountry")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ProductionCountry");
            realmObjectSchema.add(new Property("iso31661", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("ProductionCountry");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_ProductionCountry")) {
            Table table = sharedRealm.getTable("class_ProductionCountry");
            table.addColumn(RealmFieldType.STRING, "iso31661", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_ProductionCountry");
    }

    public static ProductionCountryColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_ProductionCountry")) {
            Table table = sharedRealm.getTable("class_ProductionCountry");
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

            final ProductionCountryColumnInfo columnInfo = new ProductionCountryColumnInfo(sharedRealm.getPath(), table);

            if (table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
            }

            if (!columnTypes.containsKey("iso31661")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iso31661' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iso31661") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'iso31661' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.iso31661Index)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iso31661' is required. Either set @Required to field 'iso31661' or migrate using RealmObjectSchema.setNullable().");
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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ProductionCountry' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ProductionCountry";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.ProductionCountry createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bajob.movieshatch.Pojo.ProductionCountry obj = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.ProductionCountry.class, true, excludeFields);
        if (json.has("iso31661")) {
            if (json.isNull("iso31661")) {
                ((ProductionCountryRealmProxyInterface) obj).realmSet$iso31661(null);
            } else {
                ((ProductionCountryRealmProxyInterface) obj).realmSet$iso31661((String) json.getString("iso31661"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ProductionCountryRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ProductionCountryRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.ProductionCountry createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.example.bajob.movieshatch.Pojo.ProductionCountry obj = new com.example.bajob.movieshatch.Pojo.ProductionCountry();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("iso31661")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductionCountryRealmProxyInterface) obj).realmSet$iso31661(null);
                } else {
                    ((ProductionCountryRealmProxyInterface) obj).realmSet$iso31661((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductionCountryRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ProductionCountryRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.bajob.movieshatch.Pojo.ProductionCountry copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.ProductionCountry object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.ProductionCountry) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.example.bajob.movieshatch.Pojo.ProductionCountry copy(Realm realm, com.example.bajob.movieshatch.Pojo.ProductionCountry newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.ProductionCountry) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.ProductionCountry realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.ProductionCountry.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProductionCountryRealmProxyInterface) realmObject).realmSet$iso31661(((ProductionCountryRealmProxyInterface) newObject).realmGet$iso31661());
            ((ProductionCountryRealmProxyInterface) realmObject).realmSet$name(((ProductionCountryRealmProxyInterface) newObject).realmGet$name());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.ProductionCountry object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductionCountryColumnInfo columnInfo = (ProductionCountryColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$iso31661 = ((ProductionCountryRealmProxyInterface)object).realmGet$iso31661();
        if (realmGet$iso31661 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iso31661Index, rowIndex, realmGet$iso31661, false);
        }
        String realmGet$name = ((ProductionCountryRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductionCountryColumnInfo columnInfo = (ProductionCountryColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        com.example.bajob.movieshatch.Pojo.ProductionCountry object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.ProductionCountry) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$iso31661 = ((ProductionCountryRealmProxyInterface)object).realmGet$iso31661();
                if (realmGet$iso31661 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iso31661Index, rowIndex, realmGet$iso31661, false);
                }
                String realmGet$name = ((ProductionCountryRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.ProductionCountry object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductionCountryColumnInfo columnInfo = (ProductionCountryColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$iso31661 = ((ProductionCountryRealmProxyInterface)object).realmGet$iso31661();
        if (realmGet$iso31661 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iso31661Index, rowIndex, realmGet$iso31661, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iso31661Index, rowIndex, false);
        }
        String realmGet$name = ((ProductionCountryRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductionCountryColumnInfo columnInfo = (ProductionCountryColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.ProductionCountry.class);
        com.example.bajob.movieshatch.Pojo.ProductionCountry object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.ProductionCountry) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$iso31661 = ((ProductionCountryRealmProxyInterface)object).realmGet$iso31661();
                if (realmGet$iso31661 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.iso31661Index, rowIndex, realmGet$iso31661, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.iso31661Index, rowIndex, false);
                }
                String realmGet$name = ((ProductionCountryRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.ProductionCountry createDetachedCopy(com.example.bajob.movieshatch.Pojo.ProductionCountry realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.ProductionCountry unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.ProductionCountry)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.ProductionCountry)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.ProductionCountry();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ProductionCountryRealmProxyInterface) unmanagedObject).realmSet$iso31661(((ProductionCountryRealmProxyInterface) realmObject).realmGet$iso31661());
        ((ProductionCountryRealmProxyInterface) unmanagedObject).realmSet$name(((ProductionCountryRealmProxyInterface) realmObject).realmGet$name());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ProductionCountry = [");
        stringBuilder.append("{iso31661:");
        stringBuilder.append(realmGet$iso31661() != null ? realmGet$iso31661() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
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
        ProductionCountryRealmProxy aProductionCountry = (ProductionCountryRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProductionCountry.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProductionCountry.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProductionCountry.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
