package Inflearn_Java_Algorithm.Ch5_Stack_Queue.q6;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n, int k){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++){
            queue.offer(i);
        }

        while(queue.size()>1){
            for(int i=0; i<k-1; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        System.out.println(queue.poll());
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        main.Solution(n,k);
    }
}