package net.dimkonko.vkmlj.etc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Dima Karacheban on 30.04.2015.
 */
public class UrlBuilder {

    public static String create(String head, List<String> args) {
        String urlStr = head.concat("?").concat(args.get(0));
        for (int i = 1; i < args.size(); i++) {
            urlStr = urlStr.concat("&").concat(args.get(i));
        }
        return urlStr;
    }
}
