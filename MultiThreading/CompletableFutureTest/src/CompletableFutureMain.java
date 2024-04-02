import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Person person = new Person("Ram");
        CompletableFutureMain obj =  new CompletableFutureMain();
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        CompletableFuture<String> name  = completableFuture.supplyAsync(() -> obj.getName(person));

        System.out.println(name.get());
    }

    public String getName(Person person){
        return person.name;
    }
}

class Person{
    String name;
    public Person(String name){
        this.name  = name;
    }

}