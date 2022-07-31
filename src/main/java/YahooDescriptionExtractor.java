import java.io.IOException;

public class YahooDescriptionExtractor {

    public static String getDescriptionFromYahoo(String ticker) throws IOException {
        String url = String.format("https://finance.yahoo.com/quote/%s/profile?p=MMM", ticker);
        String description = JsoupConnector.getDocument(url).select("div[class=asset-profile-container]").text();
        int startOfLine = description.indexOf("Industry:");
        int endOfLine = description.indexOf("Full Time Employees:");
        return description.substring(startOfLine, endOfLine);
    }
}
