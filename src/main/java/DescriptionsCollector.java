public class DescriptionsCollector {
    public static String accumulateDescriptions(int quantity) {
        int counter = 1;
        StringBuilder description = new StringBuilder();
        while (counter <= quantity) {
            description
                    .append(counter++)
                    .append(" ")
                    .append(DescriptionsSuppler.getDescriptions())
                    .append("\n");
        }
        return description.toString();
    }
}
