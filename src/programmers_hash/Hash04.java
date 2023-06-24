package programmers_hash;

import java.util.Arrays;
import java.util.HashMap;

// 의상
class Hash04 {

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        Arrays.stream(clothes).forEach(strings -> hm.put(strings[1], hm.getOrDefault(strings[1], 0) + 1));

        for (int n : hm.values()) {
            answer *= n + 1;
        }
        return answer - 1;
    }
}
