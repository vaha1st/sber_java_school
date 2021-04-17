package course.homeworks.hw7;

//Задание на завтра поломать концепцию инкапсуляции и патерн синглтон с помощью рефлексии у класса
// LazyInitializedSingleton

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BreakSingleton {
    public static void main(String[] args) throws NoSuchMethodException {
        LazyInitializedSingleton singleton = LazyInitializedSingleton.getInstance();
        System.out.println("Initialize singleton");
        LazyInitializedSingleton singleton2 = LazyInitializedSingleton.getInstance();
        System.out.println("Initialize singleton2");

        System.out.println("Are singleton & singleton2 the same object ? >> " + (singleton == singleton2) + "\n");
        System.out.println("Singleton = " + singleton + "\n");

        try {
            Class<?> sClass = Class.forName("course.homeworks.hw7.LazyInitializedSingleton");
            System.out.println("Break private field and set name as 'broken'.");
            Field field = sClass.getDeclaredField("name");
            field.setAccessible(true);
            field.set(singleton, "broken");
            System.out.println("Singleton = " + singleton + "\n");
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("Break default constructor and set singleton2 as an another instance");
        Constructor<?> defConstructor = singleton2.getClass().getDeclaredConstructor();
        defConstructor.setAccessible(true);
        try {
            singleton2 = (LazyInitializedSingleton) defConstructor.newInstance();
            System.out.println("Are singleton & singleton2 the same object ? >> " + (singleton == singleton2) + "\n");
            System.out.println("singleton = " + singleton.toString());
            System.out.println("singleton2 = " + singleton2.toString());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
