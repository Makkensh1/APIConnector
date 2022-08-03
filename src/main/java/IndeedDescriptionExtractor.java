import java.util.concurrent.Callable;

public class IndeedDescriptionExtractor implements Callable {


    @Override
    public String call() throws Exception {

        final String DESCRIPTION_START_LINE = "Industry ";
        String url = String.format("https://www.indeed.com/cmp/%s", CompanyNameExtractor.compName.pop());
        String description = JsoupConnector.getDocument(url).select("li[data-testid=companyInfo-industry]").text();
        return description.substring(description.indexOf(DESCRIPTION_START_LINE) + DESCRIPTION_START_LINE.length());
    }
}
