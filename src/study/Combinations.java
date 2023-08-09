package study;

public class Combinations {
    public static boolean[] visited;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int r = 3;

        visited = new boolean[arr.length];
        backtracking(arr, 0, 0, r);
    }

    public static void backtracking(int[] arr, int start, int level, int end) {
        if (level == end) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(arr, i + 1, level + 1, end);
                visited[i] = false;
            }
        }
    }
}
