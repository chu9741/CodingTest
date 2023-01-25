package Inflearn_Java_Algorithm.Ch4_HashMap_TreeSet.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public void Solution(String[] S, String[] T){
        HashMap<String, Integer> tHashMap = new HashMap<>();
        HashMap<String, Integer> sHashMap = new HashMap<>();

        for (String t : T) {
            tHashMap.put(t, tHashMap.getOrDefault(t, 0) + 1);
        }

        for (int i=0; i<T.length; i++) {
            sHashMap.put(S[i], sHashMap.getOrDefault(S[i], 0) + 1);
        }

        int count=S.length-T.length+1;
        for(String st : tHashMap.keySet()){
            if(sHashMap.containsKey(st) && sHashMap.get(st).equals(tHashMap.get(st))) {
                continue;
            }
            count--;
            break;
        }

        for(int rt=T.length; rt<S.length; rt++){
            if(sHashMap.containsKey(S[rt])){
                sHashMap.put(S[rt],sHashMap.get(S[rt])+1);
            }
            else {
                sHashMap.put(S[rt], 1);
            }

            if(sHashMap.get(S[rt-T.length])>1){
                sHashMap.put(S[rt-T.length],sHashMap.get(S[rt-T.length])-1);
            }
            else {
                sHashMap.remove(S[rt-T.length]);
            }

            for(String st : tHashMap.keySet()){
                if(sHashMap.containsKey(st) && sHashMap.get(st).equals(tHashMap.get(st)))
                    continue;
                count--;
                break;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("");
        String[] T = br.readLine().split("");

        main.Solution(S,T);
    }
}