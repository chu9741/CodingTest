
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] isVisitedConst;
    static boolean[] isVisited;

    static int max = 0;
    static int n = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        isVisited = new boolean[n + 1];
        isVisitedConst = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            int tmp = max;
            for (int m = 1; m <= n; m++) {
                isVisited[m] = isVisitedConst[m];
            }
            DFS(i, i, 0);
            if (max != tmp) {
                for (int m = 1; m <= n; m++) {
                    isVisitedConst[m] = isVisited[m];
                }
            }

            isVisited = new boolean[n + 1];
        }
        System.out.println(max);
        for (int a = 1; a <= n; a++) {
            if (isVisitedConst[a]) {
                System.out.println(a);
            }
        }
    }

    private static void DFS(int i, int origin, int cnt) {
        // 방문하지 않은 노드들 중에서   origin 값이 arr[i] 와 다르다면 계속 DFS를 이어감
        // 만약에 같으면  CNT를 계산 IsVIsited면 그냥 버림
        if (!isVisited[i]) {
            if (origin == arr[i]) {
                isVisited[i] = true;
                max += cnt + 1;
//                System.out.println(origin + " " + i + "  " + arr[i] + " " + max);
            } else {
                isVisited[i] = true;
                DFS(arr[i], origin, cnt + 1);
            }

        }

    }

}
