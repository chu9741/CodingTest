package Inflearn_Java_Algorithm.Ch1_String.q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public String Solution(StringTokenizer st){
        String max = st.nextToken();
        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            if(max.length()<word.length())
                max=word;
        }
        return max;
    }




    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Main main=new Main();

        System.out.println(main.Solution(st));
    }
}
