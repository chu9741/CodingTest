
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt((br.readLine()));
        int[][] schedule = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            schedule[i] = new int[] { a, b };
        }

        Map<Integer, Integer> calender = new HashMap<>();

        for (int i = 1; i <= 365; i++) {
            calender.put(i, 0);
        }

        for (int[] s : schedule) {
            for (int i = s[0]; i <= s[1]; i++) {
                calender.put(i, calender.get(i) + 1);
            }
        }

        int sum = 0;
        int width = 0;
        int height = 0;
        for (int i = 1; i <= 365; i++) {

            if (calender.get(i) == 0) {
                // 사각형 시작 i
                // 사각형 끝 i -> 사각형 계산
                sum += height * width;
                width = 0;
                height = 0;

            } else {
                width++;
                height = Math.max(calender.get(i), height);
                if (i == 365) {
                    sum += height * width;
                }
            }
        }

        System.out.println(sum);
    }
}
