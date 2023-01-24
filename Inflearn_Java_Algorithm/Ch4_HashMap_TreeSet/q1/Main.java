package Inflearn_Java_Algorithm.Ch4_HashMap_TreeSet.q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public void Solution(int num, String[] arr){
        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i=0; i<num; i++){
            if(hashMap.containsKey(arr[i]))
                hashMap.put(arr[i],hashMap.get(arr[i])+1);

            else hashMap.put(arr[i], 1);
        }

        int max=0;
        String maxAlphabet ="";

        for(String a : hashMap.keySet()){
            if(hashMap.get(a)>max){
                max=hashMap.get(a);
                maxAlphabet= a;
            }
        }
        System.out.println(maxAlphabet);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        main.Solution(num,arr);
    }

}