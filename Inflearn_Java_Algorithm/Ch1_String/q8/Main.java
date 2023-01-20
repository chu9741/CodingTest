package Inflearn_Java_Algorithm.Ch1_String.q8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public String Solution(String st){
        char[] arr=st.toCharArray();
        char[] alphaArr = new char[arr.length];

        for(int i=0; i<arr.length; i++){
            if(Character.isAlphabetic(arr[i]))
                alphaArr[i]=arr[i];
            else alphaArr[i]=' ';
        }

        String res = String.valueOf(alphaArr).replaceAll("\\s","");
        String resReverse = new StringBuilder(res).reverse().toString();
        if(res.equalsIgnoreCase(resReverse))
            return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Main main = new Main();
        System.out.println(main.Solution(st));
    }
}
