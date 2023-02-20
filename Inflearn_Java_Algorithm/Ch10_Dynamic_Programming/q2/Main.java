package Inflearn_Java_Algorithm.Ch10_Dynamic_Programming.q2;

import java.io.*;
import java.util.*;

public class Main {
    static int[] walk;
    public void Solution(int n){
        walk[1]=1;
        walk[2]=2;

        for(int i=3; i<=n+1; i++){
            walk[i]=walk[i-1]+walk[i-2];
        }
        System.out.println(walk[n+1]);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        walk = new int[n+2];

        main.Solution(n);
    }

}