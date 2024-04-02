import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {

    static boolean[][] isVisited;
    static boolean[][] isVisitedRG;
    static char[][] board;
    static int count = 0;
    static int countRG = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        isVisited = new boolean[n][n];
        isVisitedRG = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = temp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j, n, board[i][j]);
                    count++;
                }
                if (!isVisitedRG[i][j]) {
                    dfs_rg(i, j, n, board[i][j]);
                    countRG++;
                }
            }
        }
        System.out.println(count + " " + countRG);

    }

    static void dfs(int i, int j, int n, char c) {
        isVisited[i][j] = true;
        for (int a = 0; a < 4; a++) {
            if (i + dx[a] >= 0 && i + dx[a] < n && j + dy[a] >= 0 && j + dy[a] < n) {
                if (board[i + dx[a]][j + dy[a]] == c && !isVisited[i + dx[a]][j + dy[a]]) {
                    dfs(i + dx[a], j + dy[a], n, c);
                }
            }
        }
    }

    static void dfs_rg(int i, int j, int n, char c) {
        isVisitedRG[i][j] = true;
        for (int a = 0; a < 4; a++) {
            if (i + dx[a] >= 0 && i + dx[a] < n && j + dy[a] >= 0 && j + dy[a] < n) {
                if (c == 'R' || c == 'G') {
                    if ((board[i + dx[a]][j + dy[a]] == 'R' || board[i + dx[a]][j + dy[a]] == 'G') && !isVisitedRG[i + dx[a]][j + dy[a]]) {
                        dfs_rg(i + dx[a], j + dy[a], n, c);
                    }
                } else {
                    if ((board[i + dx[a]][j + dy[a]] == c) && !isVisitedRG[i + dx[a]][j + dy[a]]) {
                        dfs_rg(i + dx[a], j + dy[a], n, c);
                    }
                }
            }
        }
    }
}