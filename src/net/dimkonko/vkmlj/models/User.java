package net.dimkonko.vkmlj.models;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public class User {

    private final String accessToken;
    private final String userId;

    public User(String accessToken, String userId) {
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
