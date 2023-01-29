package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q3;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public int Solution(int n){
        if(n==0) return 1;
        else
            return n*Solution(n-1);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(main.Solution(n));
    }
}