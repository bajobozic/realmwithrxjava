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

public class TopRatedTvShowsRealmProxy extends com.example.bajob.movieshatch.Pojo.TopRatedTvShows
    implements RealmObjectProxy, TopRatedTvShowsRealmProxyInterface {

    static final class TopRatedTvShowsColumnInfo extends ColumnInfo
        implements Cloneable {

        public long pageIndex;
        public long resultsIndex;
        public long totalResultsIndex;
        public long totalPagesIndex;

        TopRatedTvShowsColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.pageIndex = getValidColumnIndex(path, table, "TopRatedTvShows", "page");
            indicesMap.put("page", this.pageIndex);
            this.resultsIndex = getValidColumnIndex(path, table, "TopRatedTvShows", "results");
            indicesMap.put("results", this.resultsIndex);
            this.totalResultsIndex = getValidColumnIndex(path, table, "TopRatedTvShows", "totalResults");
            indicesMap.put("totalResults", this.totalResultsIndex);
            this.totalPagesIndex = getValidColumnIndex(path, table, "TopRatedTvShows", "totalPages");
            indicesMap.put("totalPages", this.totalPagesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final TopRatedTvShowsColumnInfo otherInfo = (TopRatedTvShowsColumnInfo) other;
            this.pageIndex = otherInfo.pageIndex;
            this.resultsIndex = otherInfo.resultsIndex;
            this.totalResultsIndex = otherInfo.totalResultsIndex;
            this.totalPagesIndex = otherInfo.totalPagesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final TopRatedTvShowsColumnInfo clone() {
            return (TopRatedTvShowsColumnInfo) super.clone();
        }

    }
    private TopRatedTvShowsColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.TopRatedTvShows> proxyState;
    private RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("page");
        fieldNames.add("results");
        fieldNames.add("totalResults");
        fieldNames.add("totalPages");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    TopRatedTvShowsRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TopRatedTvShowsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.TopRatedTvShows>(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public Integer realmGet$page() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.pageIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.pageIndex);
    }

    public void realmSet$page(Integer value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'page' cannot be changed after object was created.");
    }

    public RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> realmGet$results() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (resultsRealmList != null) {
            return resultsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.resultsIndex);
            resultsRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo>(com.example.bajob.movieshatch.Pojo.TvShowInfo.class, linkView, proxyState.getRealm$realm());
            return resultsRealmList;
        }
    }

    public void realmSet$results(RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("results")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo>();
                for (com.example.bajob.movieshatch.Pojo.TvShowInfo item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.resultsIndex);
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
    public Integer realmGet$totalResults() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.totalResultsIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalResultsIndex);
    }

    public void realmSet$totalResults(Integer value) {
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
                row.getTable().setNull(columnInfo.totalResultsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.totalResultsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalResultsIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.totalResultsIndex, value);
    }

    @SuppressWarnings("cast")
    public Integer realmGet$totalPages() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.totalPagesIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalPagesIndex);
    }

    public void realmSet$totalPages(Integer value) {
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
                row.getTable().setNull(columnInfo.totalPagesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.totalPagesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalPagesIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.totalPagesIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("TopRatedTvShows")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("TopRatedTvShows");
            realmObjectSchema.add(new Property("page", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("TvShowInfo")) {
                TvShowInfoRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("results", RealmFieldType.LIST, realmSchema.get("TvShowInfo")));
            realmObjectSchema.add(new Property("totalResults", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("totalPages", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("TopRatedTvShows");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_TopRatedTvShows")) {
            Table table = sharedRealm.getTable("class_TopRatedTvShows");
            table.addColumn(RealmFieldType.INTEGER, "page", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_TvShowInfo")) {
                TvShowInfoRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "results", sharedRealm.getTable("class_TvShowInfo"));
            table.addColumn(RealmFieldType.INTEGER, "totalResults", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "totalPages", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("page"));
            table.setPrimaryKey("page");
            return table;
        }
        return sharedRealm.getTable("class_TopRatedTvShows");
    }

    public static TopRatedTvShowsColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_TopRatedTvShows")) {
            Table table = sharedRealm.getTable("class_TopRatedTvShows");
            final long columnCount = table.getColumnCount();
            if (columnCount != 4) {
                if (columnCount < 4) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final TopRatedTvShowsColumnInfo columnInfo = new TopRatedTvShowsColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'page' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.pageIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field page");
                }
            }

            if (!columnTypes.containsKey("page")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'page' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("page") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'page' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.pageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'page' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("page"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'page' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("results")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'results'");
            }
            if (columnTypes.get("results") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'TvShowInfo' for field 'results'");
            }
            if (!sharedRealm.hasTable("class_TvShowInfo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_TvShowInfo' for field 'results'");
            }
            Table table_1 = sharedRealm.getTable("class_TvShowInfo");
            if (!table.getLinkTarget(columnInfo.resultsIndex).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'results': '" + table.getLinkTarget(columnInfo.resultsIndex).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            if (!columnTypes.containsKey("totalResults")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalResults' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("totalResults") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'totalResults' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.totalResultsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'totalResults' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'totalResults' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("totalPages")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalPages' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("totalPages") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'totalPages' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.totalPagesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'totalPages' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'totalPages' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'TopRatedTvShows' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_TopRatedTvShows";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.TopRatedTvShows createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.example.bajob.movieshatch.Pojo.TopRatedTvShows obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("page")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("page"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class), false, Collections.<String> emptyList());
                    obj = new io.realm.TopRatedTvShowsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("results")) {
                excludeFields.add("results");
            }
            if (json.has("page")) {
                if (json.isNull("page")) {
                    obj = (io.realm.TopRatedTvShowsRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.TopRatedTvShowsRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class, json.getInt("page"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'page'.");
            }
        }
        if (json.has("results")) {
            if (json.isNull("results")) {
                ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$results(null);
            } else {
                ((TopRatedTvShowsRealmProxyInterface) obj).realmGet$results().clear();
                JSONArray array = json.getJSONArray("results");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.TvShowInfo item = TvShowInfoRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmGet$results().add(item);
                }
            }
        }
        if (json.has("totalResults")) {
            if (json.isNull("totalResults")) {
                ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$totalResults(null);
            } else {
                ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$totalResults((int) json.getInt("totalResults"));
            }
        }
        if (json.has("totalPages")) {
            if (json.isNull("totalPages")) {
                ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$totalPages(null);
            } else {
                ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$totalPages((int) json.getInt("totalPages"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.TopRatedTvShows createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.bajob.movieshatch.Pojo.TopRatedTvShows obj = new com.example.bajob.movieshatch.Pojo.TopRatedTvShows();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("page")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$page(null);
                } else {
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$page((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("results")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$results(null);
                } else {
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$results(new RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.TvShowInfo item = TvShowInfoRealmProxy.createUsingJsonStream(realm, reader);
                        ((TopRatedTvShowsRealmProxyInterface) obj).realmGet$results().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("totalResults")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$totalResults(null);
                } else {
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$totalResults((int) reader.nextInt());
                }
            } else if (name.equals("totalPages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$totalPages(null);
                } else {
                    ((TopRatedTvShowsRealmProxyInterface) obj).realmSet$totalPages((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'page'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.bajob.movieshatch.Pojo.TopRatedTvShows copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedTvShows object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) cachedRealmObject;
        } else {
            com.example.bajob.movieshatch.Pojo.TopRatedTvShows realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.TopRatedTvShowsRealmProxy();
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

    public static com.example.bajob.movieshatch.Pojo.TopRatedTvShows copy(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedTvShows newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.TopRatedTvShows realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class, ((TopRatedTvShowsRealmProxyInterface) newObject).realmGet$page(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);

            RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsList = ((TopRatedTvShowsRealmProxyInterface) newObject).realmGet$results();
            if (resultsList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsRealmList = ((TopRatedTvShowsRealmProxyInterface) realmObject).realmGet$results();
                for (int i = 0; i < resultsList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.TvShowInfo resultsItem = resultsList.get(i);
                    com.example.bajob.movieshatch.Pojo.TvShowInfo cacheresults = (com.example.bajob.movieshatch.Pojo.TvShowInfo) cache.get(resultsItem);
                    if (cacheresults != null) {
                        resultsRealmList.add(cacheresults);
                    } else {
                        resultsRealmList.add(TvShowInfoRealmProxy.copyOrUpdate(realm, resultsList.get(i), update, cache));
                    }
                }
            }

            ((TopRatedTvShowsRealmProxyInterface) realmObject).realmSet$totalResults(((TopRatedTvShowsRealmProxyInterface) newObject).realmGet$totalResults());
            ((TopRatedTvShowsRealmProxyInterface) realmObject).realmSet$totalPages(((TopRatedTvShowsRealmProxyInterface) newObject).realmGet$totalPages());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedTvShows object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        long tableNativePtr = table.getNativeTablePointer();
        TopRatedTvShowsColumnInfo columnInfo = (TopRatedTvShowsColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((TopRatedTvShowsRealmProxyInterface) object).realmGet$page(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);

        RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsList = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$results();
        if (resultsList != null) {
            long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.TvShowInfo resultsItem : resultsList) {
                Long cacheItemIndexresults = cache.get(resultsItem);
                if (cacheItemIndexresults == null) {
                    cacheItemIndexresults = TvShowInfoRealmProxy.insert(realm, resultsItem, cache);
                }
                LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
            }
        }

        Number realmGet$totalResults = ((TopRatedTvShowsRealmProxyInterface)object).realmGet$totalResults();
        if (realmGet$totalResults != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
        }
        Number realmGet$totalPages = ((TopRatedTvShowsRealmProxyInterface)object).realmGet$totalPages();
        if (realmGet$totalPages != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        long tableNativePtr = table.getNativeTablePointer();
        TopRatedTvShowsColumnInfo columnInfo = (TopRatedTvShowsColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.TopRatedTvShows object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((TopRatedTvShowsRealmProxyInterface) object).realmGet$page(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);

                RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsList = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$results();
                if (resultsList != null) {
                    long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.TvShowInfo resultsItem : resultsList) {
                        Long cacheItemIndexresults = cache.get(resultsItem);
                        if (cacheItemIndexresults == null) {
                            cacheItemIndexresults = TvShowInfoRealmProxy.insert(realm, resultsItem, cache);
                        }
                        LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
                    }
                }

                Number realmGet$totalResults = ((TopRatedTvShowsRealmProxyInterface)object).realmGet$totalResults();
                if (realmGet$totalResults != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
                }
                Number realmGet$totalPages = ((TopRatedTvShowsRealmProxyInterface)object).realmGet$totalPages();
                if (realmGet$totalPages != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedTvShows object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        long tableNativePtr = table.getNativeTablePointer();
        TopRatedTvShowsColumnInfo columnInfo = (TopRatedTvShowsColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((TopRatedTvShowsRealmProxyInterface) object).realmGet$page(), false);
        }
        cache.put(object, rowIndex);

        long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
        LinkView.nativeClear(resultsNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsList = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$results();
        if (resultsList != null) {
            for (com.example.bajob.movieshatch.Pojo.TvShowInfo resultsItem : resultsList) {
                Long cacheItemIndexresults = cache.get(resultsItem);
                if (cacheItemIndexresults == null) {
                    cacheItemIndexresults = TvShowInfoRealmProxy.insertOrUpdate(realm, resultsItem, cache);
                }
                LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
            }
        }

        Number realmGet$totalResults = ((TopRatedTvShowsRealmProxyInterface)object).realmGet$totalResults();
        if (realmGet$totalResults != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, false);
        }
        Number realmGet$totalPages = ((TopRatedTvShowsRealmProxyInterface)object).realmGet$totalPages();
        if (realmGet$totalPages != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        long tableNativePtr = table.getNativeTablePointer();
        TopRatedTvShowsColumnInfo columnInfo = (TopRatedTvShowsColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedTvShows.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.TopRatedTvShows object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.TopRatedTvShows) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TopRatedTvShowsRealmProxyInterface) object).realmGet$page());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((TopRatedTvShowsRealmProxyInterface) object).realmGet$page(), false);
                }
                cache.put(object, rowIndex);

                long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
                LinkView.nativeClear(resultsNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsList = ((TopRatedTvShowsRealmProxyInterface) object).realmGet$results();
                if (resultsList != null) {
                    for (com.example.bajob.movieshatch.Pojo.TvShowInfo resultsItem : resultsList) {
                        Long cacheItemIndexresults = cache.get(resultsItem);
                        if (cacheItemIndexresults == null) {
                            cacheItemIndexresults = TvShowInfoRealmProxy.insertOrUpdate(realm, resultsItem, cache);
                        }
                        LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
                    }
                }

                Number realmGet$totalResults = ((TopRatedTvShowsRealmProxyInterface)object).realmGet$totalResults();
                if (realmGet$totalResults != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, false);
                }
                Number realmGet$totalPages = ((TopRatedTvShowsRealmProxyInterface)object).realmGet$totalPages();
                if (realmGet$totalPages != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.TopRatedTvShows createDetachedCopy(com.example.bajob.movieshatch.Pojo.TopRatedTvShows realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.TopRatedTvShows unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.TopRatedTvShows)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.TopRatedTvShows)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.TopRatedTvShows();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((TopRatedTvShowsRealmProxyInterface) unmanagedObject).realmSet$page(((TopRatedTvShowsRealmProxyInterface) realmObject).realmGet$page());

        // Deep copy of results
        if (currentDepth == maxDepth) {
            ((TopRatedTvShowsRealmProxyInterface) unmanagedObject).realmSet$results(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> managedresultsList = ((TopRatedTvShowsRealmProxyInterface) realmObject).realmGet$results();
            RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> unmanagedresultsList = new RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo>();
            ((TopRatedTvShowsRealmProxyInterface) unmanagedObject).realmSet$results(unmanagedresultsList);
            int nextDepth = currentDepth + 1;
            int size = managedresultsList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.TvShowInfo item = TvShowInfoRealmProxy.createDetachedCopy(managedresultsList.get(i), nextDepth, maxDepth, cache);
                unmanagedresultsList.add(item);
            }
        }
        ((TopRatedTvShowsRealmProxyInterface) unmanagedObject).realmSet$totalResults(((TopRatedTvShowsRealmProxyInterface) realmObject).realmGet$totalResults());
        ((TopRatedTvShowsRealmProxyInterface) unmanagedObject).realmSet$totalPages(((TopRatedTvShowsRealmProxyInterface) realmObject).realmGet$totalPages());
        return unmanagedObject;
    }

    static com.example.bajob.movieshatch.Pojo.TopRatedTvShows update(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedTvShows realmObject, com.example.bajob.movieshatch.Pojo.TopRatedTvShows newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsList = ((TopRatedTvShowsRealmProxyInterface) newObject).realmGet$results();
        RealmList<com.example.bajob.movieshatch.Pojo.TvShowInfo> resultsRealmList = ((TopRatedTvShowsRealmProxyInterface) realmObject).realmGet$results();
        resultsRealmList.clear();
        if (resultsList != null) {
            for (int i = 0; i < resultsList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.TvShowInfo resultsItem = resultsList.get(i);
                com.example.bajob.movieshatch.Pojo.TvShowInfo cacheresults = (com.example.bajob.movieshatch.Pojo.TvShowInfo) cache.get(resultsItem);
                if (cacheresults != null) {
                    resultsRealmList.add(cacheresults);
                } else {
                    resultsRealmList.add(TvShowInfoRealmProxy.copyOrUpdate(realm, resultsList.get(i), true, cache));
                }
            }
        }
        ((TopRatedTvShowsRealmProxyInterface) realmObject).realmSet$totalResults(((TopRatedTvShowsRealmProxyInterface) newObject).realmGet$totalResults());
        ((TopRatedTvShowsRealmProxyInterface) realmObject).realmSet$totalPages(((TopRatedTvShowsRealmProxyInterface) newObject).realmGet$totalPages());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TopRatedTvShows = [");
        stringBuilder.append("{page:");
        stringBuilder.append(realmGet$page() != null ? realmGet$page() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{results:");
        stringBuilder.append("RealmList<TvShowInfo>[").append(realmGet$results().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalResults:");
        stringBuilder.append(realmGet$totalResults() != null ? realmGet$totalResults() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalPages:");
        stringBuilder.append(realmGet$totalPages() != null ? realmGet$totalPages() : "null");
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
        TopRatedTvShowsRealmProxy aTopRatedTvShows = (TopRatedTvShowsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTopRatedTvShows.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTopRatedTvShows.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTopRatedTvShows.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
