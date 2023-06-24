package study;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Spring");
        list.add("C");

        for (String str : list) {
            System.out.println(str);
        }

        list.stream().forEach((String str) -> {
            System.out.println(str);
        });
        list.stream().forEach(str-> System.out.println(str));
        list.stream().forEach(System.out::println); // 참조 메서드

        // 람다식은 익명 객체이며 익명객체는 함수형 인터페이스로 담을 수 있다.
        // 함수형 인터페이스는 오직 하나의 추상 메서드만을 가지는 인터페이스이다.
        MyFunctionalInterface<Integer> myFunc = a -> a * a;
        System.out.println(myFunc.square(2));
        myFunc.printDefault();
        MyFunctionalInterface.printStatic();

        // 함수형 인터페이스 예
        // Predicate T -> boolean test()
        // Consumer T -> void accept()
        // Function T -> R apply()
        // Supplier () -> T get()
        // primitype이 wrapper class로 auto boxing 될 경우 성능 문제를 해결하기위해 기본형 특화 함수형 인터페이스가 제공되고 있다.

        // 관점의 변화 : 파라미터에 람다로 정의된 코드 블럭을 받을 수 있습니다.
        // 람다로 정의된 코드 블럭은 타입이 정의되어 있어야 합니다.
        // 람다식은 함수형 인터페이스에 담길 수 있으며 Java API는 기능적으로 정의되어 있습니다.
        // list.stream.forEach는 Consumer 함수형 인터페이스를 매개변수로 가지고 있어 입력은 있으나 반환을 하지 않는 람다식을 받을 수 있습니다.
        //

    }

    // 함수형 인터페이스
    @FunctionalInterface // 컴파일러가 검사합니다.
    public interface MyFunctionalInterface<T> {
        T square(T a);

        default void printDefault(){
            System.out.println("Hi default");
        }
        static void printStatic(){
            System.out.println("Hi static");
        }
    }
}
