import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println(DescriptionsSuppler.getDescriptions(50));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}