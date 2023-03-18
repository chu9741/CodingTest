import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int a=0; a<commands.length; a++){
            int i=commands[a][0];
            int j=commands[a][1];
            int k=commands[a][2];
            // int[] tmp = new int[j-i+1];
            ArrayList<Integer> tmp = new ArrayList<>();
            
            for(int b=i-1; b<j; b++){
                tmp.add(array[b]);
            }
            Collections.sort(tmp);
            
            answer[a]=tmp.get(k-1);
            
            
        }
        
        return answer;
    }
}