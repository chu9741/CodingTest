package Inflearn_Java_Algorithm.Ch5_Stack_Queue.q7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {

    public String Solution(String[] arr, String[] classArr){
        Queue<String> queue = new LinkedList<>();
        Queue<String> classQueue = new LinkedList<>();
        for(String s : classArr)
            classQueue.offer(s);

        for(String a : arr)
            queue.offer(a);

        for(int i=0; i<classArr.length; i++){
            if(Objects.equals(classQueue.peek(), queue.peek()) && !queue.isEmpty()){
                queue.poll();
                classQueue.poll();
            }
            else if (!Objects.equals(classQueue.peek(),queue.peek()) && !queue.isEmpty()) {
                classQueue.poll();
            }
            else if(queue.isEmpty())
                return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        String[] classArr = br.readLine().split("");

        System.out.println(main.Solution(arr,classArr));
    }
}