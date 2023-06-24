import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public static int cnt = 0;
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("17"));
    }
    public int solution(String numbers) {
        int answer = 0;
        int max = Integer.parseInt(Arrays.stream(numbers.split(""))
                .sorted((o1, o2) -> Integer.parseInt(o2) - Integer.parseInt(o1))
                .collect(Collectors.joining()));
        boolean[] isNotPrime = new boolean[max + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i = 2; i < max + 1; i++){
            if (!isNotPrime[i]) {
                for(int j = 2 * i; j < max + 1; j += i){
                    isNotPrime[j] = true;
                }
            }
        }

        boolean[] visited = new boolean[8];
        int[] result = new int[8];
        for(int n = 1; n <= numbers.length(); n++){
            dfs(0, n, numbers, isNotPrime, visited, result);
        }
        answer = cnt;
        return answer;
    }

    private void dfs(int level, int end, String numbers, boolean[] isNotPrime, boolean[] visited, int[] result) {
        if (level == end){
            int resultNumber = 0;
            for(int i = 1; i <= end; i++){

            }
            if(!isNotPrime[resultNumber]){
                isNotPrime[resultNumber] = true;
                cnt++;
            }
            return;
        }
        for(int i = 0; i < numbers.length(); i++){
            visited[i] = true;
            result[level] = numbers.charAt(i) - '0';
            dfs(level + 1, end, numbers, isNotPrime, visited, result);
            visited[i] = false;
        }
    }
}
