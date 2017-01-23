package com.example.bajob.movieshatch.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;

/**
 * Created by bajob on 1/19/2017.
 */
public class MovieDbImages {
    @SerializedName("base_url")
    @Expose
    private String baseUrl;
    @SerializedName("secure_base_url")
    @Expose
    private String secureBaseUrl;
    @SerializedName("backdrop_sizes")
    @Expose
    private RealmList<RealmString> backdropSizes = null;
    @SerializedName("logo_sizes")
    @Expose
    private RealmList<RealmString> logoSizes = null;
    @SerializedName("poster_sizes")
    @Expose
    private RealmList<RealmString> posterSizes = null;
    @SerializedName("profile_sizes")
    @Expose
    private RealmList<RealmString> profileSizes = null;
    @SerializedName("still_sizes")
    @Expose
    private RealmList<RealmString> stillSizes = null;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getSecureBaseUrl() {
        return secureBaseUrl;
    }

    public void setSecureBaseUrl(String secureBaseUrl) {
        this.secureBaseUrl = secureBaseUrl;
    }

    public RealmList<RealmString> getBackdropSizes() {
        return backdropSizes;
    }

    public void setBackdropSizes(RealmList<RealmString> backdropSizes) {
        this.backdropSizes = backdropSizes;
    }

    public RealmList<RealmString> getLogoSizes() {
        return logoSizes;
    }

    public void setLogoSizes(RealmList<RealmString> logoSizes) {
        this.logoSizes = logoSizes;
    }

    public RealmList<RealmString> getPosterSizes() {
        return posterSizes;
    }

    public void setPosterSizes(RealmList<RealmString> posterSizes) {
        this.posterSizes = posterSizes;
    }

    public RealmList<RealmString> getProfileSizes() {
        return profileSizes;
    }

    public void setProfileSizes(RealmList<RealmString> profileSizes) {
        this.profileSizes = profileSizes;
    }

    public RealmList<RealmString> getStillSizes() {
        return stillSizes;
    }

    public void setStillSizes(RealmList<RealmString> stillSizes) {
        this.stillSizes = stillSizes;
    }
}
