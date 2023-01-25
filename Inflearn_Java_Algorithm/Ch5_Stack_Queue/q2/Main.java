package Inflearn_Java_Algorithm.Ch5_Stack_Queue.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public void Solution(String[] arr){
        Stack<String> stack = new Stack<>();
        for(String s : arr){
            if(s.equals("("))
                stack.push(s);
            else if(s.equals(")"))
                stack.pop();
            else{
                if(!stack.isEmpty())
                    continue;
                else System.out.print(s);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        main.Solution(arr);

    }

}