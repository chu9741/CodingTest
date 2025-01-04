import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] testCases = new int[n][];

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            for (int j = 0; j < m; j++) {
                testCases[i] = temp;
            }
        }
        // logic

        boolean[][] isVisited = new boolean[n][];
        for (int i = 0; i < n; i++) {
            count = 0;
            isVisited[i] = new boolean[testCases[i].length];
            dfs(testCases[i], isVisited[i], 0, testCases[i].length, 0);
            // visited아니면 계속 진행
            System.out.println(count);
        }

    }

    static void dfs(int[] testCases, boolean[] isVisited, int idx, int arrLength, int visitedCount) {
        for (int i = idx; i < arrLength; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (isVisited[testCases[i] - 1]) {
                    // dfs에 카운트 올려서 진행
                    count++;
                    dfs(testCases, isVisited, idx, arrLength, visitedCount + 1);
                } else {
                    dfs(testCases, isVisited, testCases[i] - 1, arrLength, visitedCount + 1);
                }
            }

        }
        // idx가 isVisited => 다른 싸이클로 진행
        // idx가 non-Visited => 이어가기
    }
}
