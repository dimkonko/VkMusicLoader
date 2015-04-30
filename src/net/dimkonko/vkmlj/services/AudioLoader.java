package net.dimkonko.vkmlj.services;

import net.dimkonko.vkmlj.models.AudioModel;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * services, which responsible for download songs from internet
 */
public class AudioLoader {

    public AudioLoader(String savePath) {
        new File(savePath).mkdir();
    }

    public void loadAudio(AudioModel audioModel) {
        URLConnection conn;
        InputStream is = null;
        try {
            conn = new URL(audioModel.getUrl()).openConnection();
            is = conn.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File audioFile = new File("Downloads/" + audioModel.toString() + ".mp3");
            if (!audioFile.exists()) {
                OutputStream outstream = new FileOutputStream(audioFile);
                byte[] buffer = new byte[4096];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    outstream.write(buffer, 0, len);
                }
                outstream.close();
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
