import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        int n=players.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(players[i],i);
        }
        
        for(String c : callings){
            int idx=map.get(c);
            map.put(c,map.get(c)-1);
            // System.out.println(idx);
            map.put(players[idx-1],map.get(players[idx-1])+1);
            
            String tmp =players[idx];
            players[idx]=players[idx-1];
            players[idx-1]=tmp;  
            // System.out.println(idx+players[idx]+" "+players[idx-1]);
            
        }
        
        // System.out.println(map.size());
        // for(int j=0; j<map.size(); j++){
        //     answer[j]=map.get(j);
        // }
        
        // System.out.println(players.length);
        return players;
    }
}