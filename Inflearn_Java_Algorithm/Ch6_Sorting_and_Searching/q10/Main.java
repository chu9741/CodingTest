package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int count(int[] arr, int capacity){
        int cnt=1;
        int i=0;
        for(int j=i+1; j< arr.length; j++){
            if(arr[j]-arr[i] >= capacity){
                cnt++;
                i=j;
            }
            else continue;
        }
        return cnt;
    }

    public void Solution(int n, int c, int[] arr){
        Arrays.sort(arr);
        int answer = 0;
        int rt = arr[n-1]-arr[0];
        int min = rt;

        for(int i=0; i<n-1; i++){
            if(arr[i+1]-arr[i]<min)
                min=arr[i+1]-arr[i];
        }
        int lt = min;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr,mid)<c){
                rt = mid-1;
            }
            else {
                answer=mid;
                lt= mid+1;
            }
        }
        System.out.println(answer);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        StringTokenizer st2 =new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        main.Solution(n,c,arr);
    }

}