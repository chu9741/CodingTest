package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public int Solution(int n, Stack<Integer> stack){
        if(n!=1){
            stack.push(n);
            return Solution(n-1, stack);
        }
        stack.push(1);
        return 1;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        main.Solution(n,stack);

        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }

}