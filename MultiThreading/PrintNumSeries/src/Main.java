public class Main {
    public static void main(String[] args) {
        PrintNumSeries obj = new PrintNumSeries(5);
        Thread t1 = new PrintNumSeriesThread(obj,"zero");
        Thread t2 = new PrintNumSeriesThread(obj,"even");
        Thread t3 = new PrintNumSeriesThread(obj,"odd");

        t2.start();
        t3.start();
        t1.start();

    }
}