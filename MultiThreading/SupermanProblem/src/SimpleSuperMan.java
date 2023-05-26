/*
What if the no one likes Superman and instead creates Batman in the game. You just created Superman and he kept
waiting without ever being called upon to save the world. It's a waste of Superman's time and also the memory and
other resources he'll consume.
 */
public class SimpleSuperMan {

    private static SimpleSuperMan superMan= new SimpleSuperMan();
    private SimpleSuperMan(){
    }

    public static  SimpleSuperMan getInstance(){
        return superMan;
    }

    // Object method
    public void fly() {
        System.out.println("I am Superman & I can fly !");
    }
}
