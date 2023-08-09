import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static boolean[] visited;

    public static void main(String[] args) {
        int[][] graph = {{},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}};


        int start = 1;
        visited = new boolean[graph.length];
        bfs(start, graph);
    }

    public static void bfs(int start, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int p = q.poll();
            System.out.println(p + " ");

            for(int n : graph[p]){
                if(!visited[n]){
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }
    }
}
