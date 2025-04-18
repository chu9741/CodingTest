
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        int[][] table = new int[m][2];

        int[][] way = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            table[i] = new int[] { a, b };
            way[a][b] = 1;
            way[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                way[i][j] = way[i][j] == 0 ? 1000 : way[i][j];
                if (i == j) {
                    way[i][j] = 0;
                }
            }
        }

        // floyd-warshall
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (way[i][j] > way[i][k] + way[k][j]) {
                        way[i][j] = way[i][k] + way[k][j];
                    }
                }
            }
        }

        // for (int j = 1; j <= n; j++) {
        // for (int k = 1; k <= n; k++) {
        // System.out.print(way[j][k] + " ");
        // }
        // System.out.println();
        // }

        // 치킨집 두 곳의 최저거리를 구하자
        int min = 2 * 2 * 100 * 100;

        // 0 2 1 3 3
        // 2 0 1 1 1
        // 1 1 0 2 2
        // 3 1 2 0 2
        // 3 1 2 2 0

        int idxA = 0, idxB = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 치킨집이 i ,j 일때 각 지점에서의 최솟값 구하기
                // 1,2 일때 1,1 1,2 중 최솟값 + 2,1 2,2 중 최솟값

                int cnt = 0;
                for (int k = 1; k <= n; k++) {
                    cnt += 2 * (Math.min(way[k][i], way[k][j]));
                }
                if (min > cnt) {
                    min = cnt;
                    idxA = i;
                    idxB = j;
                }
            }
        }
        System.out.println(idxA + " " + idxB + " " + min);
    }

}
