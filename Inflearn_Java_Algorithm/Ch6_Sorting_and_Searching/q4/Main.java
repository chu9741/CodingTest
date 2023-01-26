package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public void Solution(int s, int n, int[] arr){
        Queue<Integer> cache = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(cache.contains(arr[i])){
                cache.remove(arr[i]);
                cache.offer(arr[i]);
            }
            else{
                if(cache.size()<s){
                    cache.offer(arr[i]);
                }
                else{
                    cache.poll();
                    cache.offer(arr[i]);
                }
            }
        }
        Stack<Integer> tmp = new Stack<>();
        while (!cache.isEmpty())
            tmp.push(cache.poll());
        while(!tmp.isEmpty())
            System.out.print(tmp.pop()+" ");
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        main.Solution(s,n,arr);
    }
}