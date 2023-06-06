import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long cnt=0;
        long lr1 = r1;
        long lr2 = r2;
        for(long x=0; x<=r2; x++){

            // y는 r2, r1사이의 있는 값으로 설정해야함 
            long max = (long)Math.floor(Math.sqrt(lr2*lr2-x*x)); // r2 반지름 안쪽
            long min=0;
            if(r1>x){
                min = (long)Math.ceil(Math.sqrt(lr1*lr1-x*x)); // r1 반지름 바깥쪽
            }
            // System.out.println(max+" "+min);
            cnt+=max-min+1; 
        }    
      
        cnt=cnt*4-((r2-r1+1)*4);
        return cnt;
    }
}