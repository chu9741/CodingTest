package Inflearn_Java_Algorithm.Ch2_Array.q7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    public void Solution(int cnt, String[] arr){
        int score =0;
        int pre =0 ;

        if(Objects.equals(arr[0],"1"))
            score+=++pre;

        for(int i =1; i<cnt; i++){
            if(Objects.equals(arr[i], "1")){
                if(Objects.equals(arr[i-1],"1")){
                    score+=++pre;
                }
                else {
                    score++;
                    pre=1;
                }
            }
            else pre=0;
        }
        System.out.println(score);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        new Main().Solution(cnt,arr);
    }
}