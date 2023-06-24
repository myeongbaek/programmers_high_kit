package programmers_hash;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Hash01_Stream {
    private int solution(int[] input) {
        return Arrays.stream(input)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet(), phonekemons -> Integer.min(phonekemons.size(), input.length / 2)
                ));
    }
}
