package pl.creator.currencytoexcel.connect;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@FunctionalInterface
public interface UrlConnection {

    String url ();

    static URL setURLToOpenConnection(String url) throws MalformedURLException {
        return new URL(url);
    }

    static URLConnection openConnection(URL url) throws IOException {
        return url.openConnection();
    }
}
