package Inflearn_Java_Algorithm.Ch5_Stack_Queue.q8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public int toInteger(String s){
        return Integer.parseInt(s);
    }

    public void Solution(int n, int m, int[] arr){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.offer(arr[i]);
            indexQueue.offer(i);
        }

        int target = arr[m];
        int count =0;
        while(queue.contains(target) && indexQueue.contains(m)){
            int index=0;
            int max=queue.peek();
            for(int i=0; i<queue.size(); i++){
                int tmp=queue.peek();
                queue.offer(queue.poll());
                indexQueue.offer(indexQueue.poll());
                if(tmp>max){
                    max=tmp;
                    index=i;
                }
            }
            for(int j=0; j<index; j++){
                queue.offer(queue.poll());
                indexQueue.offer(indexQueue.poll());
            }
            count++;
            queue.poll();
            indexQueue.poll();
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = main.toInteger(st.nextToken());
        int m = main.toInteger(st.nextToken());

        int[] numArr= new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numArr[i] = main.toInteger(st2.nextToken());
        }

        main.Solution(n,m,numArr);
    }

}