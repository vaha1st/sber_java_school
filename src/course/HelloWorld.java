package course;

import course.homeworks.hw3.hash.EffectiveHashcode;
import course.homeworks.hw3.hash.TestMy;

public class HelloWorld {

    public static void main(String[] args) {
        TestMy test = new TestMy();
        System.out.println(new EffectiveHashcode().getHashcode(test));
    }
}
