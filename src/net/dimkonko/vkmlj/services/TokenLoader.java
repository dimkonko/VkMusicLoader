package net.dimkonko.vkmlj.services;

import net.dimkonko.vkmlj.etc.MapperUtils;
import net.dimkonko.vkmlj.models.User;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dima Karacheban on 30.04.2015.
 */
public class TokenLoader {

    private final File tokenFile;

    public TokenLoader(String tokenPath) {
        this.tokenFile =  new File(tokenPath);
    }

    public boolean isTokenExists() {
        boolean isExists = false;
        try {
            isExists = !tokenFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isExists;
    }

    public void save(User user) {
        MapperUtils.saveFile(tokenFile, user);
    }

    public User loadToken() {
        return (User) MapperUtils.readFromFile(tokenFile, User.class);
    }
}
