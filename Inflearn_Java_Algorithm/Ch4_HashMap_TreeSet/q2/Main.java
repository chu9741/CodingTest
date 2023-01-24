package Inflearn_Java_Algorithm.Ch4_HashMap_TreeSet.q2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

public class Main {

    public Boolean Solution(String[] a, String[] b){
        if(a.length!=b.length)
            return false;

        for(int i=0; i<a.length; i++){
            a[i]=a[i].toUpperCase();
            b[i]=b[i].toUpperCase();
        }

        HashMap<String, Integer> aHashMap = new HashMap<>();
        HashMap<String, Integer> bHashMap = new HashMap<>();

        for(String string : a){
            aHashMap.put(string,(aHashMap.getOrDefault(string, 1))+1);
        }
        for(String string : b){
            bHashMap.put(string,(bHashMap.getOrDefault(string, 1))+1);
        }

        for(String s : aHashMap.keySet()){
            if(!Objects.equals(aHashMap.get(s), bHashMap.get(s)))
                return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a= br.readLine().split("");
        String[] b= br.readLine().split("");

        boolean result = main.Solution(a,b);
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}