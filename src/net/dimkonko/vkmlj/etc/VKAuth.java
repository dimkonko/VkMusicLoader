package net.dimkonko.vkmlj.etc;

/**
 * Class to create OAUTH2 link
 */
public class VKAuth {

    private static final String REDIRECT_URL = "http://oauth.vk.com/blank.html";
    private static final String OAUTH_URL_PATTERN = "https://oauth.vk.com/authorize?" +
            "client_id=appId&" +
            "scope=audio&" +
            "redirect_uri=" + REDIRECT_URL + "&" +
            "display=popup&" +
            "v=5.30&" +
            "response_type=token";

    private final String appId;
    private final String oauthUrl;

    public VKAuth(String appId) {
        this.appId = appId;

        oauthUrl = OAUTH_URL_PATTERN.replace("appId", appId);
    }

    public String getAuthUrl() {
        return oauthUrl;
    }

    public String getAppId() {
        return appId;
    }
}
