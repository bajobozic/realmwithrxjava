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

public class TopRatedMoviesRealmProxy extends com.example.bajob.movieshatch.Pojo.TopRatedMovies
    implements RealmObjectProxy, TopRatedMoviesRealmProxyInterface {

    static final class TopRatedMoviesColumnInfo extends ColumnInfo
        implements Cloneable {

        public long pageIndex;
        public long resultsIndex;
        public long totalResultsIndex;
        public long totalPagesIndex;

        TopRatedMoviesColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.pageIndex = getValidColumnIndex(path, table, "TopRatedMovies", "page");
            indicesMap.put("page", this.pageIndex);
            this.resultsIndex = getValidColumnIndex(path, table, "TopRatedMovies", "results");
            indicesMap.put("results", this.resultsIndex);
            this.totalResultsIndex = getValidColumnIndex(path, table, "TopRatedMovies", "totalResults");
            indicesMap.put("totalResults", this.totalResultsIndex);
            this.totalPagesIndex = getValidColumnIndex(path, table, "TopRatedMovies", "totalPages");
            indicesMap.put("totalPages", this.totalPagesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final TopRatedMoviesColumnInfo otherInfo = (TopRatedMoviesColumnInfo) other;
            this.pageIndex = otherInfo.pageIndex;
            this.resultsIndex = otherInfo.resultsIndex;
            this.totalResultsIndex = otherInfo.totalResultsIndex;
            this.totalPagesIndex = otherInfo.totalPagesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final TopRatedMoviesColumnInfo clone() {
            return (TopRatedMoviesColumnInfo) super.clone();
        }

    }
    private TopRatedMoviesColumnInfo columnInfo;
    private ProxyState<com.example.bajob.movieshatch.Pojo.TopRatedMovies> proxyState;
    private RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("page");
        fieldNames.add("results");
        fieldNames.add("totalResults");
        fieldNames.add("totalPages");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    TopRatedMoviesRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TopRatedMoviesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bajob.movieshatch.Pojo.TopRatedMovies>(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class, this);
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

    public RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> realmGet$results() {
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
            resultsRealmList = new RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo>(com.example.bajob.movieshatch.Pojo.MovieInfo.class, linkView, proxyState.getRealm$realm());
            return resultsRealmList;
        }
    }

    public void realmSet$results(RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> value) {
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
                final RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> original = value;
                value = new RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo>();
                for (com.example.bajob.movieshatch.Pojo.MovieInfo item : original) {
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
        if (!realmSchema.contains("TopRatedMovies")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("TopRatedMovies");
            realmObjectSchema.add(new Property("page", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("MovieInfo")) {
                MovieInfoRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("results", RealmFieldType.LIST, realmSchema.get("MovieInfo")));
            realmObjectSchema.add(new Property("totalResults", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("totalPages", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("TopRatedMovies");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_TopRatedMovies")) {
            Table table = sharedRealm.getTable("class_TopRatedMovies");
            table.addColumn(RealmFieldType.INTEGER, "page", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_MovieInfo")) {
                MovieInfoRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "results", sharedRealm.getTable("class_MovieInfo"));
            table.addColumn(RealmFieldType.INTEGER, "totalResults", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "totalPages", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("page"));
            table.setPrimaryKey("page");
            return table;
        }
        return sharedRealm.getTable("class_TopRatedMovies");
    }

    public static TopRatedMoviesColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_TopRatedMovies")) {
            Table table = sharedRealm.getTable("class_TopRatedMovies");
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

            final TopRatedMoviesColumnInfo columnInfo = new TopRatedMoviesColumnInfo(sharedRealm.getPath(), table);

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
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'MovieInfo' for field 'results'");
            }
            if (!sharedRealm.hasTable("class_MovieInfo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_MovieInfo' for field 'results'");
            }
            Table table_1 = sharedRealm.getTable("class_MovieInfo");
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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'TopRatedMovies' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_TopRatedMovies";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.bajob.movieshatch.Pojo.TopRatedMovies createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.example.bajob.movieshatch.Pojo.TopRatedMovies obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class), false, Collections.<String> emptyList());
                    obj = new io.realm.TopRatedMoviesRealmProxy();
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
                    obj = (io.realm.TopRatedMoviesRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.TopRatedMoviesRealmProxy) realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class, json.getInt("page"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'page'.");
            }
        }
        if (json.has("results")) {
            if (json.isNull("results")) {
                ((TopRatedMoviesRealmProxyInterface) obj).realmSet$results(null);
            } else {
                ((TopRatedMoviesRealmProxyInterface) obj).realmGet$results().clear();
                JSONArray array = json.getJSONArray("results");
                for (int i = 0; i < array.length(); i++) {
                    com.example.bajob.movieshatch.Pojo.MovieInfo item = MovieInfoRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((TopRatedMoviesRealmProxyInterface) obj).realmGet$results().add(item);
                }
            }
        }
        if (json.has("totalResults")) {
            if (json.isNull("totalResults")) {
                ((TopRatedMoviesRealmProxyInterface) obj).realmSet$totalResults(null);
            } else {
                ((TopRatedMoviesRealmProxyInterface) obj).realmSet$totalResults((int) json.getInt("totalResults"));
            }
        }
        if (json.has("totalPages")) {
            if (json.isNull("totalPages")) {
                ((TopRatedMoviesRealmProxyInterface) obj).realmSet$totalPages(null);
            } else {
                ((TopRatedMoviesRealmProxyInterface) obj).realmSet$totalPages((int) json.getInt("totalPages"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bajob.movieshatch.Pojo.TopRatedMovies createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.bajob.movieshatch.Pojo.TopRatedMovies obj = new com.example.bajob.movieshatch.Pojo.TopRatedMovies();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("page")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TopRatedMoviesRealmProxyInterface) obj).realmSet$page(null);
                } else {
                    ((TopRatedMoviesRealmProxyInterface) obj).realmSet$page((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("results")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TopRatedMoviesRealmProxyInterface) obj).realmSet$results(null);
                } else {
                    ((TopRatedMoviesRealmProxyInterface) obj).realmSet$results(new RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.bajob.movieshatch.Pojo.MovieInfo item = MovieInfoRealmProxy.createUsingJsonStream(realm, reader);
                        ((TopRatedMoviesRealmProxyInterface) obj).realmGet$results().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("totalResults")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TopRatedMoviesRealmProxyInterface) obj).realmSet$totalResults(null);
                } else {
                    ((TopRatedMoviesRealmProxyInterface) obj).realmSet$totalResults((int) reader.nextInt());
                }
            } else if (name.equals("totalPages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TopRatedMoviesRealmProxyInterface) obj).realmSet$totalPages(null);
                } else {
                    ((TopRatedMoviesRealmProxyInterface) obj).realmSet$totalPages((int) reader.nextInt());
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

    public static com.example.bajob.movieshatch.Pojo.TopRatedMovies copyOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedMovies object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.TopRatedMovies) cachedRealmObject;
        } else {
            com.example.bajob.movieshatch.Pojo.TopRatedMovies realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((TopRatedMoviesRealmProxyInterface) object).realmGet$page();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.TopRatedMoviesRealmProxy();
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

    public static com.example.bajob.movieshatch.Pojo.TopRatedMovies copy(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedMovies newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bajob.movieshatch.Pojo.TopRatedMovies) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.bajob.movieshatch.Pojo.TopRatedMovies realmObject = realm.createObjectInternal(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class, ((TopRatedMoviesRealmProxyInterface) newObject).realmGet$page(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);

            RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsList = ((TopRatedMoviesRealmProxyInterface) newObject).realmGet$results();
            if (resultsList != null) {
                RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsRealmList = ((TopRatedMoviesRealmProxyInterface) realmObject).realmGet$results();
                for (int i = 0; i < resultsList.size(); i++) {
                    com.example.bajob.movieshatch.Pojo.MovieInfo resultsItem = resultsList.get(i);
                    com.example.bajob.movieshatch.Pojo.MovieInfo cacheresults = (com.example.bajob.movieshatch.Pojo.MovieInfo) cache.get(resultsItem);
                    if (cacheresults != null) {
                        resultsRealmList.add(cacheresults);
                    } else {
                        resultsRealmList.add(MovieInfoRealmProxy.copyOrUpdate(realm, resultsList.get(i), update, cache));
                    }
                }
            }

            ((TopRatedMoviesRealmProxyInterface) realmObject).realmSet$totalResults(((TopRatedMoviesRealmProxyInterface) newObject).realmGet$totalResults());
            ((TopRatedMoviesRealmProxyInterface) realmObject).realmSet$totalPages(((TopRatedMoviesRealmProxyInterface) newObject).realmGet$totalPages());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedMovies object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        long tableNativePtr = table.getNativeTablePointer();
        TopRatedMoviesColumnInfo columnInfo = (TopRatedMoviesColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((TopRatedMoviesRealmProxyInterface) object).realmGet$page();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TopRatedMoviesRealmProxyInterface) object).realmGet$page());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((TopRatedMoviesRealmProxyInterface) object).realmGet$page(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);

        RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsList = ((TopRatedMoviesRealmProxyInterface) object).realmGet$results();
        if (resultsList != null) {
            long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
            for (com.example.bajob.movieshatch.Pojo.MovieInfo resultsItem : resultsList) {
                Long cacheItemIndexresults = cache.get(resultsItem);
                if (cacheItemIndexresults == null) {
                    cacheItemIndexresults = MovieInfoRealmProxy.insert(realm, resultsItem, cache);
                }
                LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
            }
        }

        Number realmGet$totalResults = ((TopRatedMoviesRealmProxyInterface)object).realmGet$totalResults();
        if (realmGet$totalResults != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
        }
        Number realmGet$totalPages = ((TopRatedMoviesRealmProxyInterface)object).realmGet$totalPages();
        if (realmGet$totalPages != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        long tableNativePtr = table.getNativeTablePointer();
        TopRatedMoviesColumnInfo columnInfo = (TopRatedMoviesColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.TopRatedMovies object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.TopRatedMovies) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((TopRatedMoviesRealmProxyInterface) object).realmGet$page();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TopRatedMoviesRealmProxyInterface) object).realmGet$page());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((TopRatedMoviesRealmProxyInterface) object).realmGet$page(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);

                RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsList = ((TopRatedMoviesRealmProxyInterface) object).realmGet$results();
                if (resultsList != null) {
                    long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
                    for (com.example.bajob.movieshatch.Pojo.MovieInfo resultsItem : resultsList) {
                        Long cacheItemIndexresults = cache.get(resultsItem);
                        if (cacheItemIndexresults == null) {
                            cacheItemIndexresults = MovieInfoRealmProxy.insert(realm, resultsItem, cache);
                        }
                        LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
                    }
                }

                Number realmGet$totalResults = ((TopRatedMoviesRealmProxyInterface)object).realmGet$totalResults();
                if (realmGet$totalResults != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
                }
                Number realmGet$totalPages = ((TopRatedMoviesRealmProxyInterface)object).realmGet$totalPages();
                if (realmGet$totalPages != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedMovies object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        long tableNativePtr = table.getNativeTablePointer();
        TopRatedMoviesColumnInfo columnInfo = (TopRatedMoviesColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((TopRatedMoviesRealmProxyInterface) object).realmGet$page();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TopRatedMoviesRealmProxyInterface) object).realmGet$page());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((TopRatedMoviesRealmProxyInterface) object).realmGet$page(), false);
        }
        cache.put(object, rowIndex);

        long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
        LinkView.nativeClear(resultsNativeLinkViewPtr);
        RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsList = ((TopRatedMoviesRealmProxyInterface) object).realmGet$results();
        if (resultsList != null) {
            for (com.example.bajob.movieshatch.Pojo.MovieInfo resultsItem : resultsList) {
                Long cacheItemIndexresults = cache.get(resultsItem);
                if (cacheItemIndexresults == null) {
                    cacheItemIndexresults = MovieInfoRealmProxy.insertOrUpdate(realm, resultsItem, cache);
                }
                LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
            }
        }

        Number realmGet$totalResults = ((TopRatedMoviesRealmProxyInterface)object).realmGet$totalResults();
        if (realmGet$totalResults != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, false);
        }
        Number realmGet$totalPages = ((TopRatedMoviesRealmProxyInterface)object).realmGet$totalPages();
        if (realmGet$totalPages != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        long tableNativePtr = table.getNativeTablePointer();
        TopRatedMoviesColumnInfo columnInfo = (TopRatedMoviesColumnInfo) realm.schema.getColumnInfo(com.example.bajob.movieshatch.Pojo.TopRatedMovies.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.bajob.movieshatch.Pojo.TopRatedMovies object = null;
        while (objects.hasNext()) {
            object = (com.example.bajob.movieshatch.Pojo.TopRatedMovies) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((TopRatedMoviesRealmProxyInterface) object).realmGet$page();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TopRatedMoviesRealmProxyInterface) object).realmGet$page());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((TopRatedMoviesRealmProxyInterface) object).realmGet$page(), false);
                }
                cache.put(object, rowIndex);

                long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
                LinkView.nativeClear(resultsNativeLinkViewPtr);
                RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsList = ((TopRatedMoviesRealmProxyInterface) object).realmGet$results();
                if (resultsList != null) {
                    for (com.example.bajob.movieshatch.Pojo.MovieInfo resultsItem : resultsList) {
                        Long cacheItemIndexresults = cache.get(resultsItem);
                        if (cacheItemIndexresults == null) {
                            cacheItemIndexresults = MovieInfoRealmProxy.insertOrUpdate(realm, resultsItem, cache);
                        }
                        LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
                    }
                }

                Number realmGet$totalResults = ((TopRatedMoviesRealmProxyInterface)object).realmGet$totalResults();
                if (realmGet$totalResults != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, false);
                }
                Number realmGet$totalPages = ((TopRatedMoviesRealmProxyInterface)object).realmGet$totalPages();
                if (realmGet$totalPages != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.example.bajob.movieshatch.Pojo.TopRatedMovies createDetachedCopy(com.example.bajob.movieshatch.Pojo.TopRatedMovies realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bajob.movieshatch.Pojo.TopRatedMovies unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bajob.movieshatch.Pojo.TopRatedMovies)cachedObject.object;
            } else {
                unmanagedObject = (com.example.bajob.movieshatch.Pojo.TopRatedMovies)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.bajob.movieshatch.Pojo.TopRatedMovies();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((TopRatedMoviesRealmProxyInterface) unmanagedObject).realmSet$page(((TopRatedMoviesRealmProxyInterface) realmObject).realmGet$page());

        // Deep copy of results
        if (currentDepth == maxDepth) {
            ((TopRatedMoviesRealmProxyInterface) unmanagedObject).realmSet$results(null);
        } else {
            RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> managedresultsList = ((TopRatedMoviesRealmProxyInterface) realmObject).realmGet$results();
            RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> unmanagedresultsList = new RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo>();
            ((TopRatedMoviesRealmProxyInterface) unmanagedObject).realmSet$results(unmanagedresultsList);
            int nextDepth = currentDepth + 1;
            int size = managedresultsList.size();
            for (int i = 0; i < size; i++) {
                com.example.bajob.movieshatch.Pojo.MovieInfo item = MovieInfoRealmProxy.createDetachedCopy(managedresultsList.get(i), nextDepth, maxDepth, cache);
                unmanagedresultsList.add(item);
            }
        }
        ((TopRatedMoviesRealmProxyInterface) unmanagedObject).realmSet$totalResults(((TopRatedMoviesRealmProxyInterface) realmObject).realmGet$totalResults());
        ((TopRatedMoviesRealmProxyInterface) unmanagedObject).realmSet$totalPages(((TopRatedMoviesRealmProxyInterface) realmObject).realmGet$totalPages());
        return unmanagedObject;
    }

    static com.example.bajob.movieshatch.Pojo.TopRatedMovies update(Realm realm, com.example.bajob.movieshatch.Pojo.TopRatedMovies realmObject, com.example.bajob.movieshatch.Pojo.TopRatedMovies newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsList = ((TopRatedMoviesRealmProxyInterface) newObject).realmGet$results();
        RealmList<com.example.bajob.movieshatch.Pojo.MovieInfo> resultsRealmList = ((TopRatedMoviesRealmProxyInterface) realmObject).realmGet$results();
        resultsRealmList.clear();
        if (resultsList != null) {
            for (int i = 0; i < resultsList.size(); i++) {
                com.example.bajob.movieshatch.Pojo.MovieInfo resultsItem = resultsList.get(i);
                com.example.bajob.movieshatch.Pojo.MovieInfo cacheresults = (com.example.bajob.movieshatch.Pojo.MovieInfo) cache.get(resultsItem);
                if (cacheresults != null) {
                    resultsRealmList.add(cacheresults);
                } else {
                    resultsRealmList.add(MovieInfoRealmProxy.copyOrUpdate(realm, resultsList.get(i), true, cache));
                }
            }
        }
        ((TopRatedMoviesRealmProxyInterface) realmObject).realmSet$totalResults(((TopRatedMoviesRealmProxyInterface) newObject).realmGet$totalResults());
        ((TopRatedMoviesRealmProxyInterface) realmObject).realmSet$totalPages(((TopRatedMoviesRealmProxyInterface) newObject).realmGet$totalPages());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TopRatedMovies = [");
        stringBuilder.append("{page:");
        stringBuilder.append(realmGet$page() != null ? realmGet$page() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{results:");
        stringBuilder.append("RealmList<MovieInfo>[").append(realmGet$results().size()).append("]");
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
        TopRatedMoviesRealmProxy aTopRatedMovies = (TopRatedMoviesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTopRatedMovies.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTopRatedMovies.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTopRatedMovies.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
