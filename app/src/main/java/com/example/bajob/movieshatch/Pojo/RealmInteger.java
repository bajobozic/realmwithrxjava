package com.example.bajob.movieshatch.Pojo;

import io.realm.RealmObject;

/**
 * Created by bajob on 1/18/2017.
 */
public class RealmInteger extends RealmObject {
    private Integer value;

    public RealmInteger() {
    }

    public RealmInteger(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
