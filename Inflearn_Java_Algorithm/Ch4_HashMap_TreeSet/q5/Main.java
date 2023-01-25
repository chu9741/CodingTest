package Inflearn_Java_Algorithm.Ch4_HashMap_TreeSet.q5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public int Solution(int n, int k , int[] arr){
        int total = n*(n-1)*(n-2)/6;
        ArrayList<Integer> sum = new ArrayList<>();
        for(int a =0; a<n-2; a++){
            for(int b=a+1; b<n-1; b++){
                for(int c=b+1; c<n; c++){
                    int tmp = 0;
                    tmp+=arr[a]+arr[b]+arr[c];
                    sum.add(tmp);
                }
            }
        }
        sum.sort(Collections.reverseOrder()); // Not necessary

        Set<Integer> treeSet = new TreeSet<>(sum);
        Object[] res = treeSet.toArray();
        if(k>res.length){
            return -1;
        }
        return (int)res[res.length-k];
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        StringTokenizer st2= new StringTokenizer(br.readLine());
        for(int a=0; a<n; a++){
            arr[a] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(main.Solution(n,k,arr));
    }
}