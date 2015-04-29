package net.dimkonko.vkmlj.etc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public class Url {

    private URL url;
    private Map<String, String> arguments;

    public Url(URL url) {
        this.url = url;
        arguments = new HashMap<String, String>();

        createArgumentsMap();
    }

    public Url(String url) throws MalformedURLException {
        this(new URL(url));
    }

    /**
     * Everything after ?
     * I.e. ?user=John&id=12
     */
    private void createArgumentsMap() {
        String args = null;
        if (url.getRef() != null) {
            args = url.getRef();
        } else {
            args = url.getQuery();
        }

        String[] pairs = args.split("&");;
        System.out.println("brkp");
        for (String pair : pairs) {
            String[] kwargs = pair.split("=");
            arguments.put(kwargs[0], kwargs[1].isEmpty() ? "" : kwargs[1]);
        }
    }

    public String getArgument(String key) {
        return arguments.get(key);
    }

    public String getRef() {
        return url.getRef();
    }

    public URL getUrl() {
        return url;
    }
}
