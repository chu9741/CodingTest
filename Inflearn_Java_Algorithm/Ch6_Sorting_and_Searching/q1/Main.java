package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n , int[] arr){
        for(int j=0; j<n; j++){
            int min=arr[j];
            int index=j;
            for(int i =j; i<n; i++){
                if(min>arr[i]){
                    min=arr[i];
                    index=i;
                }
            }
            int tmp =arr[j];
            arr[j] = min;
            arr[index]= tmp;
            System.out.print(arr[j]+" ");
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        main.Solution(n,arr);
    }
}