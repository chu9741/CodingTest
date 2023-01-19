package Inflearn_Java_Algorithm.Ch1_String.q5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public String Solution(String st) {
        char[] arr = st.toCharArray();
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int asciiLt = arr[left];
            if ((asciiLt >= 65 && asciiLt <= 90 || asciiLt >= 97 && asciiLt <= 122)) {
                int asciiRt = arr[right];
                if((asciiRt >= 65 && asciiRt <= 90 || asciiRt >= 97 && asciiRt <= 122)){
                    char tmp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = tmp;
                    right--;
                    left++;
                }
                else
                    right--;
            }
            else
                left++;
        }
        return new String(arr);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Main main = new Main();
        System.out.println(main.Solution(st));
    }
}
