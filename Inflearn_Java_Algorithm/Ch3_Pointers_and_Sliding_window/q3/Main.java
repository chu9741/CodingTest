package Inflearn_Java_Algorithm.Ch3_Pointers_and_Sliding_window.q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n, int k, int[] arr){
        int max =0;
        for(int i=0; i<n-k; i++){
            int tmp=0;
            for(int j=i; j<i+k; j++){
                tmp += arr[j];
            }
            if(tmp>max)
                max=tmp;
        }
        System.out.println(max);
    }

    public void Solution2(int n, int k, int[] arr){
        int max=0;
        int total = 0;
        for(int a=0; a<k; a++)
            total+=arr[a];
        max=total;
        for(int i =0; i<n-k; i++){
            total-=arr[i];
            total+=arr[i+k];
            if(total>max)
                max= total;
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        main.Solution(n,k,arr);
        main.Solution2(n,k,arr);
    }

}