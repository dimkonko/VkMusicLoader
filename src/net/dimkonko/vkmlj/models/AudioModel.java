package net.dimkonko.vkmlj.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Dima Karacheban on 30.04.2015.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AudioModel {

    @JsonProperty("aid")
    private String aid;

    @JsonProperty("owner_id")
    private String ownerId;

    @JsonProperty("artist")
    private String artist;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("duration")
    private String duration;

    @Override
    public String toString() {
        return artist + " - " + title;
    }

    public String getAid() {
        return aid;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDuration() {
        return duration;
    }
}
