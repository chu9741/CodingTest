package Inflearn_Java_Algorithm.Ch1_String.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public String Solution(String input)  {
        String[] arr=input.split("");
        List<String> list = new ArrayList<String>(100);
        for(String a : arr){
            if(a.equals(a.toUpperCase()))
                list.add(a.toLowerCase());
            else
                list.add(a.toUpperCase());
        }
        return String.join("",list);
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Main main = new Main();
        String answer = main.Solution(string);

        System.out.println(answer);

    }
}
