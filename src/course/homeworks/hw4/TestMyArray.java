package course.homeworks.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestMyArray {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>(10);
        MyArrayList<Integer> arrayList2 = new MyArrayList<>(Arrays.asList(9,8,7,6,5,4));
        List<Integer> original = new ArrayList<>(10);
        System.out.println(original);
        System.out.println(arrayList);
        System.out.println(arrayList2);
        arrayList.add(10, 10);
        System.out.println(arrayList);
        arrayList.addAll(11, new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
        System.out.println(arrayList);
        System.out.println(arrayList.get(10));
        System.out.println(arrayList.indexOf(10));
        System.out.println(arrayList.lastIndexOf(10));
        System.out.println(arrayList.remove(12));
        System.out.println(arrayList);
        System.out.println(arrayList.sublist(10, 12).getClass());
        System.out.println(arrayList.hashCode());
    }
}
