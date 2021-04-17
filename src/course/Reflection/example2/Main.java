package course.Reflection.example2;

import com.sber.reflection.MyClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = null;
        MyClass myClass2 = null;
        try {
            Class clazz = Class.forName(MyClass.class.getName());
            myClass = (MyClass) clazz.getDeclaredConstructor().newInstance();

            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                if (constructor.getParameterCount()==2){
                    constructor.setAccessible(true);
                    myClass2 = (MyClass) constructor.newInstance(45,"Hello");
                }

                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");

                }
                System.out.println();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);//output created object reflection.MyClass@60e53b93
        System.out.println(myClass2);


    }
}
