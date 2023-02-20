package Inflearn_Java_Algorithm.Ch10_Dynamic_Programming.q1;

import java.io.*;
import java.util.*;

public class Main {
    public int combi(int n, int r){
        if(n==r || r==0)
            return 1;
        if(n==0) return 0;
        else {
            return combi(n-1,r-1)+combi(n-1,r);
            //n-1 C r-1 + n-1 C r
        }
    }

    public int Solution(int n) {
        int sum=0;
        if(n==1)
            return 1;
        else {
            for(int i=0; i<n; i++){
                sum+=combi(n-i,i);
                // n-i C i
            }
        }
        System.out.println(sum);
        return sum;

        // n/2를 해서 2를 쓸수있는 개수를 파악 -> m
        // for문을 0~m까지 돌며 n-iCi을 하면될듯  -> DP가 아니다.

        // 1 2 3 5 8 13 21
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        main.Solution(n);
    }
}
