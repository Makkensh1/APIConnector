import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CompanyNameExtractor {

    private static final String EXTRACTOR_HOST = "https://en.wikipedia.org/wiki/S%26P_100";

    public static Map<String, String> getTickers() {
        Map<String, String> companyNameAndTicker = new HashMap<>();
        try {
            Elements tableOfCompanies = JsoupConnector.getDocument(EXTRACTOR_HOST).select("table[id=constituents]");
            Elements tableRowElements = tableOfCompanies.select(":not(thead) tr");

            for (int i = 1; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                Elements rowItems = row.select("td");
                for (int j = 0; j < 1; j++) {
                    companyNameAndTicker.put(rowItems.get(j).text(), rowItems.get(j + 1).text());
                }
            }
            return companyNameAndTicker;
        } catch (IOException e) {
            return companyNameAndTicker;
        }
    }

}
