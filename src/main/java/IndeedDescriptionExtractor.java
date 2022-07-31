import java.io.IOException;

public class IndeedDescriptionExtractor {

    public static String getDescriptionFromIndeed(String name) throws IOException {

        final String DESCRIPTION_START_LINE = "Industry ";
        String url = String.format("https://www.indeed.com/cmp/%s", name);
        String description = JsoupConnector.getDocument(url).select("li[data-testid=companyInfo-industry]").text();
        return description.substring(description.indexOf(DESCRIPTION_START_LINE) + DESCRIPTION_START_LINE.length());
    }
}
