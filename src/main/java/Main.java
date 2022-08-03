public class Main {
    public static void main(String[] args) {

        System.out.println(DescriptionsCollector.accumulateDescriptions(50));

        //todo разбить цикл на 50 потоков не получилось, сайт indeed начинает блокировать запросы тк считает что на него совершают ddos атаку
    }
}

