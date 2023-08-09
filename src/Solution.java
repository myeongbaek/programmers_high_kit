import java.util.*;
class Solution {
    public static int[][] map = new int[100][100];

    public int solution(int n, int[][] wires) {
        int answer = -1;

        for(int i = 0; i < n - 1; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            map[a][b] = 1;
            map[b][a] = 1;
        }

        return answer;
    }
}
