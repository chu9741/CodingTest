package Inflearn_Java_Algorithm.Ch1_String.q1_문자찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] array = input.readLine().split("");
        String s2= input.readLine();
        long count=0;
        for(String s : array){
            if(s.equalsIgnoreCase(s2))
                count++;
        }
        System.out.println(count);

    }
}
