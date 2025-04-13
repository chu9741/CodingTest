

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        Queue<int[]> queue = new LinkedList<>();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        int left = 0;
        int right = n - 1;
        int max = 0;

        int[] start = new int[] { left, right };
        queue.add(start);
        // l~r = n명, -> n * Min.(arr[l], arr[r])
        // 숫자를 줄일때 Min을 계속 줄이는 방식으로 하면

        while (left < right) {
            int sum = Math.min(arr[left], arr[right]) * (right - left - 1);
            if (sum > max) {
                max = sum;
            }
            if (arr[left] > arr[right]) {
                right -= 1;
            } else {
                left += 1;
            }

        }

    
        System.out.println(max);

    }

}
