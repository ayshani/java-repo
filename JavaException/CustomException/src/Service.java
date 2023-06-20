public class Service {

    public void checkService(User u) throws AgeLimitException {
        if(u.getAge()<18){
            throw new AgeLimitException(u.getName() +" hase age lesss than 18");
        } else{
            System.out.println("Service availed");
        }
    }

    public int checkServiceFinally(User u) throws AgeLimitException {
        try{
            if(u.getAge()<18){
                throw new AgeLimitException(u.getName() +" hase age lesss than 18");
            } else{
                System.out.println("Service availed");
                return 12;
            }
        } catch(AgeLimitException e){
            System.out.println("Catch availed");
            return 13;
        } finally {
            System.out.println("Finally availed");
            return 14;
        }

    }

    public int checkServiceFinallyException(User u) throws AgeLimitException {
        try{
            if(u.getAge()<18){
                throw new AgeLimitException(u.getName() +" hase age lesss than 18");
            } else{
                System.out.println("Service availed");
                u.setAge(20);
                return 12;
            }

        } catch(AgeLimitException e){
            System.out.println("Catch availed");
            return 13;
        } finally {
            System.out.println("Finally availed");
            if(u.getAge()>18){
                throw new AgeLimitException(u.getName() +" hase age lesss than 18");
            }
            return 14;
        }

    }
}
