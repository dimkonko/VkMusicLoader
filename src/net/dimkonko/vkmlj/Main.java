package net.dimkonko.vkmlj;

import javafx.application.Application;
import javafx.stage.Stage;
import net.dimkonko.vkmlj.models.User;
import net.dimkonko.vkmlj.scene.ControllableScene;
import net.dimkonko.vkmlj.scene.SceneAccessor;
import net.dimkonko.vkmlj.scene.SceneType;

public class Main extends Application implements OnlineApp {

    private SceneAccessor sceneAccessor;
    private Stage primaryStage;
    private User user;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        sceneAccessor = SceneAccessor.getInstance();

        SceneType[] scenes = SceneType.values();
        for (SceneType sceneType : scenes) {
            sceneAccessor.loadScreen(sceneType, sceneType.getFxmlFileName()).setApp(this);
        }
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(sceneAccessor.getScene(SceneType.LOGIN));
        primaryStage.show();
    }

    @Override
    public void changeScene(SceneType sceneType) {
        ControllableScene scene = sceneAccessor.getScene(sceneType);
        scene.getController().beforeChange();
        this.primaryStage.setScene(scene);
    }

    public void login(User user) {
        this.user = user;
        changeScene(SceneType.MUSIC_VIEW);
    }

    @Override
    public void logout() {
        this.user = null;
        changeScene(SceneType.LOGIN);
    }

    @Override
    public User getUser() {
        return user;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
