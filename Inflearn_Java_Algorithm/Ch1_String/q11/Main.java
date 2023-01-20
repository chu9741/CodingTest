package Inflearn_Java_Algorithm.Ch1_String.q11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public String Solution(String st){
        StringBuilder tmp = new StringBuilder();
        int count = 1;
        int len = st.length();

        for(int i=0; i<len; i++){
            if(st.charAt(i)==st.charAt(Math.min(i+1,len-1)) && i != len-1) {
                count++;
            }

            else if(i==len-1){
                tmp.append(st.charAt(i));
                if(st.charAt(i-1)==st.charAt(i)) {
                    tmp.append(count);
                }
            }
            else {
                tmp.append(st.charAt(i));
                if (count != 1) {
                    tmp.append(count);
                }
                count=1;
            }
        }
        return tmp.toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Main main = new Main();
        System.out.println(main.Solution(st));
    }
}
