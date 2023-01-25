package Inflearn_Java_Algorithm.Ch5_Stack_Queue.q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n, int m, int[][] arr, int[] mArr){
        Stack<Integer> stack = new Stack<>();
        int count=0;

        stack.push(0);
        for (int k : mArr) {
            for (int j = 0; j < n; j++) {
                int tmp = arr[j][k - 1];
                if (tmp != 0 && tmp != stack.peek()) {
                    stack.push(tmp);
                    arr[j][k - 1] = 0;
                    break;
                } else if (tmp != 0 && tmp == stack.peek()) {
                    stack.pop();
                    arr[j][k - 1] = 0;
                    count += 2;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer stRow = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                arr[i][j] = Integer.parseInt(stRow.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];

        StringTokenizer stMArr = new StringTokenizer(br.readLine());
        for(int k=0; k<m; k++){
            mArr[k] = Integer.parseInt(stMArr.nextToken());
        }

        main.Solution(n,m,arr,mArr);
    }

}
