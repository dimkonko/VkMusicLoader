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

    public static AudioModel createAudio(String json) {
        return (AudioModel) MapperUtils.parse(json, AudioModel.class);
    }
}
