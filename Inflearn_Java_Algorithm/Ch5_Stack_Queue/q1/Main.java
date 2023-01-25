package Inflearn_Java_Algorithm.Ch5_Stack_Queue.q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public String Solution(String[] st){
        String res = "YES";
        Stack<String> stack = new Stack<>();
        for(String s : st){
            if(s.equals("("))
                stack.push(s);
            else
                if(!stack.isEmpty())
                    stack.pop();
                else return "NO";
        }
        if(stack.isEmpty())
            return res;
        else
            return "NO";
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split("");

        System.out.println(main.Solution(st));
    }
}