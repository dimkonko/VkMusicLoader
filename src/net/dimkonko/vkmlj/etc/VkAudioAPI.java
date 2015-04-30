package net.dimkonko.vkmlj.etc;

import java.util.Arrays;

/**
 * Created by dkarach on 4/30/15.
 */
public class VkAudioAPI extends VkAPI {

    private static final String AUDIO_GET= "audio.get";

    public String getAudioList(String ownerId, String accessToken) {
        return this.call(AUDIO_GET, Arrays.asList("owner_id=".concat(ownerId), "access_token=".concat(accessToken)));
    }
}
