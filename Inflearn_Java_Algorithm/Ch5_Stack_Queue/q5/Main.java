package Inflearn_Java_Algorithm.Ch5_Stack_Queue.q5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public void Solution(String[] arr){
        Stack<String> stack = new Stack<>();
        Stack<String> countStickStack = new Stack<>();

        int totalStick =0;
        stack.push("(");

        for(String s : arr){
            if(s.equals("(") && stack.peek().equals("(")){
                countStickStack.push(s);
            }
            else if(s.equals("(") && stack.peek().equals(")")){
                //new stick
                countStickStack.push(s);
            }
            else if(s.equals(")") && stack.peek().equals("(")){
                //rasor
                countStickStack.pop();
                totalStick += countStickStack.size();
            }
            else if (s.equals(")") && stack.peek().equals(")")) {
                totalStick +=1;
                countStickStack.pop();
            }
            stack.push(s);
        }
        System.out.println(totalStick);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        main.Solution(arr);
    }
}