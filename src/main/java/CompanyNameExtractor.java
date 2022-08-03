import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CompanyNameExtractor {
    private static final String EXTRACTOR_HOST = "https://en.wikipedia.org/wiki/S%26P_100";
    public static final ConcurrentLinkedDeque<String> compName = new ConcurrentLinkedDeque<>();
    public static final ConcurrentLinkedDeque<String> compTicker = new ConcurrentLinkedDeque<>();

    public static void getTickers() {
        try {
            Elements tableOfCompanies = JsoupConnector.getDocument(EXTRACTOR_HOST).select("table[id=constituents]");
            Elements tableRowElements = tableOfCompanies.select(":not(thead) tr");
            for (int i = 1; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                Elements rowItems = row.select("td");
                for (int j = 0; j < 1; j++) {
                    compName.add(correctCompanyName(rowItems.get(j + 1).text()));
                    compTicker.add(correctTicker(rowItems.get(j).text()));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String correctTicker(String str) {
        String result = str;
        if (str.contains(".")) {
            result = str.replace(".", "-");
        }
        return result;
    }

    public static String correctCompanyName(String name) {
        String result = name;
        if (name.contains("(")) {
            result = name.substring(0, name.indexOf("(")).trim();
        }
        return result;
    }
}
