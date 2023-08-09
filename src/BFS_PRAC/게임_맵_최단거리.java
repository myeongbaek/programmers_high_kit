package BFS_PRAC;

import java.util.LinkedList;
import java.util.Queue;

class 게임_맵_최단거리 {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        answer = bfs(0, 0, maps, visited);
        System.out.println(answer);
        return answer;
    }

    public int bfs(int sx, int sy, int[][] graph, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        int n = graph.length, m = graph[0].length;
        while (!queue.isEmpty()) {
            int[] toVisit = queue.poll();
            int x = toVisit[0];
            int y = toVisit[1];

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    graph[nx][ny] += graph[x][y];
                }
            }

        }
        return graph[n - 1][m - 1] == 1 ? -1 : graph[n - 1][m - 1];
    }
}
