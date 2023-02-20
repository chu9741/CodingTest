package Inflearn_Java_Algorithm.Ch10_Dynamic_Programming.q3;

import java.io.*;
import java.util.*;

public class Main {
    static int[] answer;

    public void Solution(int n, int[] arr){
        answer[0]=1;
        int max=0;

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    max=answer[j];
                    answer[i]=Math.max(answer[i],answer[j]+1);
                }
                //arr[i]의 값이 이전것들보다 크면 이전 것들의 answer의 + 1한걸 취한다.
            }
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        answer=new int[n];
        for(int j=0; j<n; j++) answer[j]=1;
        main.Solution(n,arr);
        int max=0;
        for(int a=0; a<n; a++){
            max=Math.max(max,answer[a]);
        }
        System.out.println(max);
    }
}