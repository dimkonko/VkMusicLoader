package net.dimkonko.vkmlj.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import net.dimkonko.vkmlj.controllers.Changeable;
import net.dimkonko.vkmlj.controllers.SharedApp;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public class SceneAccessor {

    private static SceneAccessor INSTANCE;

    private Map<SceneType, ControllableScene> scenes;

    public SceneAccessor() {
        this.scenes = new EnumMap<SceneType, ControllableScene>(SceneType.class);
    }

    public void addScene(SceneType key, ControllableScene scene) {
        this.scenes.put(key, scene);
    }

    public ControllableScene getScene(SceneType key) {
        return scenes.get(key);
    }

    /**
     * Create scene and add it to scenes map
     * @param sceneType
     * @param fxmlFileName
     * @return {@link SharedApp}, to setup app to this controller
     */
    public SharedApp loadScreen(SceneType sceneType, String fxmlFileName) {
        SharedApp controller = null;
        try {
            System.out.println("Loading " + fxmlFileName);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/" + fxmlFileName));
            Parent parent = (Parent) loader.load();
            this.addScene(sceneType, new ControllableScene(parent, (Changeable) loader.getController()));
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller;
    }

    public static SceneAccessor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SceneAccessor();
        }
        return INSTANCE;
    }
}
