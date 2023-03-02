import java.util.*;

class Solution {
    public int solution(int[] citations) {
        //cit에 있는 값들은 인용횟수를 담았고 그리고 length는 논문의 수 
        int answer = 0;
        int max=0;
        
        for(int c : citations)
            max=Math.max(max,c);
        
        // max=Math.max()
        for(int i=0; i<max; i++){
            int count=0;
            for(int j : citations){
                if(i<=j)
                    count++;
            }
            // System.out.println(count);
            if(count>=i)
                answer=Math.max(i,answer);      
        }        
        return answer;
    }
}