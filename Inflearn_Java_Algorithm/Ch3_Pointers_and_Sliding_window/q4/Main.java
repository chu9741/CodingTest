package Inflearn_Java_Algorithm.Ch3_Pointers_and_Sliding_window.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n, int m, int[] arr){
        int count=0;
        for(int i=0; i<n; i++){
            int total =0;
            for(int j=i; j<n; j++){
                total+=arr[j];
                if(total<m)
                    continue;
                else if (total==m) {
                    count++;
                    break;
                } else break;
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 =new StringTokenizer(br.readLine());

        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st2.nextToken());
        }
        main.Solution(n,m,arr);
    }

}