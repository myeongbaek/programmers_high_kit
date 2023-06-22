import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length / 2;
        int kind = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int a : nums) {
            if (!hm.containsKey(a)) {
                kind++;
                hm.put(a, 0);
            }
        }
        if (kind > size) {
            answer = size;
        } else {
            answer = kind;
        }

        return answer;
    }
}