package reflection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReflectionMain1 {

    private static interface Drawable{
        int getNumberOfCorners();
    }

    private enum Color{
        RED, BLUE, GREEN;
    }

    private class Square implements Drawable{

        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }
    private static void printClassInfo(Class<?> ... classes){

        for (Class<?> aClass : classes) {
            System.out.println(String.format("className : %s, package : %s", aClass.getSimpleName(),
                    aClass.getPackageName()));
            Class<?> [] implementedInterfaces = aClass.getInterfaces();
            for (Class<?> aInterface : implementedInterfaces) {
                System.out.println(String.format("className : %s implements interface : %s", aClass.getSimpleName(),
                        aInterface.getSimpleName()));
            }

            System.out.println("Is array : "+ aClass.isArray());
            System.out.println("Is primitive : "+ aClass.isPrimitive());
            System.out.println("Is Interface : "+ aClass.isInterface());
            System.out.println("Is Anonymous : "+ aClass.isAnonymousClass());
            System.out.println("Is Is Enum : "+ aClass.isEnum());
            System.out.println();
            System.out.println();

        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Hello world!");

        Class<String> stringObj = String.class;
        Map<String, Integer> mapObj = new HashMap<>();
        Class<?> hashMapClass = mapObj.getClass();
        Class<?> squareClass = Class.forName("reflection.ReflectionMain1$Square");
        var circleObjectAnonymous = new Drawable(){

            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };
        //printClassInfo(stringObj,hashMapClass,squareClass);
        printClassInfo(boolean.class, int[][].class, Collections.class, Color.class, circleObjectAnonymous.getClass());
    }
}