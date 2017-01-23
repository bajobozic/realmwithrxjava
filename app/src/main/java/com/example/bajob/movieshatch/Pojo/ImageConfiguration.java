package com.example.bajob.movieshatch.Pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;

/**
 * Created by bajob on 1/19/2017.
 */
public class ImageConfiguration {
    @SerializedName("images")
    @Expose
    private MovieDbImages images;
    @SerializedName("change_keys")
    @Expose
    private RealmList<RealmString> changeKeys = null;

    public MovieDbImages getImages() {
        return images;
    }

    public void setImages(MovieDbImages images) {
        this.images = images;
    }

    public RealmList<RealmString> getChangeKeys() {
        return changeKeys;
    }

    public void setChangeKeys(RealmList<RealmString> changeKeys) {
        this.changeKeys = changeKeys;
    }
}
