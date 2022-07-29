import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DescriptionByYahoo {

    public static String getDescriptionFromYahoo(String ticker) throws IOException {

        StringBuilder url = new StringBuilder("https://finance.yahoo.com/quote/");

        Document yahooPage = Jsoup.connect(url.append(ticker).append("/profile?p=MMM").toString())
                .userAgent("Chrome/103.0.0.0 Safari/537.36")
                .referrer("https://www.google.com/")
                .get();

        Elements description = yahooPage.select("div[class=asset-profile-container]");

        int startOfLine = description.text().indexOf("Industry:");
        int endOfLine = description.text().indexOf("Full Time Employees:");

        return description.text().substring(startOfLine,endOfLine);

    }
}
