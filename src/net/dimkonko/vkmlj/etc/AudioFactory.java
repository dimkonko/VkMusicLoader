package net.dimkonko.vkmlj.etc;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.dimkonko.vkmlj.models.AudioModel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Dima Karacheban on 30.04.2015.
 */
public class AudioFactory {

    public static final ObjectMapper MAPPER = createMapper();

    public static AudioModel createAudio(String json) {
        AudioModel audio = null;
        try {
            audio = MAPPER.readValue(json, AudioModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return audio;

    }

    private static ObjectMapper createMapper() {
        return new ObjectMapper();
    }
}
