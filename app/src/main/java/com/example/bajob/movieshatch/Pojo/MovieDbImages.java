package com.example.bajob.movieshatch.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    public String getBackdropSizes() {
        return backdropSizes;
    }

    public void setBackdropSizes(String backdropSizes) {
        this.backdropSizes = backdropSizes;
    }

    public String getLogoSizes() {
        return logoSizes;
    }

    public void setLogoSizes(String logoSizes) {
        this.logoSizes = logoSizes;
    }

    public String getPosterSizes() {
        return posterSizes;
    }

    public void setPosterSizes(String posterSizes) {
        this.posterSizes = posterSizes;
    }

    public String getProfileSizes() {
        return profileSizes;
    }

    public void setProfileSizes(String profileSizes) {
        this.profileSizes = profileSizes;
    }

    public String getStillSizes() {
        return stillSizes;
    }

    public void setStillSizes(String stillSizes) {
        this.stillSizes = stillSizes;
    }
}
