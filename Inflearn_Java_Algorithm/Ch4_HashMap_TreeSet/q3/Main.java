package Inflearn_Java_Algorithm.Ch4_HashMap_TreeSet.q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n, int k, int[] arr){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int total = n-k;
        HashMap<Integer,Integer> countHashMap =new HashMap<>();
        for(int i=0; i<k; i++){
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
        }
        countHashMap.put(0,hashMap.size());

        for(int j=0; j<n-k; j++){
            if(hashMap.get(arr[j])==1)
                hashMap.remove(arr[j]);
            else
                hashMap.put(arr[j],hashMap.get(arr[j])-1);

            hashMap.put(arr[j+k], hashMap.getOrDefault(arr[j+k],0)+1);
            countHashMap.put(j+1,hashMap.size());
        }

        for(int a : countHashMap.values()){
            System.out.print(a+" ");
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]= Integer.parseInt(st2.nextToken());
        }
        main.Solution(n,k,arr);
    }

}