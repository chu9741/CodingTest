package Inflearn_Java_Algorithm.Ch2_Array.q6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public void Solution(ArrayList<String> arr, int cnt){
        ArrayList<Integer> newArr = new ArrayList<>();
        for(String s : arr) {
            String reverse = new StringBuilder(s).reverse().toString();
            int num = Integer.parseInt(reverse);
            int count = 0;

            if(num==1)
                continue;
            for(int i =2; i<=Math.sqrt(num); i++) {
                if (num %i == 0) {
                    count++;
                }
            }
            if(count==0)
                newArr.add(num);

        }
        for(int st : newArr){
            System.out.print(st+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        while (st.hasMoreTokens()){
            arr.add(st.nextToken());
        }
        main.Solution(arr,cnt);
    }
}