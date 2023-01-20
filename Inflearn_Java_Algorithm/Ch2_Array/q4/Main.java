package Inflearn_Java_Algorithm.Ch2_Array.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public int[] Solution(int cnt){
        int[] arr = new int[cnt];
        arr[0] =1; arr[1]=1;

        for(int i=2; i<cnt; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for(int res : main.Solution(cnt))
            System.out.print(res+" ");
    }
}