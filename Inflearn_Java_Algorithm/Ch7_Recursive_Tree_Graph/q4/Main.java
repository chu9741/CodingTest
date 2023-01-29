package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q4;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public int Solution(int n){
        if(n==1 || n==2)
            return 1;

        return (Solution(n-1) + Solution(n-2));
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++)
            System.out.print(main.Solution(i)+" ");
    }
}