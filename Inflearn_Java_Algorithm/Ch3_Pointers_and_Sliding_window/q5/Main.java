package Inflearn_Java_Algorithm.Ch3_Pointers_and_Sliding_window.q5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void Solution(int n){
        int sum=0;
        int lt=0, rt=0;
        int count=0;
        int[] arr =new int[n/2+1];
        for(int a=0; a<arr.length; a++){
            arr[a]=a+1;
        }
        for(; rt<arr.length; rt++){
            sum+=arr[rt];
            if(sum==n) count++;
            else{
                while(sum>n){
                    sum-=arr[lt++];
                }
                if(sum==n) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public void Solution2(int n){
        int count=0, sum=0, lt=0;
        int[] arr =new int[n/2+1];
        for(int a=0; a<arr.length; a++){
            arr[a]=a+1;
        }
        for(int rt=0; rt<arr.length; rt++){
            sum += arr[rt];
            if(sum==n) count++;
            while(sum>=n){
                sum -= arr[lt++];
                if(sum==n) count++;
            }
        }
        System.out.println(count);
    }



    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        main.Solution2(n);

    }

}