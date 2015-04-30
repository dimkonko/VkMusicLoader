package net.dimkonko.vkmlj.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public class User {

    private final String accessToken;
    private final String userId;

    @JsonCreator
    public User(@JsonProperty("access_token") String accessToken, @JsonProperty("user_id") String userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
