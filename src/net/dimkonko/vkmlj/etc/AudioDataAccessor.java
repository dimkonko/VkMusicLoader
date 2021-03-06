package net.dimkonko.vkmlj.etc;

import net.dimkonko.vkmlj.models.AudioModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dima Karacheban on 30.04.2015.
 */
public class AudioDataAccessor {

    private Map<String, AudioModel> audios;

    public AudioDataAccessor() {
        audios = new HashMap<String, AudioModel>();
    }

    public List<String> getAudio(String json) {
        List<String> audioList = new ArrayList<String>();

        try {
            JSONObject jsonResult = new JSONObject(json);
            JSONArray jsonAudioList = jsonResult.getJSONArray("response");
            jsonAudioList.remove(0);

            for (int i = 0; i < jsonAudioList.length(); i++) {
                AudioModel audio = AudioFactory.createAudio(jsonAudioList.getJSONObject(i).toString());

                if (audio != null) {
                    this.audios.put(audio.toString(), audio);
                    audioList.add(audio.toString());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return audioList;
    }

    /**
     * This makes List<AudioModel> from song names
     * @param songNames
     * @return
     */
    public List<AudioModel> getAudioModels(List<String> songNames) {
        List<AudioModel> audioList = new ArrayList<AudioModel>();

        for (String songName : songNames) {
            if (audios.containsKey(songName)) {
                audioList.add(audios.get(songName));
            }
        }
        return audioList;
    }
}
