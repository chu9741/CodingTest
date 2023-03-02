import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> arrList = new ArrayList<>();
        // Arrays.sort(scoville);
        for(int s : scoville){
            // arrList.add(s);
            pq.offer(s);
        }
                
        while(pq.peek()<K && pq.size()>=2){
        
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();
            pq.offer(tmp1+(tmp2*2));
            
            if(tmp1==0 && tmp2==0)
                return -1;
            answer++;
            
        }
        
        if(pq.isEmpty() || pq.peek()<K)
            return -1;
        //스코빌 Sorting하고 K보다 작은 애들을 좀 고치면될거같은데        
        return answer;
    }
}