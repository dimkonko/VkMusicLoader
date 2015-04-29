package net.dimkonko.vkmlj.controllers;

import net.dimkonko.vkmlj.Main;
import net.dimkonko.vkmlj.OnlineApp;
import net.dimkonko.vkmlj.etc.Url;
import net.dimkonko.vkmlj.etc.UserFactory;
import net.dimkonko.vkmlj.etc.VKAuth;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable, SharedApp, Changeable {

    private OnlineApp app;
    private WebEngine webEngine;

    @FXML
    private WebView webView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webView.getEngine();
        webEngine.load(new VKAuth("4585679").getAuthUrl());

        webEngine.getLoadWorker().stateProperty().addListener(new WebStatusListener());

    }

    @Override
    public void setApp(OnlineApp app) {
        this.app = app;
    }

    @Override
    public void beforeChange() {
    }

    private void processUrl(String url) {
        Url curUrl = null;
        try {
            curUrl = new Url(webEngine.getLocation());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (curUrl.getRef() != null) {
            app.login(UserFactory.createUser(curUrl));
        }
    }

    private void changeScene() throws IOException {
        Parent musicViewParent = FXMLLoader.load(getClass().getResource("../net/dimkonko/vkmlj/views/musicView.fxml"));
        Scene musicViewScene = new Scene(musicViewParent);
    }

    class WebStatusListener implements ChangeListener<Worker.State> {

        @Override
        public void changed (
                ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
            System.out.println("Load" + observableValue.getValue());
            if (newState == Worker.State.SUCCEEDED) {
                processUrl(webEngine.getLocation());
            }
        }
    }
}
