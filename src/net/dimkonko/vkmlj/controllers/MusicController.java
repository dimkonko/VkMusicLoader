package net.dimkonko.vkmlj.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import net.dimkonko.vkmlj.OnlineApp;
import net.dimkonko.vkmlj.Service.AudioLoader;
import net.dimkonko.vkmlj.etc.AudioDataAccessor;
import net.dimkonko.vkmlj.etc.VkAudioAPI;
import net.dimkonko.vkmlj.models.AudioModel;
import net.dimkonko.vkmlj.models.User;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public class MusicController implements Initializable, SharedApp, Changeable {

    private VkAudioAPI api;
    private AudioDataAccessor data;
    private AudioLoader audioLoader;

    private OnlineApp app;

    @FXML
    private ListView<String> musicView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        api = new VkAudioAPI();
        data = new AudioDataAccessor();
        audioLoader = new AudioLoader("Downloads/");

        musicView.setOnMouseClicked(new DoubleClickHandler());
    }

    @Override
    public void setApp(OnlineApp app) {
        this.app = app;
    }

    @Override
    public void beforeChange() {
        User user = app.getUser();
        String jsonResponse = api.getAudioList(user.getUserId(), user.getAccessToken());
        List<String> audioList = data.getAudio(jsonResponse);
        musicView.setItems(FXCollections.observableArrayList(audioList));

    }

    class DoubleClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getClickCount() == 2) {
                System.out.println("Click");
                ObservableList<String> selectedItem = musicView.getSelectionModel().getSelectedItems();
                List<AudioModel> audioList = data.getAudioModels(selectedItem);

                for (AudioModel model : audioList) {
                    audioLoader.loadAudio(model);
                }
            }
        }
    }
}
