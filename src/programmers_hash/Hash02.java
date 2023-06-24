package programmers_hash;

import java.util.HashMap;
// 완주하지 못한 선수
class Hash02 {
    public String solution(String[] participiant, String[] completion) {
        String result = "";

        HashMap<String, Integer> hm = new HashMap<>();
        for (String str : completion) {
            if (!hm.containsKey(str)) {
                hm.put(str, 1);
            } else {
                int cnt = hm.get(str);
                hm.put(str, ++cnt);
            }
        }
        for (String str : participiant) {
            if (hm.containsKey(str)) {
                int cnt = hm.get(str);
                if (cnt > 0) {
                    hm.put(str, --cnt);
                } else {
                    result = str;
                }
            } else {
                result = str;
            }
        }

        return result;
    }
}
