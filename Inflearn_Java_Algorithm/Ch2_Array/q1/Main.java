package Inflearn_Java_Algorithm.Ch2_Array.q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public String Solution(StringTokenizer st, int cnt) {
        StringBuilder res = new StringBuilder();
        int[] arr = new int[cnt];

        for (int i = 0; i < cnt; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        res.append(arr[0]);
        for(int j=1; j<cnt; j++){
            if (arr[j]>arr[j-1]){
                res.append(" ");
                res.append(arr[j]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Main main = new Main();
        System.out.println(main.Solution(st,cnt));
    }
}