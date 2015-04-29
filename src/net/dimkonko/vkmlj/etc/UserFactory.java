package net.dimkonko.vkmlj.etc;

import net.dimkonko.vkmlj.models.User;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public class UserFactory {

    public static User createUser(Url params) {
        return new User(params.getArgument("access_token"), params.getArgument("user_id"));
    }
}
