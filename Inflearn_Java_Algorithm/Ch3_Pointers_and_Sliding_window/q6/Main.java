package Inflearn_Java_Algorithm.Ch3_Pointers_and_Sliding_window.q6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n ,int k, String[] arr){
        int countZero =0, countOne=0;
        int max=0;
        int i=0;
        for(; i<n; i++){
            if(arr[i].equals("0")){
                countZero++;
            }
            else
                countOne++;

            if(countZero>k){
                max=countOne+countZero-1;
                break;
            }
        }

        int lt=0;

        for(int j=i; j<n; j++){
            countZero=k;
            if(arr[j].equals("0") && countZero>=k){
                while(arr[lt].equals("1")){
                    lt++;
                    countOne--;
                }
                lt++;
            }
            if(arr[j].equals("1")){
                countOne++;
            }
            int tmp= countZero+countOne;
            if(tmp>max) {
                max=tmp;
            }
        }
        System.out.println(max);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] arr= br.readLine().split(" ");

        main.Solution(n,k,arr);
    }

}