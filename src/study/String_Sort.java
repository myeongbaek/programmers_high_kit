package study;

import java.util.Arrays;
import java.util.Comparator;

public class String_Sort {
    public static void main(String[] args) {
        String_Sort.stringSort1();
    }
    public static void stringSort1(){
        String[] array = new String[]{"232", "111", "123", "12", "35", "6"};
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Arrays.stream(array).forEach(System.out::println);
    }
    public static void stringSort2(){
        String[] array = new String[]{"232", "111", "123", "12", "35", "6"};
        Arrays.sort(array, (o1, o2) -> o1.length() - o2.length());
        Arrays.stream(array).forEach(System.out::println);
    }
    public static void stringSort3(){
        String[] array = new String[]{"232", "111", "123", "12", "35", "6"};
        Arrays.sort(array, Comparator.comparingInt(String::length));
        Arrays.stream(array).forEach(System.out::println);

    }
}
