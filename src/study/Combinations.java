package study;

import java.util.Arrays;

public class Combinations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] visited = new boolean[arr.length];

        System.out.println("=========백트래킹========");
        for(int r = 1; r <= arr.length; r++){
            System.out.println(arr.length + "개 중에서 " + r + "개 뽑기");
            comb(arr, visited, 0, r);
        }
    }

    private static void comb(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0){
            int total = 1;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) total *= arr[i];
            }
            System.out.println(Arrays.toString(arr) + " " + Arrays.toString(visited) + " total : " + total);
        } else {
            for(int i = start; i < arr.length; i++){
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}
