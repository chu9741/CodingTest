package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q7;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public int Solution(int n, int m){
        if(n==3){
            return 3;
        }
        if(n-m==1 || m==1)
            return n;
        return Solution(n-1,m-1) + Solution(n-1,m);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(main.Solution(n,m));
    }

}