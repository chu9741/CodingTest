package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n, int[] arr){
        int min=0 ,max=0;
        for(int i=0; i<n-1; i++){
            if(arr[i]>arr[i+1])
                if(min==0)
                    min = i+1;
                else max = i+2;
        }

        if(max==0){
            for(int j=0; j<n-2; j++){
                if(arr[min]>=arr[j] && arr[min]<arr[j+1]){ // arr[min] ==> max
                    max = min+1;
                    min = j+2;
                    break;
                }
            }
        }
        System.out.println(min+" "+max);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        main.Solution(n,arr);
    }
}