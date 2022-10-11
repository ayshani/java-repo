public class Service {

    public void checkService(User u) throws AgeLimitException {
        if(u.getAge()<18){
            throw new AgeLimitException(u.getName() +" hase age lesss than 18");
        } else{
            System.out.println("Service availed");
        }
    }
}
