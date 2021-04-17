package course.Reflection.example0;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Class<?> carClass = Class.forName("com.sber.reflection.example0.Car");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        for (int i = 0; i<10;i++){
            if (i==3) throw new Exception("I=3 EXCEPTIOn");
        }


        Car car = new Car(23);
        Class<? extends Car> carClass2 = car.getClass();


        Class<? extends Car> carClass = car.getClass();

        Class<Car> carClass3 = Car.class;



        Field[] declaredFields = carClass2.getDeclaredFields();
        for (Field field :declaredFields) {
            System.out.println(field);
            field.setAccessible(true);
            System.out.println("PRIVATE FIELD:"+field.get(car));
        }

        //fields
        System.out.println("getDeclaredField");
        try {
            Field horsepowerField = carClass2.getDeclaredField("horsepower");
            System.out.println(horsepowerField);
            Field blaBlaField = carClass2.getDeclaredField("bla_bla");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("getFields");

        Field[] fields = carClass2.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.exit(2);

        System.out.println("getField");

        try {
            Field serialNumberField = carClass.getField("serialNumber");
            System.out.println(serialNumberField);
            Field horsepowerField = carClass.getField("horsepower");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //methods
        System.out.println("getDeclaredMethods");

        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method method : declaredMethods) {

        }

        System.out.println("getDeclaredMethod");
        try {
            Method printSerialNumberMethod = carClass.getDeclaredMethod("printSerialNumber");
            System.out.println(printSerialNumberMethod);
            printSerialNumberMethod.invoke(new Car());

            Method setHorsepowerMethod = carClass.getDeclaredMethod("setHorsepower", int.class);
            System.out.println(setHorsepowerMethod);

            carClass.getDeclaredMethod("dodooooo");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("getMethods");
        Method[] methods = carClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("getMethod");

        try {
            Method getHorsepowerMethod = carClass.getMethod("notifyAll");
            System.out.println(getHorsepowerMethod);

            Method printSerialNumberMethod = carClass.getMethod("printSerialNumber");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
