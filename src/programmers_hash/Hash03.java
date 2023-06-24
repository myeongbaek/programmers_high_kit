package programmers_hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// 전화번호 목록
class Hash03{
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(phone_book).forEach(str -> map.put(str, 0));

        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                String prefix = s.substring(0, j);
                if (map.containsKey(prefix)) return false;
            }
        }

        return true;
    }
}
