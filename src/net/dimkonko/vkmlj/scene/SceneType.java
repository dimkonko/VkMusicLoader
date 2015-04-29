package net.dimkonko.vkmlj.scene;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public enum SceneType {
    LOGIN("loginView.fxml"),
    MUSIC_VIEW("musicView.fxml");

    private final String fxmlFileName;

    SceneType(String fxmlFileName) {
        this.fxmlFileName = fxmlFileName;
    }

    public String getFxmlFileName() {
        return fxmlFileName;
    }
}
