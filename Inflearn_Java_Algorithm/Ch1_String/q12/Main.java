package Inflearn_Java_Algorithm.Ch1_String.q12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public String Solution(int num, String st){
        StringBuilder res = new StringBuilder();
        for(int i=0; i<num; i++){
            String tmp = st.substring(i*7,(i+1)*7);
            StringBuilder asciiNum = new StringBuilder();

            for(char c : tmp.toCharArray()){
                if(c == '#')
                    asciiNum.append('1');
                else asciiNum.append('0');
            }
            res.append((char) Integer.parseInt(asciiNum.toString(),2));
        }
        return res.toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String st = br.readLine();
        Main main = new Main();
        System.out.println(main.Solution(num,st));
    }
}