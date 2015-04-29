package net.dimkonko.vkmlj.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import net.dimkonko.vkmlj.OnlineApp;
import net.dimkonko.vkmlj.etc.VkAPI;
import net.dimkonko.vkmlj.models.User;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public class MusicController implements Initializable, SharedApp, Changeable {

    private VkAPI api;
    private OnlineApp app;

    @FXML
    private ListView<String> musicView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        api = new VkAPI();
//        musicView.setItems();
    }

    @Override
    public void setApp(OnlineApp app) {
        this.app = app;
    }

    @Override
    public void beforeChange() {
        User user = app.getUser();
        api.call("audio.get",
                Arrays.asList("owner_id=".concat(user.getUserId()), "access_token=".concat(user.getAccessToken())));
    }
}
