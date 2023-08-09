package Sort_PRAC;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        // int[] -> String[]
        Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .forEach(sb::append);

        String answer = sb.toString();

        if (answer.charAt(0) == '0'){
            return "0";
        } else {
            return answer;
        }
    }
}
