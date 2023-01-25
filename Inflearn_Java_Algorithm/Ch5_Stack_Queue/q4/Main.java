package Inflearn_Java_Algorithm.Ch5_Stack_Queue.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public void Solution(char[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (char c : arr) {
            if (Character.isDigit(c))
                stack.push(c - '0');
            else {
                if (c == '+')
                    stack.push(stack.pop() + stack.pop());
                if (c == '*')
                    stack.push(stack.pop() * stack.pop());
                if (c == '/')
                    stack.push(1 / stack.pop() * stack.pop());
                if (c == '-')
                    stack.push(-stack.pop() + stack.pop());
            }
//            System.out.print(stack.peek()+" ");
        }
        System.out.println(stack.pop());
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        main.Solution(arr);
    }
}