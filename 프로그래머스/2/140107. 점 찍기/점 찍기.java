import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long dd=(long)d*d;
        long kk=(long)k*k;
        long cnt=0;
        for(long i=0; i<=d/k; i++){
            long tmp = (long)Math.floor(Math.sqrt(dd-(i*i*kk))/Math.sqrt(kk));
            cnt+=tmp+1;
        }
        return cnt;
    }
}

