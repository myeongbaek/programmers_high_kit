package BFS_PRAC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class PuzzlePiece {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];
        List<List<int[]>> boardList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();


        // bfs 탐색 : board와 table의 모양을 모두 탐색합니다.
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                // table은 1인 경우 모양이므로 방문하지 않은 모양을 발견한 경우 bfs 탐색을 통해 해당 모양의 좌표를 가져옵니다.
                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    bfs(i, j, visitedTable, table, 1, tableList);
                }

                if (game_board[i][j] == 0 && !visitedBoard[i][j]) {
                    bfs(i, j, visitedBoard, game_board, 0, boardList);
                }
            }
        }

        answer = findBlock(boardList, tableList);

        return answer;
    }

    public boolean isSameFeature(List<int[]> board, List<int[]> table) {
        boolean result = false;

        // tableObject 오름차순 정렬 (x 좌표 우선 이후 y 좌표)
        board.sort((o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]));

        for (int i = 0; i < 4; i++) { // table 퍼즐을 0, 90, 180, 270 회전
            table.sort((o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]));
            int ox = table.get(0)[0];
            int oy = table.get(0)[1];
            for (int[] xy : table) {
                xy[0] -= ox;
                xy[1] -= oy;
            }

            // board와 좌표 비교
            boolean isCollectablePoint = true;
            for (int j = 0; j < board.size(); j++) {
                int[] boardPoint = board.get(j);
                int[] tablePoint = table.get(j);

                if (boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]) {
                    isCollectablePoint = false;
                    break;
                }
            }

            if (isCollectablePoint) {
                result = true;
                break;
            } else { // 90도 회전
                for (int j = 0; j < table.size(); j++) {
                    int temp = table.get(j)[0];
                    table.get(j)[0] = table.get(j)[1];
                    table.get(j)[1] = -temp;
                }
            }
        }
        return result;
    }

    public int findBlock(List<List<int[]>> board, List<List<int[]>> table) {
        int result = 0;
        int tableLen = table.size();
        int boardLen = board.size();

        boolean[] visitedBoardObject = new boolean[boardLen];
        for (int i = 0; i < tableLen; i++) {
            List<int[]> tableObject = table.get(i);
            for (int j = 0; j < boardLen; j++) {
                List<int[]> boardObject = board.get(i);

                if (tableObject.size() == boardObject.size() && !visitedBoardObject[j]) {
                    if (isSameFeature(boardObject, tableObject)) {
                        result += tableObject.size();
                        visitedBoardObject[j] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public void bfs(int curX, int curY, boolean[][] visited, int[][] graph, int blockOrEmpty, List<List<int[]>> list) {
        Queue<int[]> queue = new LinkedList<>();

        visited[curX][curY] = true;
        queue.offer(new int[]{curX, curY});

        // 서브 리스트의 요소는 하나의 모양 전부입니다.
        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{curX - curX, curY - curY});

        while (!queue.isEmpty()) {
            int[] toVisit = queue.poll();
            int x = toVisit[0];
            int y = toVisit[1];
            // 인접한 모양들을 모두 탐색합니다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph.length) {
                    continue;
                }
                if (!visited[nx][ny] && graph[nx][ny] == blockOrEmpty) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    subList.add(new int[]{nx - curX, ny - curY});
                }
            }
        }
        list.add(subList);
    }
}

