package com.example.bajob.movieshatch.Pojo;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

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
    private String backdropSizes = null;
    @SerializedName("logo_sizes")
    @Expose
    private String logoSizes = null;
    @SerializedName("poster_sizes")
    @Expose
    private String posterSizes = null;
    @SerializedName("profile_sizes")
    @Expose
    private String profileSizes = null;
    @SerializedName("still_sizes")
    @Expose
    private String stillSizes = null;

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

    public List<String> getBackdropSizes() {
        return Arrays.asList(TextUtils.split(backdropSizes, ", "));
    }

    public void setBackdropSizes(List<String> backdropSizes) {
        this.backdropSizes = TextUtils.join(", ",backdropSizes);
    }

    public List<String> getLogoSizes() {
        return Arrays.asList(TextUtils.split(logoSizes, ", "));
    }

    public void setLogoSizes(List<String> logoSizes) {
        this.logoSizes = TextUtils.join(", ",logoSizes);
    }

    public List<String> getPosterSizes() {
        return Arrays.asList(TextUtils.split(posterSizes, ", "));
    }

    public void setPosterSizes(List<String> posterSizes) {
        this.posterSizes = TextUtils.join(", ",posterSizes);
    }

    public List<String> getProfileSizes() {
        return Arrays.asList(TextUtils.split(profileSizes, ", "));
    }

    public void setProfileSizes(List<String> profileSizes) {
        this.profileSizes = TextUtils.join(", ",profileSizes);
    }

    public List<String> getStillSizes() {
        return Arrays.asList(TextUtils.split(stillSizes, ", "));
    }

    public void setStillSizes(List<String> stillSizes) {
        this.stillSizes = TextUtils.join(", ",stillSizes);
    }
}
