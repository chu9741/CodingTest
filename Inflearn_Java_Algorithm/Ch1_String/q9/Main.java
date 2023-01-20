package Inflearn_Java_Algorithm.Ch1_String.q9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public long Solution(String st){
        st = st.replaceAll("[^0-9]", "");
        return Long.parseLong(st);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Main main = new Main();
        System.out.println(main.Solution(st));
    }
}