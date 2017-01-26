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
    private String changeKeys;

    public String getChangeKeys() {
        return changeKeys;
    }

    public void setChangeKeys(String changeKeys) {
        this.changeKeys = changeKeys;
    }

    public MovieDbImages getImages() {
        return images;
    }

    public void setImages(MovieDbImages images) {
        this.images = images;
    }


}
