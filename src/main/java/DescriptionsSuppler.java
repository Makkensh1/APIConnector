import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DescriptionsSuppler {

    public static String getDescriptions() {

        CompanyNameExtractor.getTickers();
        StringBuilder result = new StringBuilder();
        result.append(CompanyNameExtractor.compName.getFirst()).append(" ");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> yahooDescr = executorService.submit(new YahooDescriptionExtractor());
        Future<String> indeedDescr = executorService.submit(new IndeedDescriptionExtractor());

            try {
                result.append(yahooDescr.get())
                        .append(" ")
                        .append(indeedDescr.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }finally {
                executorService.shutdown();
            }

        return result.toString();
    }
}


