package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test1 {

    static int M, N;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0}; // Nam, Đông, Bắc, Tây
    static int[] dy = {0, 1, 0, -1};
    static String[] directions = {"N", "D", "B", "T"};
    static StringBuilder result = new StringBuilder();

    public static String solve(List<List<Integer>> arr, int X, int Y) {
        M = arr.size();
        N = arr.get(0).size();
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = arr.get(i).get(j);
            }
        }

        dfs(Y - 1, X - 1);

        return result.toString();
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N && map[x][y] == 0;
    }

    static void dfs(int x, int y) {
        map[x][y] = 1; // Đánh dấu ô đã trồng cây

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if (isValid(newX, newY)) {
                result.append(directions[dir]);
                dfs(newX, newY);
            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(List.of(1, 1, 0, 1, 1, 1));
        arr.add(List.of(1, 1, 0, 0, 0, 0));
        arr.add(List.of(0, 0, 0, 1, 1, 0));
        arr.add(List.of(0, 0, 0, 0, 0, 1));
        arr.add(List.of(1, 1, 0, 0, 1, 1));
        arr.add(List.of(1, 1, 1, 0, 1, 1));

        int X = 4;
        int Y = 6;

        String result = solve(arr, X, Y);
        System.out.println(result);
    }
}
