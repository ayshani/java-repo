public class Main {
    public static void main(String[] args) {

        MultithreadedFizzBuzz obj = new MultithreadedFizzBuzz(46);

        FizzBuzzThread t1 = new FizzBuzzThread(obj,"fizz");
        FizzBuzzThread t2 = new FizzBuzzThread(obj,"buzz");
        FizzBuzzThread t3 = new FizzBuzzThread(obj,"fizzbuzz");
        FizzBuzzThread t4 = new FizzBuzzThread(obj,"num");

        t2.start();
        t1.start();
        t4.start();
        t3.start();
    }
}