package com.example.bajob.movieshatch.Pojo;

import io.realm.RealmObject;

/**
 * Created by bajob on 1/18/2017.
 */
public class RealmString extends RealmObject{
    private String value;

    public RealmString() {
    }

    public RealmString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
