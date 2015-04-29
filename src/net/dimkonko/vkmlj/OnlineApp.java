package net.dimkonko.vkmlj;

import net.dimkonko.vkmlj.models.User;
import net.dimkonko.vkmlj.scene.SceneType;

/**
 * Created by Dima Karacheban on 30.04.2015.
 */
public interface OnlineApp {
    void changeScene(SceneType sceneType);
    void login(User user);
    void logout();
    User getUser();
}
