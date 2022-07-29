import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DescriptionByIndeed {

    public static String getDescriptionFromIndeed(String name) throws IOException {

        StringBuilder url = new StringBuilder("https://www.indeed.com/cmp/");

        Document indeedPage = Jsoup.connect(url.append(name).toString())
                .userAgent("Chrome/103.0.0.0 Safari/537.36")
                .referrer("https://www.google.com/")
                .get();

        Elements description = indeedPage.select("li[data-testid=companyInfo-industry]");

        int startOfLine = description.text().indexOf("Industry ");


        return description.text().substring(startOfLine+9);

    }
}
