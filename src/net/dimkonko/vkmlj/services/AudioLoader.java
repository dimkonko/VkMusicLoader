package net.dimkonko.vkmlj.services;

import net.dimkonko.vkmlj.models.AudioModel;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * services, which responsible for download songs from internet
 */
public class AudioLoader {

    List<Runnable> threadList;

    public AudioLoader(String savePath) {
        new File(savePath).mkdir();
        threadList = new ArrayList<Runnable>();
    }

    public void loadAudio(AudioModel audioModel) {
        AudioLoaderThread thread = new AudioLoaderThread();
        thread.start(audioModel);
    }

    class AudioLoaderThread implements Runnable {

        private AudioModel audioModel;
        private Thread thread;

        public void start(AudioModel audioModel) {
            this.audioModel = audioModel;
            this.thread = new Thread(this, audioModel.getAid());
            thread.start();
        }

        @Override
        public void run() {
            System.out.println("Started thread: " + audioModel.getTitle());
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
            System.out.println("Thread: " + audioModel.getTitle() + " exiting");
        }
    }
}
