import java.util.concurrent.Callable;

public class YahooDescriptionExtractor implements Callable {

    @Override
    public String call() throws Exception {
        String url = String.format("https://finance.yahoo.com/quote/%s/profile?p=MMM", CompanyNameExtractor.compTicker.pop());
        String description = JsoupConnector.getDocument(url).select("div[class=asset-profile-container]").text();
        int startOfLine = description.indexOf("Industry:");
        int endOfLine = description.indexOf("Full Time Employees:");
        return description.substring(startOfLine, endOfLine);
    }
}
