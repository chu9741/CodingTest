import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxA=0, maxB=0;
        for(int[] size : sizes){
            if(maxA<size[0] || maxA<size[1] || maxB<size[0] || maxB<size[1]){
                if((maxA>=size[1] && maxB>=size[0]) || (maxA>=size[0] && maxB>=size[1])){
                    continue;
                }else{
                    maxA= Math.max(Math.max(maxA,size[0]) ,Math.max(maxA,size[1]));
                    maxB= Math.min(Math.max(maxB,size[0]) ,Math.max(maxB,size[1]));
                }
            }
        }        
        
        answer=maxA*maxB;
        return answer;
    }
}