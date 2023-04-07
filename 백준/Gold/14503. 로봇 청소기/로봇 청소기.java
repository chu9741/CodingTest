import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방향 0=북 1=동 2=남 3=서 // 시계방향
        // M N 조심 arr[n][m]이어야함
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        robot(r, c, d);
        // int count = 0;

        System.out.println(cnt);

    }

    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 0,1,2,3
    static int cnt = 0;

    private static void robot(int r, int c, int d) {
        while (true) {

            if (arr[r][c] == 0) { // 청소할곳
                arr[r][c] = -1;
                cnt++;
            }

            if (!findUncleanSpace(r, c, d)) { // 주변 칸 청소할거 없으면
                int tempDir = (d + 2) % 4; // 후진준비 3-> 1 , 2-> 0 , 1-> 3, 0 -> 2
                if (arr[r + dir[tempDir][0]][c + dir[tempDir][1]] == 1) {
                    break;
                } else {
                    r += dir[tempDir][0];
                    c += dir[tempDir][1];
                    continue;
                }
            }
            if (findUncleanSpace(r, c, d)) {
                if (d == 0) { // 반시계 방향전환
                    d = 3;
                } else {
                    d -= 1;
                }

                if (arr[r + dir[d][0]][c + dir[d][1]] == 0) { // 내앞칸에 청소할게 잇으면 이동
                    r += dir[d][0];
                    c += dir[d][1];
                    continue;
                }

            }
        }
    }

    public static boolean findUncleanSpace(int r, int c, int d) { // 0 북/ 1 동/ 2 남/ 3 서
        for (int[] direction : dir) {
            if (arr[r + direction[0]][c + direction[1]] == 0) {
                return true;
            }
        }
        return false;
    }

}