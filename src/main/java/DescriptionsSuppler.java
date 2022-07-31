import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class DescriptionsSuppler {

    public static String getDescriptions(int quantity) throws IOException {
        int index = 1;
        Map<String, String> tickers = CompanyNameExtractor.getTickers();
        if (quantity <0 || quantity > tickers.size()) {
            throw new RuntimeException("number must be between 0 and 100");
        }
        StringBuilder result = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = tickers.entrySet().iterator();
        while (index <= quantity && iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            result
                    .append(index++)
                    .append(". ")
                    .append(entry.getValue())
                    .append(" ")
                    .append(YahooDescriptionExtractor.getDescriptionFromYahoo(entry.getKey()))
                    .append("and ")
                    .append(IndeedDescriptionExtractor.getDescriptionFromIndeed(entry.getValue()))
                    .append("\n");
        }
        return result.toString();
    }
}


