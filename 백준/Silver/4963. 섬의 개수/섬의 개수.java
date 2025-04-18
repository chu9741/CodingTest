
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int cnt = 0;
    static boolean isIsLand = false;
    static int h = 0;
    static int w = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] tmp = br.readLine().split(" ");
            w = Integer.parseInt(tmp[0]);
            h = Integer.parseInt(tmp[1]);

            if (h == 0 && w == 0) {
                break;
            }

            int[][] table = new int[h][w];

            for (int i = 0; i < h; i++) {
                String[] strArr = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    table[i][j] = Integer.parseInt(strArr[j]);
                }
            }

            boolean[][] isVisited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (table[i][j] == 1 && !isVisited[i][j]) {
                        dfs(table, isVisited, i, j);
                        cnt++;
                    }

                }
            }
            System.out.println(cnt);
            cnt = 0;

        }
    }

    private static void dfs(int[][] table, boolean[][] isVisited, int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (!isVisited[nx][ny] && table[nx][ny] == 1) {
                    dfs(table, isVisited, nx, ny);
                }
            }
        }

    }

}
