package Inflearn_Java_Algorithm.Ch1_String.q10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int[] Solution(String word, String character){
        int[] arr = new int[word.length()];

        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)==character.charAt(0)){
                arr[i]=0;
            }
            else{
                int count =1;
                while(word.charAt(Math.min((i+count),word.length()-1)) != character.charAt(0) && word.charAt(Math.max((i - count), 0)) != character.charAt(0)){
                    count++;
                }
                arr[i] = count;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Main main = new Main();
        String word = st.nextToken();
        String character = st.nextToken();
        for(int i : main.Solution(word,character))
            System.out.print(i+" ");
    }
}
