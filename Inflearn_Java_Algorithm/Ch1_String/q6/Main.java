package Inflearn_Java_Algorithm.Ch1_String.q6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public String Solution(String st){
        char[] arr=st.toCharArray();
        String newArr = "";
        Set<Character> set = new LinkedHashSet<>();
        for(char c : arr)
            set.add(c);

        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext())
            newArr+=iterator.next();

        return newArr;
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        System.out.println(main.Solution(st));
    }
}
