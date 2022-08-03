import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class JsoupConnector {
    public static Document getDocument(String stringURL) throws IOException {
        URL url = new URL(stringURL);
//        return Jsoup
//                .connect(url)
//                .userAgent("Chrome/103.0.0.0 Safari/537.36")
//                .referrer("https://www.google.com/")
//                .get();
        return Jsoup.
                parse(url,15000 );
    }
}
