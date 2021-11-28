package pl.creator.currencytoexcel.connect;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebClient {
    private static URL basicUrl;
    private static URLConnection urlConnection;

    public static URL setURL (String url) throws MalformedURLException {
        try {
            basicUrl = new URL(url);
            return basicUrl;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        throw new MalformedURLException();
    }

    public static URLConnection openConnection (URL url) throws MalformedURLException {
        try {
            url = new URL(url.getPath());
            return url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new MalformedURLException();
    }
}
