package programmers_hash;

import java.util.HashSet;

public class Hash01_HashSet {
    public int solution(int[] nums){
        HashSet<Integer> hs = new HashSet<>();
        for(int a : nums){
            hs.add(a);
        }

        if(hs.size() > nums.length / 2){
            return nums.length / 2;
        }

        return hs.size();
    }
}
