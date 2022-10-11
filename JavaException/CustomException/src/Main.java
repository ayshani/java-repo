public class Main {
    public static void main(String[] args) {

        User u1 = new User("abc",12);
        User u2 = new User("abc",19);
        User u3 = new User("abc",5);

        Service service = new Service();

        try{
            service.checkService(u1);
            service.checkService(u2);
            service.checkService(u3);
        } catch(AgeLimitException e){
            System.out.println("AgeLimitException caught");
        }
        System.out.println("Hello world!");
    }
}