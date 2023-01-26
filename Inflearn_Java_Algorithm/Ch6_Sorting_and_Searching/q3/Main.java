package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public int[] Solution(int n , int[] arr){
        for(int i=1; i<n; i++){
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1]){
                    int tmp= arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1] = tmp;
                }
                else break;
            }
        }
        return arr;
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int a : main.Solution(n,arr))
            System.out.print(a+ " ");
    }

}