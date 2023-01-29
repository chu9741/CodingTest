package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void Solution(int n){
        if(n!=0){
            if(n%2==0) {
                Solution(n/2);
                System.out.print(0);
            }
            else {
                Solution(n/2);
                System.out.print(1);
            }
        }
        else return;
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        main.Solution(n);
    }
}