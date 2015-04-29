package net.dimkonko.vkmlj.etc;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.dimkonko.vkmlj.models.Audio;

import java.io.IOException;

/**
 * Created by Dima Karacheban on 30.04.2015.
 */
public class AudioFactory {

    public static final ObjectMapper MAPPER = createMapper();

    public static Audio createAudio(String json) {
        Audio audio = null;
        try {
            MAPPER.readValue(json, Audio.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return audio;
    }

    private static ObjectMapper createMapper() {
        return new ObjectMapper();
    }
}
