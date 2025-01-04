import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(n, numbers, operators, 1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int n, int[] numbers, int[] operators, int idx, int sum) {
        if (idx == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                if (i == 0) {
                    dfs(n, numbers, operators, idx + 1, sum + numbers[idx]);
                } else if (i == 1) {
                    dfs(n, numbers, operators, idx + 1, sum - numbers[idx]);
                } else if (i == 2) {
                    dfs(n, numbers, operators, idx + 1, sum * numbers[idx]);
                } else {
                    dfs(n, numbers, operators, idx + 1,
                            sum < 0 ? -(Math.abs(sum) / numbers[idx]) : sum / numbers[idx]);
                }

                operators[i]++;
            }
        }
    }
}
