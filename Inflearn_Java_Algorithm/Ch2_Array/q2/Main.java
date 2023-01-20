package Inflearn_Java_Algorithm.Ch2_Array.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public int Solution(int total, StringTokenizer st){
        int count =1;
        int lt = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(lt<num){
                count++;
                lt=num;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Main main = new Main();
        System.out.println(main.Solution(total,st));
    }
}