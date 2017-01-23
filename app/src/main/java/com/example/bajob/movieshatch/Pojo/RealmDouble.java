package com.example.bajob.movieshatch.Pojo;

import io.realm.RealmObject;

/**
 * Created by bajob on 1/19/2017.
 */
public class RealmDouble extends RealmObject{
    private Double value;

    public RealmDouble() {

    }

    public RealmDouble(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
