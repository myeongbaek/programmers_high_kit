package study;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // I/O Stream : 파일 입출력, System.in,,,
        // Stream API 집합적인 데이터 (컬렉션)를 조작할 때 가독성 있고 편리하게 처리해주기위한 다양한 소스를 제공
        List<String> list = Arrays.asList("Lee", "Kim", "Park");

        // Iterator를 활용한 순회 출력
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Stream을 활용한 순회 출력
        list.stream().forEach(name -> System.out.println(name));

        System.out.println("==================30살 이상의 customer 중 순서대로 이름만 출력하기===================");

        // stream 예제
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Song", 45));
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));
        customers.add(new Customer("Lee", 67));
        customers.add(new Customer("Choi", 19));

        // 나이가 30 이상인 사람들을 가져와 오름차순으로 정렬하고 이름을 추출한다.
        // 기존의 방식
        List<Customer> li = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getAge() > 30) {
                li.add(customer);
            }
        } // age > 30 추출
        Collections.sort(li); // 오름차순 정렬
        List<String> results = new ArrayList<>();
        for (Customer customer : li) {
            results.add(customer.getName());
        } // String 저장
        for (String name : results) {
            System.out.println(name);
        } // 출력
        System.out.println("==================위와 같은 조건에서 스트림을 활용하기===================");
        List<String> customerNames = customers.stream()
                .filter(customer -> customer.getAge() > 30) // 필터
                .sorted() // 정렬
                .map(Customer::getName) // 맵핑
                .collect(Collectors.toList()); // 리스트로 반환
        for (String name : customerNames) {
            System.out.println(name);
        }
        System.out.println("======================스트림 생성========================");
        //스트림 객체 생성하기 - 1 : 이미 기존에 데이터가 존재하는 경우 - 콜렉션 데이터로부트 .stream() 기본 함수를 호출하여 스트림을 생성
        // 한 번 사용된 스트림은 다시 사용할 수 없음.
        Stream<String> stream1 = results.stream();
        System.out.println(stream1.count());
        // 스트림 객체 생성하기 - 2 : 데이터를 받아야 하는 경우 - 스트림 빌더를 활용
        // accept, add, build
        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Kim");
        builder.accept("Lee");
        builder.accept("Park");
        Stream<String> stream2 = builder.build();
        System.out.println(stream2.count());
        System.out.println("=======================스트림 연산=======================");
        // 스트림은 각 연산을 연결하여 파이프라인을 구성할 수 있다.
        // 파이프라인을 구성한다는 것은 스트림 대상 데이터에 다양한 연산을 조합할 수 있다.
        // 스트림의 처리는 스트림 객체 생성 -> 중간연산 -> 최종 연산으로 구분할 수 있다.
        // 스트림 객체가 제공하는 다양한 연산을 이해하려면 연산에 필요한 람다식을 이해하고 적용하는 것이 중요하다.
        // 스트림 중간 연산 : 연산 반환 타입이 stream이기 때문에 메소드 체이닝으로 구현 가능하다. 예) filter, map, limit, sorted, distinct, peek, skip
        // 스트림 최종 연산 : void, Collection 타입을 반환하여 가공된 스트림의 최종 결과를 출력한다. 예) forEach, collect, count, sum, reduce
        // 최종 연산이 후에 소모된 스트림은 닫히고 재사용이 불가능하다.

        // 중간 연산 - 필터링 : filter, distinct
        Stream<Customer> stream3 = customers.stream();
        stream3.filter(customer -> customer.getAge() > 30)
                .forEach(System.out::println);
        System.out.println();
        Stream<Customer> stream4 = customers.stream();
        stream4.filter(customer -> customer.getAge() > 30)
                .distinct() // 객체의 비교를 위해 equals() 메소드가 이용되며 재정의가 필요하다.
                .forEach(System.out::println);
        // distict를 사용할 경우 병렬 스트림의 경우 성능에 대한 고려가 필요하다.
        // 스트림으로 데이터를 처리할 때 병렬로 처리하면 스레드의 갯수 만큼 시간이 줄어들 수 있다. -> 병렬스트림은 성능을 높이기 위해 사용된다.
        // customers.parallelStream() -> 병렬로 처리
        // 병렬 스트림 도중 중복 제거 연산을 수행하면 성능에 문제가 생길 수 있다.
        System.out.println();
        // 중간연산 - 정렬 : sorted
        // 정렬 조건을 Comparable, compareTo overriding하거나 Comparator.comparing에서 조건을 추가한다.
        // sorted로 정렬하기 위해서는 반드시 대상 객체들이 Comparable 인터페이스 구현체 클래스여야 한다.
        // 즉, 비교 가능한 객체여야 한다.
        // Compatible 객체가 아닌 경우 Comparator 인터페이스에서 제공하는 default, static 메소드를 이용해 정렬을 구현한다.
        Stream<Customer> stream5 = customers.stream();
        // 나이순으로 정렬하기
        stream5.sorted()
                .forEach(System.out::println);
        System.out.println();
        Stream<Customer> stream6 = customers.stream();
        // 이름 순으로 정렬하기 : Comparator.comparing()
        stream6.sorted(Comparator.comparing(Customer::getName))
                .forEach(System.out::println);

        System.out.println("=======================스트림 매핑=======================");
        // 스트림 매핑 : 매핑 연산은 중간 연산이며 스트림 타입을 반환하지만 다른 형태의 데이터로 변환할 수 있도록 한다.
        Stream<Customer> stream7 = customers.stream();
        List<String> names = stream7.map(customer -> customer.getName()) // Stream<Customer> -> Stream<String>
                .collect(Collectors.toList());
        names.stream().forEach(System.out::println);
        System.out.println();
        customers.stream().map(Customer::getName).forEach(System.out::println);

        System.out.println("=======================최종 연산 =======================");
        // 최종 연산 : forEach, collect, count, sum, reduce, findFirst, allMatch, anyMatch, noneMatch
        // collect : 스트림 처리 이후 결과물을 Collection 객체로 반환, Collectors.toList, .toSet, .toMap
        // forEach : 스트림 처리 결과를 확인.
        // allMatch, anyMatch, noneMatch : 특정 데이터 검색, 람다식을 기준으로 모두 일치하는지, 하나라도 일치하는지, 모두 일치하지 않는지 확인
        // findFirst : 가장 첫 번째 데이터를 반환
        // reduce : 스트림 데이터 중 임의의 데이터를 반환
        boolean result = customers.stream().filter(customer -> customer.getAge() > 30)
                .anyMatch(customer -> customer.getName() == "Kim");
        System.out.println(result);
        System.out.println();
        List<String> namesList = customers.stream().filter(customer -> customer.getAge() > 30)
                .sorted(Comparator.comparing(Customer::getName))
                .map(Customer::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(namesList);

    }


    static class Customer implements Comparable<Customer> {
        private String name;
        private int age;

        public Customer(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "[Name : " + name + ", Age : " + age + "]";
        }

        // 중복 제거 연산인 distict를 사용하기위해 equals() 메소드가 재정의 되어야 함.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Customer customer = (Customer) o;

            // 나이가 같았을 때 동일한 결과임을 재정의함.
            return name.equals(customer.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }


        // 정렬기준 : 나이
        @Override
        public int compareTo(Customer o) {
            if (age > o.getAge()) {
                return 1;
            } else if (age == o.getAge()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}




