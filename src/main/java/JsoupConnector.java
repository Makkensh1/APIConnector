import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupConnector {
    public static Document getDocument(String url) throws IOException {
        return Jsoup
                .connect(url)
                .userAgent("Chrome/103.0.0.0 Safari/537.36")
                .referrer("https://www.google.com/")
                .get();
    }
}
