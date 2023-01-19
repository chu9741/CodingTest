package Inflearn_Java_Algorithm.Ch1_String.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public ArrayList<String> Solution(String[] arr){
        ArrayList<String> res = new ArrayList<>();
        for(String word : arr){
           StringBuilder tmp = new StringBuilder(); // String tmp = "";
           char[] charArray=word.toCharArray();
           for(int j =charArray.length-1; j>=0; j--){
               tmp.append(charArray[j]);
           }
            res.add(String.valueOf(tmp));
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if(input<=20 && input>=3) {
            String[] arr = new String[input];
            for (int i = 0; i < input; i++) {
                arr[i] = br.readLine();
            }
            ArrayList<String> answer = main.Solution(arr);
            for(String s: answer)
                System.out.println(s);
        }
    }
}
