package Inflearn_Java_Algorithm.Ch2_Array.q5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public void Solution(int cnt){
        int total=0;

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i =2; i<=cnt; i++){
            int mod=0;
            for(int j=1; j<=Math.sqrt(i); j++)
                if(i%j==0)
                    mod++;
            if(mod==1)
                total++;
            }
        System.out.println(total);
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        new Main().Solution(cnt);
    }
}