import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // brown = (가로+세로) * 2 - 4 
        
        int total = brown + yellow;
        for(int i=1;  i<=Math.sqrt(total); i++){
            for(int j=(int)Math.round(Math.sqrt(total)); j<total; j++){
                if(i*j == total && (j+i)*2-4 == brown){
                    // j>i니까 j=가로
                    // System.out.print(i+" "+j);
                    answer[0]=j;
                    answer[1]=i;
                }
            }
        }
        return answer;
    }
}