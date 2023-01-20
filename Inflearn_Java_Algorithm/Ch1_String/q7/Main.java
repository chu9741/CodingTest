package Inflearn_Java_Algorithm.Ch1_String.q7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public boolean Solution(String st){
        String [] arr = st.split("");
        int i=0;
        for(; i<arr.length/2; i++){
            if(arr[i].equalsIgnoreCase(arr[arr.length-1-i])){
                continue;
            }
            else break;
        }
        return i == arr.length / 2;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Main main = new Main();
        if(main.Solution(st))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
