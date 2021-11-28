package pl.creator.currencytoexcel.connect;

import lombok.Getter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Getter
public class WebClient {
    private static URL basicUrl;
    private static URLConnection urlConnection;

    public static URL setURL (String url) throws MalformedURLException {
        try {
            basicUrl = new URL(url);
            return basicUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new MalformedURLException();
    }

    public static URLConnection openConnection (URL url) throws MalformedURLException {
        try {
            urlConnection = basicUrl.openConnection();
            return urlConnection;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new MalformedURLException();
    }
}
