import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class DescriptionSuppler {

    public static String getDescription(int quantity) throws IOException {
        int index = 1;
        Map<String, String> tickers = Extractor.getTicker();
        StringBuilder result = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = tickers.entrySet().iterator();
        while (index <= quantity && iterator.hasNext()) {
            Map.Entry<String, String > entry = iterator.next();
            result.append(index++)
                    .append(". ")
                    .append(entry.getValue())
                    .append(" ")
                    .append(DescriptionByYahoo.getDescriptionFromYahoo(entry.getKey()))
                    .append("and ")
                    .append(DescriptionByIndeed.getDescriptionFromIndeed(entry.getValue()))
                    .append("\n");
        }
        return result.toString();
    }


}


