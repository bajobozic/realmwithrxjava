package com.example.bajob.movieshatch.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by bajob on 1/18/2017.
 */
public class ProductionCompany extends RealmObject{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
